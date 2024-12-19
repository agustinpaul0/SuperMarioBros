package elementos.enemigos;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class ContextoKoopaTroopa extends Enemigo {
	
	private EstadoKoopa estadoKoopa;
	
	private boolean cambiarEstado;

    @SuppressWarnings("exports")
	public ContextoKoopaTroopa(Sprite sprite, Point posicion, Visitante visitor, 
							   ObserverGrafico observerGrafico, KoopaDefault estado) {
    	super(sprite, posicion, visitor, observerGrafico);
    	this.estadoKoopa = estado;
    	this.puntosOtorgadosPorEliminacion = 90;
    	this.puntosSustraidosPorMuerteCausada = 45;
    	estado.establecerContexto(this);
    	this.cambiarEstado = false;
    	this.ticksAnimacion = 20;
    }

    public EstadoKoopa obtenerEstado() {
    	return this.estadoKoopa;
    }
    
    @Override
    public int obtenerTicksAnimacion() {
    	return this.ticksAnimacion;
    }
    
    protected Sprite obtenerSpriteDeMuerte(FabricaSprites fabricaSprites) {
    	return fabricaSprites.obtenerKoopaTroopaMuerto();
    }
    
    public void cambiarEstado(EstadoKoopa estado) {
        this.estadoKoopa = estado;
        estado.establecerContexto(this);
		this.cambiarEstado = true;
    }
    
    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarContextoKoopaTroopa(this);
    }
    
    @Override
    public void invertirDireccion() {
    	this.estadoKoopa.invertirDireccion();
    }
    
	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		this.estadoKoopa.actualizarSprite(fabricaSprites);
		if (this.cambiarEstado) {
			this.estadoKoopa.actualizarHitboxYPosicion(fabricaSprites);
			this.cambiarEstado = false;
		}
	}
	
	@Override
	public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
		this.establecerSprite(fabricaSprites.obtenerSpriteInvisible());
	}
    
	@Override
	public void mover() {
		if (removido) {
    		Point velocidad = new Point(0, 0);
    		this.establecerVelocidadDireccional(velocidad);
    	} else {
    		this.estadoKoopa.mover();
    	}
	}

}
