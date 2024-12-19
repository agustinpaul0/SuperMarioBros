package elementos.plataformas;

import java.awt.Point;
import java.util.LinkedList;
import elementos.Sprite;
import elementos.powerUps.PowerUp;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class BloqueDePregunta extends Plataforma {
	
	protected LinkedList<PowerUp> coleccionPowerUps;
	
	@SuppressWarnings("exports")
	public BloqueDePregunta (Sprite sprite, Point pos, Visitante visitor, PowerUp powerUp,
							 ObserverGrafico observerGrafico) {
		super(sprite,pos,visitor,observerGrafico);
		this.coleccionPowerUps = new LinkedList<>();
		this.agregarPowerUp(powerUp);	}
	
	public PowerUp obtenerPowerUp() {
		return this.coleccionPowerUps.getLast();
	}
	
	public void agregarPowerUp (PowerUp powerUp) {
		if (powerUp !=  null) {
			this.coleccionPowerUps.add(powerUp);
		}
	}
	
	public PowerUp removerPowerUp() {
		return this.coleccionPowerUps.removeLast();
	}
	
	public void aceptarVisitante (Visitante visitante) {
		visitante.visitarBloqueDePregunta(this);
	}

	public PowerUp liberarPowerUp() {
		PowerUp powerUpARemover = null;
		if (!this.estaVacio()) {
			powerUpARemover = this.removerPowerUp();
			powerUpARemover.establecerEstaDentroDeBloqueDePreguntas(false);
		}
		return powerUpARemover;
	}
	
	@Override
	public  void actualizarSprite(FabricaSprites fabricaSprites) {
		if (this.estaVacio()) {
			this.establecerSprite(fabricaSprites.obtenerBloqueDePreguntaApagado());
		}
	}

	public boolean estaVacio() {
		return this.coleccionPowerUps.isEmpty();
	}
	
}

