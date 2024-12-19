package elementos.plataformas;

import java.awt.Point;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Bandera extends Meta {
	
	@SuppressWarnings("exports")
	public Bandera(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
		this.activada = false;
	}

	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarBandera(this);
	}
	
	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		if (this.activada) {
			this.establecerSprite(fabricaSprites.obtenerSpriteBanderaActivada());
		}
	}
	
}
