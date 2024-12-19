package visitors;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorContextoMario implements Visitante {
	
	private ContextoMario miEntidad;
	
	protected DetectorDireccionColision detectorDireccionColision;
	
	protected GeneradorSonidos generadorSonidos;
	
	public VisitorContextoMario (ContextoMario miEntidad, GeneradorSonidos generadorSonidos) {
		this.generadorSonidos = generadorSonidos;
		this.miEntidad = miEntidad;
		this.detectorDireccionColision = new DetectorDireccionColision();
	}

	public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
		buzzyBeetle.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	public void visitarSpiny(Spiny spiny) {
		spiny.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	public void visitarGoomba(Goomba goomba) {
		goomba.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
		contextoKoopaTroopa.obtenerEstado().aceptarVisitante(this);
	}

	public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
		koopaEnCaparazon.obtenerContext().aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	public void visitarKoopaDefault(KoopaDefault koopaDefault) {
		koopaDefault.obtenerContext().aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	public void visitarLakitu(Lakitu lakitu) {
		lakitu.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
		piranhaPlant.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	public void visitarSuperChampinion(SuperChampinion superChampinion) {
		this.generadorSonidos.PowerupAgarrado();
		superChampinion.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}
	
	public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
		this.generadorSonidos.modoFuego();
		florDeFuego.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
		if (!champinionVerde.obtenerRemovido()) {
			this.miEntidad.ganarPuntos(champinionVerde.obtenerPuntosPorDefault());
			this.miEntidad.ganarVida();
			champinionVerde.establecerRemovido(true);
			generadorSonidos.recuperaVida();
		}
	}

	
	public void visitarEstrella(Estrella estrella) {
		estrella.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}

	public void visitarMoneda(Moneda monedas) {
		if (!monedas.obtenerRemovido()) {
			this.generadorSonidos.moneda();
    		this.miEntidad.ganarPuntos(monedas.obtenerPuntosPorDefault());
        	monedas.establecerRemovido(true);
    	}
	}

	public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
		if (this.detectorDireccionColision.choquePorAbajo(bloqueDePregunta, this.miEntidad)){
			if(!bloqueDePregunta.estaVacio()){
				if (bloqueDePregunta.obtenerPowerUp().obtenerHaceRuidoAlSalir()) {
					this.generadorSonidos.powerUpEmerge();
				}
				bloqueDePregunta.liberarPowerUp();
			} 
			generadorSonidos.golpeBloque();
        }
	}

	public void visitarLadrillo(Ladrillo ladrillo) {
		ladrillo.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
	}
	
	public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
		if (!princesaPeach.obtenerFueActivada()) {
			princesaPeach.establecerActivada(true);
			this.miEntidad.obtenerNivel().obtenerPartida().obtenerJuego().obtenerControladorVistas().obtenerHUD().detenerTiempo();
			this.generadorSonidos.detenerSonidoActual();
			this.generadorSonidos.establecerSonidoGanarJuego();
			this.generadorSonidos.reproducirSonidoActualPorUnicaVez();
			miEntidad.obtenerEstado().reiniciarEstado();
    		miEntidad.obtenerNivel().accionarPrincesa();
			this.detenerEntidades();
    		miEntidad.obtenerNivel().obtenerPartida().finalizarPartida();		        
		}
		
	}

	public void visitarBandera(Bandera bandera) {
		if (!bandera.obtenerFueActivada()) {
			this.miEntidad.obtenerNivel().obtenerPartida().obtenerJuego().obtenerControladorVistas().obtenerHUD().detenerTiempo();
			this.generadorSonidos.detenerSonidoActual();
			bandera.establecerActivada(true);
			bandera.actualizarSprite(this.miEntidad.obtenerNivel().obtenerPartida().obtenerFabricaSprites());
			bandera.obtenerObserverGrafico().actualizar();
			this.generadorSonidos.detenerSonidoActual();
			this.generadorSonidos.establecerSonidoTocarBandera();
			this.generadorSonidos.reproducirSonidoActualPorUnicaVez();
			this.miEntidad.obtenerNivel().accionarBandera();
			miEntidad.obtenerEstado().reiniciarEstado();
			Timer timer = new Timer(3000, new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		miEntidad.obtenerNivel().establecerCompletado(true);
		        }
		    });
			this.detenerEntidades();
		    timer.setRepeats(false);
		    timer.start();
		}
	}

	
	private void detenerEntidades() {
		miEntidad.obtenerNivel().obtenerPartida().desactivarMovimientoEnemigos();
		miEntidad.obtenerNivel().obtenerPartida().desactivarMovimientoPersonaje();
	}

	public void visitarTuberia(Tuberia tuberia) {
		this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(tuberia, this.miEntidad);
	}

	public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
		this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(bloqueSolido, this.miEntidad);
	}

	public void visitarContextoMario(ContextoMario contextoMario) {
	}

	public void visitarMarioDefault(MarioDefault marioDefault) {
	}
	
	public void visitarSuperMario(SuperMario superMario) {
	}

	public void visitarMarioFuego(MarioFuego marioFuego) {
	}

	public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
	}
	
	public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
	}
	
	public void visitarPiso(Piso piso) {
		this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(piso, this.miEntidad);
	}
	
	public void visitarBolaDeFuego(BolaDeFuego fireball) {}

	public void visitarVacio(Vacio vacio) {
	}
	
}
