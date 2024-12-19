package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaEntidades;
import fabricas.FabricaSprites;
import juego.ConstantesGlobales;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Lakitu extends Enemigo {
    
	private static final int TICKS_PARA_ELIMINAR = 20;
	
	private static final int INTERVALO_PARA_DISPARAR = 300;
	
	private int contadorTicksDisparo;
	
	private FabricaEntidades fabricaEntidades;
	
	@SuppressWarnings("exports")
	public Lakitu(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico, FabricaEntidades fabricaEntidades) {
    	super(sprite, posicion, visitor, observerGrafico);
    	this.fabricaEntidades = fabricaEntidades;
    	this.puntosOtorgadosPorEliminacion = 60;
    	this.puntosSustraidosPorMuerteCausada = 0;
    	this.ticksAnimacion = TICKS_PARA_ELIMINAR;
    	this.contadorTicksDisparo = 0;
    }
    
    protected Sprite obtenerSpriteDeMuerte(FabricaSprites fabricaSprites) {
    	return fabricaSprites.obtenerLakituMuerto();
    }
    
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarLakitu(this);
    }

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
    	this.lanzarSpiny();
		if (this.removido) {
			this.eliminarEntidadGrafica(fabricaSprites);
		} else if (this.obtenerMirandoAlFrente()) {
			this.establecerSprite(fabricaSprites.obtenerLakituFrontalFueraDeLaNube());
		} else {
			this.establecerSprite(fabricaSprites.obtenerLakituReversoFueraDeLaNube());
		}
	}
    
	public void aplicarGravedad() {}
	
	public void lanzarSpiny() {
		if (this.contadorTicksDisparo < INTERVALO_PARA_DISPARAR) {
			this.contadorTicksDisparo++;
		} else {
			this.contadorTicksDisparo = 0;
			int posGraficaX = obtenerPosicionGrafica().x + (this.obtenerAncho() / 2);
			int posGraficaY = obtenerPosicionGrafica().y + (this.obtenerAlto());
			
			int posLogicaX = obtenerPosicionLogica().x + (obtenerAncho() / 2);
			int posLogicaY = obtenerPosicionLogica().y + (this.obtenerAlto());
			
			Point posicionGraficaSpiny = new Point(posGraficaX,posGraficaY);
			Point posicionLogicaSpiny = new Point(posLogicaX,posLogicaY);
			
			Spiny spiny = this.fabricaEntidades.obtenerSpiny(posicionLogicaSpiny);
			
			spiny.establecerPosicionGrafica(posicionGraficaSpiny);
			spiny.obtenerObserverGrafico().actualizar();
			
			this.obtenerNivel().agregarEnemigo(spiny);
		}
	}
	
    @Override
    public void invertirDireccion() {
    	if (this.removido) {
    		Point velocidad = new Point(0, 0);
    		this.establecerVelocidadDireccional(velocidad);
    	} else {
    		this.chequearChoquesConBordes();
    	}
    }

	private void chequearChoquesConBordes() {
		boolean chocoBordeIzquierdo = this.obtenerPosicionGrafica().x <=  0; 
		boolean chocoBordeDerecho = this.obtenerPosicionGrafica().x + this.obtenerAncho() <=  (ConstantesGlobales.PANEL_ANCHO + 75);
		if (chocoBordeIzquierdo) {
			this.chocarBordeIzquierdo();
		} else if (chocoBordeDerecho) {
			this.chocarBordeDerecho();
		}
	}
	
	private void chocarBordeIzquierdo() {
		boolean moviendoseHaciaElBordeIzquierdo = this.velocidadDireccional.x < 0;
		if (moviendoseHaciaElBordeIzquierdo) {
			Point velocidad = new Point(-this.obtenerVelocidadDireccional().x, this.obtenerVelocidadDireccional().y);
			this.establecerVelocidadDireccional(velocidad);
		}		
	}
	private void chocarBordeDerecho() {
		Point velocidad = new Point(-this.obtenerVelocidadDireccional().x, this.obtenerVelocidadDireccional().y);
		this.establecerVelocidadDireccional(velocidad);
	}

}