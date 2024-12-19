package juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import elementos.Sprite;
import elementos.entidades.Jugable;
import fabricas.FabricaSprites;
import generadores.GeneradorDeNivel;
import generadores.GeneradorSonidos;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class Partida {
	
	private Juego juego;
		
	private BucleJugador bucleJugador;
	
	private BucleEntidadesNoJugables bucleEntidadesNoJugables;
	
	private MasterMind masterMind;
	
	private CoordinadorActualizacionesJugador coordinadorActualizacionesJugador;
	
	private GeneradorDeNivel generadorDeNivel;

	private Jugable jugable;
	
	private Nivel nivel;
			
	private int numeroNivelActual;
	
	public Partida(SensorDeTeclasJuego sensorDeTeclasJuego, Juego juego) {
		this.juego = juego;
		this.numeroNivelActual = 1;
		this.generadorDeNivel = new GeneradorDeNivel(this.juego.obtenerModoDeJuegoSeleccionado(), 
													 this.juego.obtenerPantallaDeJuego());
		this.obtenerGeneradorSonidos().detenerSonidoActual();
		this.obtenerGeneradorSonidos().establecerSonidoMusicaFondo();
		this.obtenerGeneradorSonidos().reproducirSonidoActual();
		this.nivel = generarNivel(this.numeroNivelActual, this);
		this.jugable = this.nivel.obtenerJugable();
		this.coordinadorActualizacionesJugador = new CoordinadorActualizacionesJugador(sensorDeTeclasJuego, 
																					   this.nivel.obtenerJugable(), 
																					   this.obtenerFabricaSprites(), 
																					   this.nivel);
		this.bucleJugador = new BucleJugador(this);
		this.masterMind = new MasterMind(this.obtenerFabricaSprites(), this.nivel);
		this.bucleEntidadesNoJugables = new BucleEntidadesNoJugables(this.masterMind);
	}
	
	public Jugable obtenerJugable() {
		return this.nivel.obtenerJugable();
	}
	
	public GeneradorSonidos obtenerGeneradorSonidos() {
		return this.generadorDeNivel.obtenerGeneradorSonidos();
	}
	
	public FabricaSprites obtenerFabricaSprites() {
		return this.generadorDeNivel.obtenerFabricaSprites();
	}
	
	public void actualizar() {
		this.coordinadorActualizacionesJugador.actualizar();
		this.analizarEstadoTiempo();
	}

	private void analizarEstadoTiempo() {
		int segundos = this.obtenerTiempoPartida().obtenerPrimerComponente();
		int milisegundos = this.obtenerTiempoPartida().obtenerSegundoComponente();
		if(segundos == 0 && milisegundos == 0) {
			this.matarJugadorPorFaltaDeTiempo();
		}
	}
		
	private void matarJugadorPorFaltaDeTiempo() {
		this.nivel.obtenerJugable().perderVida();
		this.juego.obtenerPartida().obtenerGeneradorSonidos().detenerSonidoActual();
		this.juego.obtenerPartida().obtenerGeneradorSonidos().establecerSonidoPerderVida();
		this.juego.obtenerPartida().obtenerGeneradorSonidos().reproducirSonidoActualPorUnicaVez();
     	this.reiniciarNivel();
	}

	private Par obtenerTiempoPartida() {
		return this.juego.obtenerControladorVistas().obtenerPantallaDeJuego().obtenerHUD().obtenerTiempo();
	}

	public BucleJugador obtenerBucleJugador(){
		return this.bucleJugador;
	}
	
	public void cambiarNivel() {
		this.eliminarNivelActual();
		this.generarNuevoNivel();
		this.actualizarReferenciasANivelActual();
		this.iniciarTemporizadorCambioDeNivel();
	}

	private void eliminarNivelActual() {
		this.juego.obtenerControladorVistas().eliminarNivelActual();
	}
	
	private void generarNuevoNivel() {
		this.numeroNivelActual++;
		this.juego.obtenerControladorVistas().cambiarNivel();
		this.nivel = this.generarNivel(this.numeroNivelActual, this);
		this.nivel.establecerJugable(this.jugable);
	}
	
	private void actualizarReferenciasANivelActual() {
		this.coordinadorActualizacionesJugador.obtenerControladorDeMovimiento().actualizarNivel(this.nivel);
		this.masterMind.cambiarNivel(this.nivel);
	}
	
	private void iniciarTemporizadorCambioDeNivel() {
	    int duracionEntreNiveles = this.juego.obtenerControladorVistas().obtenerDuracionPantallaEntreNiveles();
	    Timer temporizadorCambio = new Timer(duracionEntreNiveles, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	obtenerGeneradorSonidos().detenerSonidoActual();
	        	obtenerGeneradorSonidos().establecerSonidoMusicaFondo();
	        	obtenerGeneradorSonidos().reproducirSonidoActual();
	        }
	    });
	    temporizadorCambio.setRepeats(false);
	    temporizadorCambio.start();
	}

	public void reiniciarNivel() {
		this.eliminarNivelActual();
		this.generarNivelActualNuevamente();
		this.actualizarReferenciasANivelActual();
	    this.iniciarTemporizadorCambioDeNivel();
	}

	private void generarNivelActualNuevamente() {
		this.juego.obtenerControladorVistas().reiniciarNivel();
		this.nivel = this.generarNivel(numeroNivelActual, this);
		this.nivel.establecerJugable(this.jugable);
	}
	
	public void finalizarPartida() {
		this.numeroNivelActual = 1;
		this.detenerBucleJuego();
		this.detenerBucleEntidadesNoJugables();
	}
	
	public Nivel obtenerNivel(){
		return nivel;
	}
	
	private void detenerBucleJuego( ) {
		this.juego.finalizarJuego();		
	}

	private void detenerBucleEntidadesNoJugables() {
		this.bucleEntidadesNoJugables.detenerBucleEntidadesNoJugables();
	}

	private Nivel generarNivel(int numeroNivelActual, Partida partida) {
		return this.generadorDeNivel.generarNivel(numeroNivelActual, partida);
	}
	
	public int obtenerNumeroDeNivelActual() {
		return this.numeroNivelActual;
	}
	
	public GeneradorDeNivel obtenerGeneradorDeNivel() {
		return this.generadorDeNivel;
	}
	
	public Juego obtenerJuego() {
		return this.juego;
	}

	public Sprite obtenerSpriteMario() {
		return this.obtenerFabricaSprites().obtenerMarioDefaultFrontalQuieto();
	}
		
	public void desactivarMovimientoEnemigos() {
		this.masterMind.desactivarMovimientoEnemigos();
	}

	public void activarMovimientoEnemigos() {
		this.masterMind.activarMovimientoEnemigos();
	}
	
	public void desactivarMovimientoPersonaje() {
		this.coordinadorActualizacionesJugador.obtenerControladorDeMovimiento().desactivarMovimientoPersonaje();
	}

	public void activarMovimientoPersonaje() {
		this.coordinadorActualizacionesJugador.obtenerControladorDeMovimiento().activarMovimientoPersonaje();
	}

}
