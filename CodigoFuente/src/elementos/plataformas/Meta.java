package elementos.plataformas;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Meta extends Plataforma {
	
	protected boolean activada;

	protected Meta(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.activada = false;
	}
	
	public boolean obtenerFueActivada() {
		return this.activada;
	}
	
	public void establecerActivada(boolean activada) {
		this.activada = activada;
	}
}
