package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import elementos.entidades.NoJugable;
import fabricas.FabricaSprites;
import juego.ConstantesGlobales;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Enemigo extends NoJugable {
	
	protected int puntosOtorgadosPorEliminacion;
		
	protected int puntosSustraidosPorMuerteCausada;
	
	protected Enemigo(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.colisionAbajo = true;
	}
    
	public int obtenerVelocidadHorizontalEnemigo() {
		return ConstantesGlobales.VELOCIDAD_HORIZONTAL_ENEMIGO;
	}
	
    public int obtenerPuntosOtorgadosPorEliminacion() {
        return this.puntosOtorgadosPorEliminacion;
    }
    
    public int obtenerPuntosSustraidosPorMuerteCausada() {
        return this.puntosSustraidosPorMuerteCausada;
    }

    protected abstract Sprite obtenerSpriteDeMuerte(FabricaSprites fabricaSprites);
    
    protected void moverDerecha() {
    	Point velocidad = new Point(ConstantesGlobales.VELOCIDAD_HORIZONTAL_ENEMIGO, this.obtenerVelocidadDireccional().y);
    	this.establecerVelocidadDireccional(velocidad);
    	this.establecerMirandoAlFrente(true);
    }
    
    protected void moverIzquierda() {
    	Point velocidad = new Point(-ConstantesGlobales.VELOCIDAD_HORIZONTAL_ENEMIGO, this.obtenerVelocidadDireccional().y);
    	this.establecerVelocidadDireccional(velocidad);
    	this.establecerMirandoAlFrente(false);
    }
    
    public void invertirDireccion() {
    	if (removido) {
    		Point velocidad = new Point(0, 0);
    		this.establecerVelocidadDireccional(velocidad);
    	} else {
    		Point velocidad = new Point(-this.obtenerVelocidadDireccional().x, this.obtenerVelocidadDireccional().y);
    		this.establecerVelocidadDireccional(velocidad);
    	}
    }
    
    public void actualizarSprite(FabricaSprites fabricaSprites) {
    	if (this.removido) {
			this.eliminarEntidadGrafica(fabricaSprites);
			this.establecerVelocidadDireccional(new Point(0, 0));
		}
    }
    
    public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
    	this.incrementarContadorTicks();
		if (this.obtenerContadorTicks() ==  1){
			this.establecerSprite(obtenerSpriteDeMuerte(fabricaSprites));
			this.actualizarHitboxYPosicion();
		} else if (obtenerContadorTicks() ==  this.ticksAnimacion) {
			this.establecerSprite(fabricaSprites.obtenerSpriteInvisible());
			this.obtenerNivel().removerEnemigo(this);
			this.observerGrafico.establecerRemovido(true);
		}
	}
    
    public abstract void aceptarVisitante(Visitante visitante);

	public void mover() {
    	if (this.removido) {
    		Point velocidad = new Point(0, 0);
    		this.establecerVelocidadDireccional(velocidad);
    	} else if (this.obtenerVelocidadDireccional().x <=  0) {
    		this.moverIzquierda();
    	} else if (this.obtenerVelocidadDireccional().x > 0) {
    		this.moverDerecha();
    	}
	}
   
}
