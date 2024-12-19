
package juego;

import elementos.entidades.Jugable;
import fabricas.FabricaSprites;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class CoordinadorActualizacionesJugador {
	
	private ControladorMovimiento controladorMovimiento;
	
	private Jugable jugable;
	
	private FabricaSprites fabricaSprites;
	
	public CoordinadorActualizacionesJugador(SensorDeTeclasJuego sensorDeTeclasJuego, Jugable jugable, FabricaSprites fabricaSprites, Nivel nivel) {
		this.fabricaSprites = fabricaSprites;
		this.jugable = jugable;
		this.controladorMovimiento = new ControladorMovimiento(sensorDeTeclasJuego, nivel);
	}
	
	public void actualizar() {
		this.actualizarPosicion();
		this.jugable.actualizarSprite(fabricaSprites);
		this.actualizarObserverMario();
	}
	
	private void actualizarPosicion() {
		this.controladorMovimiento.actualizarPosicion();
	}
	
	private void actualizarObserverMario() {
		this.jugable.obtenerObserverGrafico().actualizar();
	}
	
	public ControladorMovimiento obtenerControladorDeMovimiento() {
		return this.controladorMovimiento;
	}

}