package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class ChampinionVerde extends PowerUp {
	
	@SuppressWarnings("exports")
	public ChampinionVerde(Sprite sprite, Point posicion, Visitante visitor, 					 
						   ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.esMovible = true;
		this.estaDentroDeBloqueDePreguntas = true;
		this.ticksHastaSalirDelBloque = 50;
	}
	
	public int obtenerPuntosPorDefault() {
		return 100;
	}
	
	public int obtenerPuntosPorSuper() {
		return this.obtenerPuntosPorDefault();
	}
	
	public int obtenerPuntosPorInvulnerable() {
		return this.obtenerPuntosPorDefault();
	}
	
	public int obtenerPuntosPorFuego() {
		return this.obtenerPuntosPorDefault();
	}

	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarChampinionVerde(this);
	}
	
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if (this.obtenerRemovido()) {
			this.eliminarEntidadGrafica(fabricaSprites);
		} else if (!this.estaDentroDeBloqueDePreguntas && obtenerContadorTicks() < this.ticksHastaSalirDelBloque) {
			this.establecerSprite(fabricaSprites.obtenerChampinionVerdeSaliendoDelBloqueDePreguntas());
			this.actualizarHitboxYPosicion();
		} else if (obtenerContadorTicks() >=  this.ticksHastaSalirDelBloque) {
			this.establecerSprite(fabricaSprites.obtenerChampinionVerde());
			this.actualizarHitboxYPosicion();
		}		
	}

}
