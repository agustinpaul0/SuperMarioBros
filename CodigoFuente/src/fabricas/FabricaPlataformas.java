package fabricas;

import java.awt.Point;
import java.util.Random;
import elementos.enemigos.PiranhaPlant;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorDeNivel;
import generadores.GeneradorSonidos;
import juego.Nivel;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.*;

public class FabricaPlataformas {

	protected FabricaSprites fabricaSprites;
	
	protected FabricaEntidades fabricaEntidades;
	
    protected GeneradorDeNivel generadorDeNivel;
    
    protected GeneradorSonidos generadorSonidos;

	public FabricaPlataformas(FabricaSprites fabricaSprites, FabricaEntidades fabricaEntidades,
			GeneradorDeNivel generadorDeNivel, GeneradorSonidos generadorSonidos) {
		this.generadorSonidos = generadorSonidos;
		this.fabricaSprites = fabricaSprites;
		this.fabricaEntidades = fabricaEntidades;
		this.generadorDeNivel = generadorDeNivel;
	}

	private <T extends Plataforma> T crearPlataforma(T plataforma, Visitante visitante) {
		plataforma.establecerVisitante(visitante);
		ObserverGrafico observerGrafico = new ObserverGrafico(plataforma);
		plataforma.establecerObserverGrafico(observerGrafico);
		this.generadorDeNivel.obtenerPantallaDeJuego().agregarLabel(observerGrafico);
		return plataforma;
	}

	@SuppressWarnings("exports")
	public Vacio obtenerVacio(Point posicion) {
		Sprite sprite = this.fabricaSprites.obtenerVacio();
		Vacio vacio = new Vacio(sprite, posicion, null, null);
		return this.crearPlataforma(vacio, new VisitorVacio(vacio, this.generadorSonidos));
	}

	@SuppressWarnings("exports")
	public Ladrillo obtenerLadrillo(Point posicion) {
		Sprite sprite = this.fabricaSprites.obtenerLadrillo();
		Ladrillo ladrillo = new Ladrillo(sprite, posicion, null, null);
		return this.crearPlataforma(ladrillo, new VisitorLadrillo(ladrillo, this.generadorSonidos));
	}

	@SuppressWarnings("exports")
	public Tuberia obtenerTuberiaVacia(Point posicion, int altura) {
		Sprite sprite = this.fabricaSprites.obtenerTuberia(altura);
		Tuberia tuberia = crearTuberia(posicion, altura, sprite);
		return this.crearPlataforma(tuberia, new VisitorTuberia(tuberia, this.generadorSonidos));
	}

	@SuppressWarnings("exports")
	public Tuberia obtenerTuberiaConPiranhaPlant(Point posicion, Nivel nivel, int altura) {
		Sprite sprite = this.fabricaSprites.obtenerTuberia(altura);
		Tuberia tuberia = this.crearTuberia(posicion, altura, sprite);
		this.crearPlataforma(tuberia, new VisitorTuberia(tuberia,this.generadorSonidos));
		Point posicionPiranhaPlant = new Point(posicion.x, posicion.y - sprite.obtenerAltoImagen() + 150);
		PiranhaPlant piranhaPlant = this.fabricaEntidades.obtenerPiranhaPlant(posicionPiranhaPlant, sprite);
		nivel.agregarEnemigo(piranhaPlant);
		return tuberia;
	}

	private Tuberia crearTuberia(Point posicion, int altura, Sprite sprite) {
		int ancho = sprite.obtenerAnchoImagen();
		int alturaEscalada = altura * 50;
		return new Tuberia(sprite, posicion, null, null, alturaEscalada, ancho);
	}

	@SuppressWarnings("exports")
	public Bandera obtenerBandera(Point posicion) {
		Sprite sprite = this.fabricaSprites.obtenerBandera();
		Bandera bandera = new Bandera(sprite, posicion, null, null);
		return this.crearPlataforma(bandera, new VisitorBandera(bandera, this.generadorSonidos));
	}

	@SuppressWarnings("exports")
	public PrincesaPeach obtenerPrincesaPeach(Point posicion) {
		Sprite sprite = this.fabricaSprites.obtenerPrincesaPeach();
		PrincesaPeach princesaPeach = new PrincesaPeach(sprite, posicion, null, null);
		return this.crearPlataforma(princesaPeach, new VisitorPrincesa(princesaPeach, this.generadorSonidos));
	}

	@SuppressWarnings("exports")
	public BloqueDePregunta obtenerBloqueDePregunta(Point posicion, Nivel nivel) {
		Sprite sprite = this.fabricaSprites.obtenerBloqueDePreguntaEncendido();
		BloqueDePregunta bloqueDePregunta = new BloqueDePregunta(sprite, posicion, null, null, null);
		this.crearPlataforma(bloqueDePregunta, new VisitorBloqueDePregunta(bloqueDePregunta, this.generadorSonidos));
		this.generarPowerUpAleatorio(bloqueDePregunta, posicion, nivel);
		return bloqueDePregunta;
	}

	private void generarPowerUpAleatorio(BloqueDePregunta bloqueDePregunta, Point posicion, Nivel nivel) {
		int identificadorPowerUp = new Random().nextInt(8) + 1;
		switch (identificadorPowerUp) {
			case 2, 4, 6, 8 -> this.agregarMonedas(bloqueDePregunta, posicion, nivel, identificadorPowerUp);
			case 1 -> this.agregarPowerUp(bloqueDePregunta, this.fabricaEntidades.obtenerEstrella(posicion), nivel);
			case 3 -> this.agregarPowerUp(bloqueDePregunta, this.fabricaEntidades.obtenerChampinionVerde(posicion), nivel);
			case 5 -> this.agregarPowerUp(bloqueDePregunta, this.fabricaEntidades.obtenerFlorDeFuego(posicion), nivel);
			case 7 -> this.agregarPowerUp(bloqueDePregunta, this.fabricaEntidades.obtenerSuperChampinion(posicion), nivel);
		}
	}

	private void agregarMonedas(BloqueDePregunta bloqueDePregunta, Point posicion, Nivel nivel, int cantidad) {
		for (int i = 0; i < cantidad; i++) {
			Moneda moneda = this.fabricaEntidades.obtenerMonedas(posicion, true);
			this.agregarPowerUp(bloqueDePregunta, moneda, nivel);
		}
	}

	private void agregarPowerUp(BloqueDePregunta bloqueDePregunta, PowerUp powerUp, Nivel nivel) {
		nivel.agregarPowerUp(powerUp);
		bloqueDePregunta.agregarPowerUp(powerUp);
		powerUp.establecerBloquePregunta(bloqueDePregunta);
	}

	@SuppressWarnings("exports")
	public BloqueSolido obtenerBloqueSolido(Point posicion) {
		Sprite sprite = this.fabricaSprites.obtenerBloqueSolido();
		BloqueSolido bloqueSolido = new BloqueSolido(sprite, posicion, null, null);
		return this.crearPlataforma(bloqueSolido, new VisitorBloqueSolido(bloqueSolido, this.generadorSonidos));
	}

	@SuppressWarnings("exports")
	public Piso obtenerPiso(Point posicion) {
		Sprite sprite = this.fabricaSprites.obtenerPiso();
		Piso piso = new Piso(sprite, posicion, null, null);
		return this.crearPlataforma(piso, new VisitorPiso(piso, this.generadorSonidos));
	}
	
}
