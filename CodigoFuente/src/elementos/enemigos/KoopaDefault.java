package elementos.enemigos;

import java.awt.Point;

import fabricas.FabricaSprites;
import visitors.Visitante;
import visitors.VisitorKoopaDefault;

public class KoopaDefault implements EstadoKoopa {
	
	protected ContextoKoopaTroopa contexto;
	
	public void establecerContexto(ContextoKoopaTroopa contexto) {
		this.contexto = contexto;
	}
	
	public ContextoKoopaTroopa obtenerContext() {
		return this.contexto;
	}
	
	public Visitante obtenerVisitante() {
		return new VisitorKoopaDefault(this, this.contexto.obtenerNivel().obtenerPartida().obtenerGeneradorSonidos());
	}
	
	public void invertirDireccion() {
    	Point velocidad = new Point(-this.contexto.obtenerVelocidadDireccional().x, this.contexto.obtenerVelocidadDireccional().y);
    	this.contexto.establecerVelocidadDireccional(velocidad);
    }

    public void aceptarVisitante(Visitante visitante) {
        visitante.visitarKoopaDefault(this);
    }

	public void actualizarSprite(FabricaSprites fabricaSprites) {
		boolean mirandoAlFrente = contexto.obtenerMirandoAlFrente();
		if (this.obtenerContext().obtenerRemovido()) {
			this.obtenerContext().establecerVelocidadDireccional(new Point(0, 0));
			this.eliminarEntidadGrafica(fabricaSprites);
		} else if (mirandoAlFrente) {
			this.obtenerContext().establecerSprite(fabricaSprites.obtenerKoopaTroopaDefaultFrontalCaminando());
		} else {
			this.obtenerContext().establecerSprite(fabricaSprites.obtenerKoopaTroopaDefaultReversoCaminando());
		}
	}
	
	public void eliminarEntidadGrafica(FabricaSprites fabricaSprites) {
    	this.obtenerContext().incrementarContadorTicks();
		if (this.obtenerContext().obtenerContadorTicks() ==  1){
			this.obtenerContext().establecerSprite(this.obtenerContext().obtenerSpriteDeMuerte(fabricaSprites));
			this.actualizarHitboxYPosicion(fabricaSprites);
		} else if (this.obtenerContext().obtenerContadorTicks() ==  this.obtenerContext().obtenerTicksAnimacion()) {
			this.obtenerContext().establecerSprite(fabricaSprites.obtenerSpriteInvisible());
			this.obtenerContext().obtenerNivel().removerEnemigo(this.contexto);
		}
	}

	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites) {}
	
	public void mover() {
		if (this.contexto.obtenerVelocidadDireccional().x <=  0) {
			moverIzquierda();
		} else if (this.contexto.obtenerVelocidadDireccional().x > 0) {
			moverDerecha();
		}
	}
	
	private void moverDerecha() {
		Point velocidad = new Point(this.contexto.obtenerVelocidadHorizontalEnemigo(), this.contexto.obtenerVelocidadDireccional().y);
    	this.contexto.establecerVelocidadDireccional(velocidad);
    	contexto.establecerMirandoAlFrente(true);
    }
    
    private void moverIzquierda() {
    	Point velocidad = new Point(-this.contexto.obtenerVelocidadHorizontalEnemigo(), this.contexto.obtenerVelocidadDireccional().y);
    	this.contexto.establecerVelocidadDireccional(velocidad);
    	contexto.establecerMirandoAlFrente(false);
    }
    
}
