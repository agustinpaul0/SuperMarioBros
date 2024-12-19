package elementos.enemigos;

import java.awt.Point;
import java.awt.Rectangle;
import fabricas.FabricaSprites;
import visitors.Visitante;
import visitors.VisitorKoopaEnCaparazon;

public class KoopaEnCaparazon implements EstadoKoopa {

	protected ContextoKoopaTroopa contexto;
	
	private static final int VELOCIDAD_NECESARIA_PARA_MATAR_ENEMIGO = 20;
	
	public void establecerContexto(ContextoKoopaTroopa contexto) {
		this.contexto = contexto;
	}
	
	public ContextoKoopaTroopa obtenerContext() {
		return this.contexto;
	}
	
	public int obtenerVelocidadNecesariaParaMatarKoopa() {
		return VELOCIDAD_NECESARIA_PARA_MATAR_ENEMIGO;
	}
	
	public Visitante obtenerVisitante() {
		return new VisitorKoopaEnCaparazon(this, this.contexto.obtenerNivel().obtenerPartida().obtenerGeneradorSonidos());
	}
	
	public void invertirDireccion() {
		// No se invierte la dirección, porque es estático 
	}
	
	public void mover() {
		Point velocidad = new Point(0, 0);
		this.contexto.establecerVelocidadDireccional(velocidad);
	}
	
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarKoopaEnCaparazon(this);
    }

	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if (this.obtenerContext().obtenerRemovido()) {
			this.contexto.establecerSprite(fabricaSprites.obtenerKoopaTroopaMuerto());
			this.eliminarEntidadGrafica(fabricaSprites);
		} else {
			this.contexto.establecerSprite(fabricaSprites.obtenerKoopaTroopaCaparazonEstático()); 
		}
	}
	
	public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
    	this.obtenerContext().incrementarContadorTicks();
		if (this.obtenerContext().obtenerContadorTicks() ==  1){
			this.obtenerContext().establecerSprite(this.obtenerContext().obtenerSpriteDeMuerte(fabricaSprites));
			this.actualizarHitboxYPosicion(fabricaSprites);
		} else if (this.obtenerContext().obtenerContadorTicks() ==  this.obtenerContext().obtenerTicksAnimacion()) {
			this.obtenerContext().establecerSprite(fabricaSprites.obtenerSpriteInvisible());
			this.obtenerContext().obtenerNivel().removerEnemigo(this.contexto);
		}
	}
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		int x = this.obtenerContext().obtenerPosicionLogica().x;
		int y = this.obtenerContext().obtenerPosicionLogica().y + (this.obtenerContext().obtenerAlto() - this.obtenerContext().obtenerSprite().obtenerAltoImagen());
		int ancho = this.obtenerContext().obtenerSprite().obtenerAnchoImagen();
		int alto = this.obtenerContext().obtenerSprite().obtenerAltoImagen();
		Rectangle nuevaHitbox = new Rectangle(x, y, ancho, alto);
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.obtenerContext().establecerHitbox(nuevaHitbox);
		this.obtenerContext().establecerPosicion(nuevaPosicion);
	}
	
}
