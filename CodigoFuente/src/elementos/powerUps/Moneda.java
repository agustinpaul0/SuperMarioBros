package elementos.powerUps;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Moneda extends PowerUp {

	protected boolean seRealizoAnimacionSalto;
	
	@SuppressWarnings("exports")
	public Moneda(Sprite sprite, Point posicion, Visitante visitor,
			   	   ObserverGrafico observerGrafico, boolean dentroDeBloqueDePreguntas) {
		super(sprite, posicion, visitor, observerGrafico);
		this.esMovible = true;
		this.estaDentroDeBloqueDePreguntas = dentroDeBloqueDePreguntas;
		this.haceRuidoAlSalir = false;
		this.ticksHastaSalirDelBloque=1;
		this.seRealizoAnimacionSalto=false;
	}
	
	public int obtenerPuntosPorDefault() {
		return 5;
	}
	
	public int obtenerPuntosPorSuper() {
		return this.obtenerPuntosPorDefault();
	}
	
	public int obtenerPuntosPorInvulnerable() {
		return this.obtenerPuntosPorDefault();
	}
	
	public int obtenerPuntosPorFuego() {
		return this.obtenerPuntosPorDefault();
	}

	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if (this.obtenerRemovido()) {
			this.eliminarEntidadGrafica(fabricaSprites);
		} else if (!this.estaDentroDeBloqueDePreguntas ) {
				this.establecerSprite(fabricaSprites.obtenerMonedaEncendida());
				if(!this.seRealizoAnimacionSalto) {
					this.realizarAnimacionSalto();
					this.seRealizoAnimacionSalto = true;
				}
		} 
		
	}
	
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarMoneda(this);
	}
	
	private void realizarAnimacionSalto() {
		Point salto = new Point(0,-15);
		this.establecerVelocidadDireccional(salto);
	}
	
	@Override
	protected void moverDerecha() {
    }
    
	@Override
    protected void moverIzquierda() {
    }
    
}
