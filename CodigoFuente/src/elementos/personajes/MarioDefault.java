package elementos.personajes;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import juego.ConstantesGlobales;
import visitors.Visitante;
import visitors.VisitorMarioDefault;

public class MarioDefault implements EstadoMario {
	
	protected ContextoMario contexto;
	
	public void establecerContexto(ContextoMario contexto) {
		this.contexto = contexto;
	}
	
	public ContextoMario obtenerContexto() {
		return this.contexto;
	}
	
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.obtenerMarioDefaultFrontalQuieto();
	}
	
	public Visitante obtenerVisitante() {
		return new VisitorMarioDefault(this, this.contexto.obtenerNivel().obtenerPartida().obtenerGeneradorSonidos());
	}
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		int nuevaPosicionX = this.obtenerContexto().obtenerPosicionLogica().x;
		int nuevaPosicionY = this.obtenerContexto().obtenerPosicionLogica().y + (this.obtenerContexto().obtenerHitbox().height - obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen());
		Rectangle nuevaHitbox = new Rectangle(nuevaPosicionX, nuevaPosicionY, obtenerSpriteInicial(fabricaSprites).obtenerAnchoImagen(), obtenerSpriteInicial(fabricaSprites).obtenerAltoImagen());
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.obtenerContexto().establecerPosicion(nuevaPosicion);
		this.obtenerContexto().establecerHitbox(nuevaHitbox);
	}
	
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarMarioDefault(this);
    }

	public void actualizarSprite(FabricaSprites fabricaSprites) {
		Sprite aRetornar = null;
		if (bajoElNivelDelPiso()){
			aRetornar = fabricaSprites.obtenerMarioDefaultCayendo();
		} else if (mirandoAlFrente() && enElAire()) {
			aRetornar = fabricaSprites.obtenerMarioDefaultFrontalSaltando();
		} else if (!mirandoAlFrente() && enElAire()) {
			aRetornar = fabricaSprites.obtenerMarioDefaultReversoSaltando();
		} else if (avanzando()) {
			aRetornar = fabricaSprites.obtenerMarioDefaultFrontalCaminando();
		} else if (retrocediendo()){
			aRetornar = fabricaSprites.obtenerMarioDefaultReversoCaminando();
		} else if (mirandoAlFrente() && !avanzando()){
			aRetornar = fabricaSprites.obtenerMarioDefaultFrontalQuieto();
		} else if (!mirandoAlFrente() && !retrocediendo()){
			aRetornar = fabricaSprites.obtenerMarioDefaultReversoQuieto();
		} else {
			aRetornar = obtenerSpriteInicial(fabricaSprites);
		}
		this.contexto.establecerSprite(aRetornar);
	}
	
	public void realizarAccionEspecial() {		
	}
	
	public void actualizarTiempo() {
	}
	
	protected boolean enElAire() {
		return !this.contexto.obtenerColisionAbajo();
	}
	
	protected boolean avanzando() {
		return this.contexto.obtenerAvanzando();
	}
	
	protected boolean retrocediendo() {
		return this.contexto.obtenerRetrocediendo();
	}
	
	protected boolean mirandoAlFrente() {
		return this.contexto.obtenerMirandoAlFrente();
	}
	
	protected boolean bajoElNivelDelPiso() {
		return this.contexto.obtenerPosicionLogica().y > (ConstantesGlobales.NIVEL_PISO);
	}

	@Override
	public void reiniciarEstado() {
	}
	
}