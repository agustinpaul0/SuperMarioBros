package elementos.personajes;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import elementos.entidades.BolaDeFuego;
import fabricas.FabricaEntidades;
import fabricas.FabricaSprites;
import generadores.GeneradorSonidos;
import visitors.Visitante;
import visitors.VisitorMarioFuego;

public class MarioFuego extends SuperMario {
	
	protected FabricaEntidades fabricaEntidades;
	
	protected GeneradorSonidos generadorSonido;
	
	public MarioFuego(FabricaEntidades fabricaEntidades, GeneradorSonidos generadorSonido) {
		this.fabricaEntidades = fabricaEntidades;
		this.generadorSonido = generadorSonido;
	}
	
	@Override
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.obtenerMarioFuegoFrontalQuieto();
	}
	
	@Override
	
	public Visitante obtenerVisitante() {
		return new VisitorMarioFuego(this, this.contexto.obtenerNivel().obtenerPartida().obtenerGeneradorSonidos());
	}
	
	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarMarioFuego(this);
	}
	
	@Override
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		Rectangle nuevaHitbox = new Rectangle(this.obtenerContexto().obtenerPosicionLogica().x, this.obtenerContexto().obtenerPosicionLogica().y + (this.obtenerContexto().obtenerSprite().obtenerAltoImagen() - obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen()), obtenerSpriteInicial(fabricaSprites).obtenerAnchoImagen(), obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen());
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.obtenerContexto().establecerPosicion(nuevaPosicion);
		this.obtenerContexto().establecerHitbox(nuevaHitbox);
	}
	
	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		Sprite aRetornar = null;
		if (bajoElNivelDelPiso()){
			aRetornar = fabricaSprites.obtenerMarioFuegoCayendo();
		} else if (mirandoAlFrente() && enElAire()) {
			aRetornar = fabricaSprites.obtenerMarioFuegoFrontalSaltando();
		} else if (!mirandoAlFrente() && enElAire()){
			aRetornar = fabricaSprites.obtenerMarioFuegoReversoSaltando();
		} else if (avanzando()) {
			aRetornar = fabricaSprites.obtenerMarioFuegoFrontalCaminando();
		} else if (retrocediendo()){
			aRetornar = fabricaSprites.obtenerMarioFuegoReversoCaminando();
		} else if (mirandoAlFrente() && !avanzando()){
			aRetornar = fabricaSprites.obtenerMarioFuegoFrontalQuieto();
		} else if (!mirandoAlFrente() && !retrocediendo()){
			aRetornar = fabricaSprites.obtenerMarioFuegoReversoQuieto();
		} else {
			aRetornar = obtenerSpriteInicial(fabricaSprites);
		}
		this.contexto.establecerSprite(aRetornar);
	}
	
	@Override
	public void realizarAccionEspecial() {	
		lanzarBolaDeFuego();
	}

	private void lanzarBolaDeFuego() {
		int posGraficaX = obtenerContexto().obtenerPosicionGrafica().x + (this.contexto.obtenerAncho() / 2);
		int posGraficaY = obtenerContexto().obtenerPosicionGrafica().y;
		
		int posLogicaX = obtenerContexto().obtenerPosicionLogica().x + (this.contexto.obtenerAncho() / 2);
		int posLogicaY = obtenerContexto().obtenerPosicionLogica().y;
		
		Point posicionGraficaBolaDeFuego = new Point(posGraficaX,posGraficaY);
		Point posicionLogicaBolaDeFuego = new Point(posLogicaX,posLogicaY);
		
		Point velocidadDireccionalBolaDeFuego = new Point(0,0);
		
		if (this.obtenerContexto().obtenerMirandoAlFrente()) {
			velocidadDireccionalBolaDeFuego = new Point(15,0);
		} else {
			velocidadDireccionalBolaDeFuego = new Point(-15,0);
		}
		
		BolaDeFuego bolaDeFuego = this.fabricaEntidades.obtenerBolaDeFuego(posicionLogicaBolaDeFuego, velocidadDireccionalBolaDeFuego, this.contexto);
		
		bolaDeFuego.establecerPosicionGrafica(posicionGraficaBolaDeFuego);
		bolaDeFuego.obtenerObserverGrafico().actualizar();
		bolaDeFuego.establecerNivel(this.contexto.obtenerNivel());
		
		this.contexto.obtenerNivel().agregarBolaDeFuego(bolaDeFuego);
		
		this.generadorSonido.disparoBolaFuego();
	}
	
}
