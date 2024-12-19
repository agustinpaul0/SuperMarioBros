package elementos.enemigos;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Spiny extends Enemigo {
	
	private static final int TICKS_PARA_ELIMINAR = 10;
	
	private boolean aterrizo;
	
	private boolean salioDelHuevo;
	
    @SuppressWarnings("exports")
	public Spiny(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
    	super(sprite, posicion, visitor, observerGrafico);
    	this.puntosOtorgadosPorEliminacion = 60;
    	this.puntosSustraidosPorMuerteCausada = 30;
    	this.ticksAnimacion = TICKS_PARA_ELIMINAR;
    	this.aterrizo = false;
    	this.salioDelHuevo = false;
    }

    public void establecerAterrizo(Boolean aterrizo) {
    	this.aterrizo = aterrizo;
    }
    
    public boolean obtenerAterrizo() {
    	return this.aterrizo;
    }
    
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarSpiny(this);
    }
    
    protected Sprite obtenerSpriteDeMuerte(FabricaSprites fabricaSprites) {
    	return fabricaSprites.obtenerSpinyMuerto();
    }

	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if (this.removido) {
			this.eliminarEntidadGrafica(fabricaSprites);
		} else if (this.obtenerAterrizo()) {
			if (!this.salioDelHuevo) {
				this.aterrizar(fabricaSprites);
			} else if (this.obtenerVelocidadDireccional().x < 0) {
				this.establecerSprite(fabricaSprites.obtenerSpinyReversoCaminando());
			} else if (this.obtenerVelocidadDireccional().x > 0) {
				this.establecerSprite(fabricaSprites.obtenerSpinyFrontalCaminando());
			}
		}
	}
	
	private void aterrizar(FabricaSprites fabricaSprites) {
		this.establecerSprite(fabricaSprites.obtenerSpinyReversoCaminando());
		this.actualizarHitboxYPosicion(fabricaSprites);
		this.salioDelHuevo = true;
	}
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {
		int x = this.obtenerPosicionLogica().x;
		int y = this.obtenerPosicionLogica().y + (this.obtenerAlto() - this.obtenerSprite().obtenerAltoImagen());
		int ancho = this.obtenerSprite().obtenerAnchoImagen();
		int alto = this.obtenerSprite().obtenerAltoImagen();
		Rectangle nuevaHitbox = new Rectangle(x, y, ancho, alto);
		Point nuevaPosicion = new Point(nuevaHitbox.getLocation());
		this.establecerHitbox(nuevaHitbox);
		this.establecerPosicion(nuevaPosicion);
	}
	
}
