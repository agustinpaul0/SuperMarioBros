package elementos.plataformas;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Vacio extends Plataforma {
	
	private static final int PUNTOS_SUSTRAIDOS_POR_MUERTE_CAUSADA = 15;
	
	@SuppressWarnings("exports")
	public Vacio(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
	}
	
	public int obtenerPuntosSustraidosPorMuerteCausada() {
		return PUNTOS_SUSTRAIDOS_POR_MUERTE_CAUSADA;
	}
	
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarVacio(this);
	}

}
