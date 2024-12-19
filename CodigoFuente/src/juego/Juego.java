package juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import elementos.Sprite;
import elementos.entidades.Jugable;
import ranking.Ranking;
import sensoresDeTeclas.SensorDeTeclasJuego;
import ventanas.ControladorVistas;
import ventanas.PantallaDeJuego;

public class Juego {
			
	private ControladorVistas controladorVistas;
	
	private Partida partida;
	
	private Ranking ranking;
	
	private String modoDeJuegoSeleccionado;
	
	public Juego() {
		//this.ranking.reiniciarRanking(); Uncomment this to regenerate the ranking
		this.ranking = cargarEstadoRanking();
	}
	
	public Sprite obtenerSpriteMario() {
		return this.partida.obtenerSpriteMario();
	}
	
	public Ranking obtenerRanking() {
		return this.ranking;
	}
	
	public ControladorVistas obtenerControladorVistas() {
		return this.controladorVistas;
	}
	
	public PantallaDeJuego obtenerPantallaDeJuego() {
		return this.controladorVistas.obtenerPantallaDeJuego();
	}
	
	public String obtenerModoDeJuegoSeleccionado() {
		return this.modoDeJuegoSeleccionado;
	}
	
	public Partida obtenerPartida() {
		return this.partida;
	}

	public void crearPartida(SensorDeTeclasJuego sensorDeTeclasJuego, String modo) {
		this.modoDeJuegoSeleccionado = modo;
		this.partida = new Partida(sensorDeTeclasJuego, this);
	}
	
	public void establecerControladorVistas(ControladorVistas controladorVistas) {
		this.controladorVistas = controladorVistas;
	}
	
	public void finalizarJuego() {
	    if(this.partida.obtenerNivel().obtenerPrincesaAccionada()) {
	    	this.iniciarTemporizadorSonidoFinDeJuego();
		}
	    this.mostrarPantallaIngresoNombre();
	    this.detenerBucleJugador();
	}

	private void iniciarTemporizadorSonidoFinDeJuego() {
		Timer temporizadorFinDeJuego = new Timer(3000, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	partida.obtenerGeneradorSonidos().detenerSonidoActual();
	            partida.obtenerGeneradorSonidos().establecerSonidoPerderJuego();
	            partida.obtenerGeneradorSonidos().reproducirSonidoActual();
	        }
	    });
	    temporizadorFinDeJuego.setRepeats(false);
	    temporizadorFinDeJuego.start();
	}

	private void mostrarPantallaIngresoNombre() {
	    this.controladorVistas.accionarPantallaIngresoNombre();
	}

	private void detenerBucleJugador() {
	    BucleJugador bucle = this.partida.obtenerBucleJugador();
	    bucle.detenerBucleJugador();
	}
	
	public void cierreDeJuego() {
		 this.ranking.guardarEstado();
	     mostrarMensaje("Gracias por jugar!");
	     System.exit(0);
	}
	
	private void mostrarMensaje(String mensaje) {
		JOptionPane.showMessageDialog(null,mensaje);
	}
	
	public Ranking cargarEstadoRanking() {
    	Ranking rankingARetornar = null;
    	try {
    		FileInputStream fileInputStream = new FileInputStream ("./src/puntos");
    		ObjectInputStream objectInputStream = new ObjectInputStream (fileInputStream);
    		rankingARetornar = (Ranking) objectInputStream.readObject();
    		objectInputStream.close();
    	} catch (FileNotFoundException e) {
            System.err.println("Error: El archivo de puntos no se encontró en la ruta especificada. Asegúrate de que el archivo './src/puntos' exista.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error: La clase 'Ranking' no se encontró durante la deserialización. Verifica que la clase exista y sea compatible.");
        } catch (IOException e) {
            System.err.println("Error de I/O al intentar leer el archivo de puntos. Verifica los permisos de lectura o si el archivo está corrupto.");
        } 
    	return rankingARetornar;
    }

}
