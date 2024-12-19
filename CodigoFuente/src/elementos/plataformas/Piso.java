package elementos.plataformas;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Piso extends Plataforma {
	
	@SuppressWarnings("exports")
	public Piso(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
	}

	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarPiso(this);
	}

}
