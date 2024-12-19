package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class PiranhaPlant extends Enemigo {
	
	private static final int TICKS_PARA_ELIMINAR = 10;
	
    private boolean dentroTuberia;
    
    private int limiteInferior;
    
    private int limiteSuperior;

	@SuppressWarnings("exports")
	public PiranhaPlant(Sprite sprite, Point posicion, Visitante visitor,
    					ObserverGrafico observerGrafico) {
    	super(sprite, posicion, visitor, observerGrafico);
    	this.puntosOtorgadosPorEliminacion = 30;
    	this.puntosSustraidosPorMuerteCausada = 30;
    	this.limiteInferior = this.obtenerPosicionLogica().y;
    	this.limiteSuperior = this.obtenerPosicionLogica().y-150 ;
    	this.ticksAnimacion = TICKS_PARA_ELIMINAR;
    }

    public void establecerDentroTuberia() {
        this.dentroTuberia = true;
    }
    
    public void establecerFueraTuberia() {
    	this.dentroTuberia = false;
    }
    
    protected Sprite obtenerSpriteDeMuerte(FabricaSprites fabricaSprites) {
    	return fabricaSprites.obtenerPiranhaPlantMuerto();
    }
    
    public boolean enTuberia() {
    	return this.dentroTuberia;
    }
    
    @Override
    public void aplicarGravedad() {}
    
    public void aceptarVisitante (Visitante visitante) {
        visitante.visitarPiranhaPlant(this);
    }

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if (this.removido) {
			this.establecerVelocidadDireccional(new Point(0, 0));
			this.eliminarEntidadGrafica(fabricaSprites);
		} else {
			this.establecerSprite(fabricaSprites.obtenerPiranhaPlant());
		}
	}
	
	@Override
	public void mover() {
		if (this.obtenerPosicionLogica().y == this.limiteInferior) {
			this.moverHaciaArriba();
		} else if (this.obtenerPosicionLogica().y == this.limiteSuperior){
			this.moverHaciaAbajo();
		}
	}

	private void moverHaciaAbajo() {
		Point velocidad = new Point(0, 1);
    	this.establecerVelocidadDireccional(velocidad);
	}

	private void moverHaciaArriba() {
		Point velocidad = new Point(0, -1);
    	this.establecerVelocidadDireccional(velocidad);
	}

}