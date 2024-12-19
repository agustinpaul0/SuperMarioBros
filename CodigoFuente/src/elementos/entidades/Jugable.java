package elementos.entidades;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import juego.ConstantesGlobales;
import juego.Partida;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Jugable extends Entidad  {
	
	protected Partida partida;
	
	protected int vidas;
	
	protected int puntos;
	
	private boolean retrocediendo;
	
	private boolean avanzando;
	
	private int desplazamiento;
	
	protected Jugable(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.retrocediendo = false;
		this.avanzando = false;
		this.vidas = 3;
		this.puntos = 0;
		this.desplazamiento = 0;
	}

	
	public void establecerPartida(Partida partida) {
		this.partida = partida;
	}
	
	@SuppressWarnings("exports")
	@Override
	public void establecerPosicion (Point posicion) {
		int desplazamientoX = posicion.x - this.posicionLogica.x;
		if (this.posicionGrafica.x + desplazamientoX > ConstantesGlobales.MITAD_PANTALLA) {
			this.desplazamiento +=  desplazamientoX;
		} else {
			Point nuevaPosicionGrafica = new Point (this.posicionGrafica.x + desplazamientoX, this.posicionLogica.y);
			this.posicionGrafica = nuevaPosicionGrafica;
		}
		this.posicionLogica = posicion;
	}
	
	public void establecerRetrocediendo(boolean retrocediendo) {
		this.retrocediendo = retrocediendo;
	}
	
	public void establecerAvanzando(boolean avanzando) {
		this.avanzando = avanzando;
	}
	
	public void establecerDesplazamiento(int desplazamiento) {
		this.desplazamiento = desplazamiento;
	}

	public int obtenerVidas() {
		return this.vidas;
	}
	
	public int obtenerPuntos() {
		return this.puntos;
	}
	
	public boolean obtenerAvanzando() {
		return this.avanzando;
	}
	public boolean obtenerRetrocediendo() {
		return this.retrocediendo;
	}
	
	public int obtenerDesplazamiento() {
		return this.desplazamiento;
	}
	
	public void ganarVida() {
		this.vidas++;
	}
	
	public void perderVida() {
		this.vidas--;
		if (this.vidas ==  0) { 
			this.muerte();
		}
	}
	
	public void ganarPuntos(int puntos) {
		this.puntos +=  puntos; 
	}
	
	public void perderPuntos(int puntos) {
		if (puntos > this.puntos) {
			this.puntos = 0;
		} else {
			this.puntos -=  puntos;
		}
	}
	
	public abstract void reiniciarEstado();
	
	public void retrotraerMovimientoHorizontal(int posX) {
		Point nuevaPosicionHitbox = new Point(posX, this.obtenerHitbox().y);
        this.moverHitbox(nuevaPosicionHitbox);
        Point nuevaPosicion = new Point(posX, this.obtenerPosicionLogica().y);
		this.establecerPosicion(nuevaPosicion);
        this.establecerVelocidadDireccional(new Point(0, obtenerVelocidadDireccional().y));
	}
	
	@Override
	public void retrotraerMovimientoVertical(int posY) {
		Point nuevaPosicion = new Point(this.obtenerHitbox().x, posY);
		this.moverHitbox(nuevaPosicion);
		this.establecerPosicion(nuevaPosicion);
	}
	
	public void muerte() {
		this.miNivel.obtenerPartida().obtenerJuego().finalizarJuego();
	}
	
	public void rebotar() {
		Point nuevaVelocidad = new Point(this.obtenerVelocidadDireccional().x, -15);
		this.establecerVelocidadDireccional(nuevaVelocidad);
	}
	
	public abstract void actualizarSprite(FabricaSprites fabricaSprites);

	public abstract void realizarAccionEspecial();
	
	
}
