package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Estrella extends PowerUp {
	
	protected static final int TIEMPO_DURACION = 10;
	
	@SuppressWarnings("exports")
	public Estrella(Sprite sprite,Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.esMovible = true;
		this.estaDentroDeBloqueDePreguntas = true;
		this.ticksHastaSalirDelBloque = 50;
	}
	
	public int obtenerPuntosPorDefault() {
		return 20;
	}
	
	public int obtenerPuntosPorSuper() {
		return 30;
	}
	
	public int obtenerPuntosPorInvulnerable() {
		return 35;
	}
	
	public int obtenerPuntosPorFuego() {
		return this.obtenerPuntosPorSuper();
	}

	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if (this.obtenerRemovido()) {
			this.eliminarEntidadGrafica(fabricaSprites);
		} else if (!this.estaDentroDeBloqueDePreguntas && obtenerContadorTicks() < this.ticksHastaSalirDelBloque) {
			this.establecerSprite(fabricaSprites.obtenerEstrellaApagada());
			this.actualizarHitboxYPosicion();
		} else if (obtenerContadorTicks() >=  this.ticksHastaSalirDelBloque) {
			this.establecerSprite(fabricaSprites.obtenerEstrellaEncendida());
			this.actualizarHitboxYPosicion();
		}		
	}

	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarEstrella(this);
	}
}
