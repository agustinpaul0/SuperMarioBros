package elementos;

import java.awt.Point;
import java.awt.Rectangle;

import juego.Nivel;
import observers.ObserverGrafico;
import visitors.*;

public abstract class ElementoDeJuego implements Visitado {
	
	protected Sprite sprite;
	
	protected Rectangle hitbox;
	
	protected Point posicionLogica;

	protected Point posicionGrafica;
	
	protected Visitante visitante;
	
    protected Nivel miNivel;
    
    protected ObserverGrafico observerGrafico;
    
    protected boolean removido;
    
	protected boolean debeMantenerseSiempreEnPantalla;
	
	protected boolean visiblesEnPantalla;
	
	protected ElementoDeJuego(Sprite sprite, Point posicion, Visitante visitante, ObserverGrafico observerGrafico) {
		this.sprite = sprite;
		Point posicionConsiderandoSprite = this.obtenerPosicionConsiderandoSprite(posicion, sprite);
		this.posicionLogica = posicionConsiderandoSprite;
		this.posicionGrafica = posicionConsiderandoSprite;
		this.visitante = visitante;
		this.observerGrafico = observerGrafico;
		this.removido = false;
		int ancho = sprite.obtenerAnchoImagen();
		int alto = sprite.obtenerAltoImagen();
		int x =  posicionConsiderandoSprite.x;
		int y = posicionConsiderandoSprite.y;
		this.hitbox = new Rectangle(x, y, ancho, alto);
		this.debeMantenerseSiempreEnPantalla = false;
		this.visiblesEnPantalla=false;
	}
	
	private Point obtenerPosicionConsiderandoSprite(Point posicion, Sprite sprite) {
		return new Point(posicion.x, posicion.y + (50 - sprite.obtenerAltoImagen()));
	}
	
	public void establecerSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	@SuppressWarnings("exports")
	public void establecerPosicion(Point posicion) {
		int desplazamientoX = posicion.x - this.posicionLogica.x;
		Point nuevaPosicionGrafica = new Point (this.posicionGrafica.x + desplazamientoX, posicion.y);
		this.posicionGrafica = nuevaPosicionGrafica;
		this.posicionLogica = posicion;
	}
	
	@SuppressWarnings("exports")
	public void establecerPosicionLogica(Point posicion) {
		this.posicionLogica = posicion;
	}
	
	@SuppressWarnings("exports")
	public void establecerPosicionGrafica(Point posicion) {
		this.posicionGrafica = posicion;
	}
	
	public void establecerVisitante(Visitante visitor) {
		this.visitante = visitor;
	}
	
	public void establecerNivel (Nivel nivel) {
		this.miNivel = nivel;
	}
	
	public void establecerObserverGrafico(ObserverGrafico observerGrafico) {
		this.observerGrafico = observerGrafico;
	}
	
	public void establecerRemovido(boolean removido) {
		this.removido = removido;
	}
	
	public void establecerVisibleEnPantalla(boolean visbleEnPantalla) {
		this.visiblesEnPantalla = visbleEnPantalla;
	}
	
	public void establecerDebeMantenerseSiempreEnPantalla(boolean debeMantenerseSiempreEnPantalla) {
		this.debeMantenerseSiempreEnPantalla = debeMantenerseSiempreEnPantalla;
	}
	
	public Sprite obtenerSprite() {
		return this.sprite;
	}
	
	@SuppressWarnings("exports")
	public Rectangle obtenerHitbox() {
		return this.hitbox;
	}
	
	@SuppressWarnings("exports")
	public Point obtenerPosicionLogica() {
		return this.posicionLogica;
	}
	
	@SuppressWarnings("exports")
	public Point obtenerPosicionGrafica() {
		return this.posicionGrafica;
	}
	
	public Visitante obtenerVisitante() {
		return this.visitante;
	}
	
    public Nivel obtenerNivel() {
    	return this.miNivel;
    }
	
	public int obtenerAncho() {
		return this.hitbox.width;
	}
	
	public int obtenerAlto() {
		return this.hitbox.height;
	}
	
	public ObserverGrafico obtenerObserverGrafico() {
		return this.observerGrafico;
	}
	
	public boolean obtenerRemovido() {
		return this.removido;
	}
	
	public boolean obtenerDebeMantenerseSiempreEnPantalla() {
		return this.debeMantenerseSiempreEnPantalla;
	}

	public boolean obtenerVisibleEnPantalla() {
		return this.visiblesEnPantalla;
	}
	
	@SuppressWarnings("exports")
	public void moverHitbox(Point nuevaPosicion) {
		this.hitbox.setLocation(nuevaPosicion);
	}
	
	public boolean huboColision(ElementoDeJuego elemento) {
		return this.hitbox.intersects(elemento.obtenerHitbox());
	}
	
}
