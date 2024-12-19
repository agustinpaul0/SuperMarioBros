package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class SuperChampinion extends PowerUp {
	
	@SuppressWarnings("exports")
	public SuperChampinion(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.esMovible = true;
		this.estaDentroDeBloqueDePreguntas = true;
		this.ticksHastaSalirDelBloque = 50;
	}
	
	public int obtenerPuntosPorDefault() {
		return 10;
	}
	
	public int obtenerPuntosPorSuper() {
		return 50;
	}
	
	public int obtenerPuntosPorInvulnerable() {
		return this.obtenerPuntosPorSuper();
	}
	
	public int obtenerPuntosPorFuego() {
		return this.obtenerPuntosPorSuper();
	}

	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarSuperChampinion(this);
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if (this.obtenerRemovido()) {
			this.eliminarEntidadGrafica(fabricaSprites);
		} else{
			if (!this.estaDentroDeBloqueDePreguntas && obtenerContadorTicks() < this.ticksHastaSalirDelBloque) {
				this.establecerSprite(fabricaSprites.obtenerSuperChampinionSaliendoDelBloqueDePreguntas());
				this.actualizarHitboxYPosicion();
			} else if (obtenerContadorTicks() >=  this.ticksHastaSalirDelBloque) {
				this.establecerSprite(fabricaSprites.obtenerSuperChampinionQuieto());
				this.actualizarHitboxYPosicion();
			} 
		}
	}
	
}
