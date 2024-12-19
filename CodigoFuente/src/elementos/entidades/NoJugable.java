package elementos.entidades;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class NoJugable extends Entidad {
				
	protected NoJugable(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
	}

	public abstract void mover();
    
    public abstract void invertirDireccion();
	
	public void retrotraerMovimientoHorizontal(int posX) {
		Point nuevaPosicion = new Point(posX, this.obtenerHitbox().y);
        this.moverHitbox(nuevaPosicion);
		this.establecerPosicion(nuevaPosicion);
		this.invertirDireccion();
	}
	
	public void actualizarHitboxYPosicion() {
		int nuevaPosX = this.obtenerPosicionLogica().x;
		int nuevaPosY = this.obtenerPosicionLogica().y + (this.obtenerAlto() - this.obtenerSprite().obtenerAltoImagen());
		int nuevoAncho = this.obtenerSprite().obtenerAnchoImagen();
		int nuevoAlto = this.obtenerSprite().obtenerAltoImagen();
		this.establecerHitbox(new Rectangle(nuevaPosX, nuevaPosY, nuevoAncho, nuevoAlto));
		this.establecerPosicion(this.obtenerHitbox().getLocation());
	}
	
	public abstract void aceptarVisitante(Visitante visitante);
	
	public abstract void actualizarSprite(FabricaSprites fabricaSprites);
	
	protected abstract void eliminarEntidadGrafica(FabricaSprites fabricaSprites);
	
}

