package elementos.entidades;

import java.awt.Point;
import java.awt.Rectangle;

import elementos.ElementoDeJuego;
import elementos.Sprite;
import juego.ConstantesGlobales;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Entidad extends ElementoDeJuego {
    
    protected Point velocidadDireccional;
        
	protected boolean colisionAbajo;
	
	protected boolean colisionArriba;
	
	protected int contadorTicks;
	
	protected int ticksAnimacion;
	
	protected boolean mirandoAlFrente;
	
	protected static final int VELOCIDAD_MAXIMA_DE_CAIDA = 24;
	
    protected Entidad(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.colisionAbajo = true;
		this.colisionArriba = false;
		this.velocidadDireccional = new Point(0,0);
		this.contadorTicks = 0;
		this.ticksAnimacion = 60;
		this.mirandoAlFrente = true;
	}

    @SuppressWarnings("exports")
    public void establecerHitbox(Rectangle hitbox) {
    	this.hitbox = hitbox;
    }
    
    @SuppressWarnings("exports")
	public void establecerVelocidadDireccional(Point velocidadDireccional) {
        this.velocidadDireccional = velocidadDireccional;
    }
    
    public void establecerColisionAbajo(boolean colisionAbajo) {
		this.colisionAbajo = colisionAbajo;
	}
    
    public void establecerColisionArriba(boolean colisionArriba) {
    	this.colisionArriba = colisionArriba;
    }
    
    public void establecerMirandoAlFrente(boolean mirandoAlFrente) {
    	this.mirandoAlFrente = mirandoAlFrente;
    }
    
    @SuppressWarnings("exports")
    public Point obtenerVelocidadDireccional() {
    	return this.velocidadDireccional;
    }
    
    public boolean obtenerColisionAbajo() {
    	return this.colisionAbajo;
    }
    
    public int obtenerContadorTicks() {
    	return this.contadorTicks;
    }
    
    public int obtenerTicksAnimacion() {
    	return this.ticksAnimacion;
    }
    
    public boolean obtenerMirandoAlFrente() {
    	return this.mirandoAlFrente;
    }
    
    public abstract void retrotraerMovimientoHorizontal(int posX);
	
	public void retrotraerMovimientoVertical(int posY) {
		Point nuevaPosicion = new Point(this.obtenerHitbox().x, posY);
		this.moverHitbox(nuevaPosicion);
		this.establecerPosicion(nuevaPosicion);
		this.establecerVelocidadDireccional(new Point(obtenerVelocidadDireccional().x, 0));
	}
    
	public void incrementarContadorTicks() {
		this.contadorTicks++;
	}
	
	public void aplicarGravedad() {
		if (this.obtenerVelocidadDireccional().y < VELOCIDAD_MAXIMA_DE_CAIDA){
			Point nuevaVelocidad = new Point(this.obtenerVelocidadDireccional().x, this.obtenerVelocidadDireccional().y + ConstantesGlobales.GRAVEDAD);
			this.establecerVelocidadDireccional(nuevaVelocidad);
		}
	}
	
}
