package elementos.plataformas;

import java.awt.Point;

import elementos.ElementoDeJuego;
import elementos.Sprite;
import fabricas.FabricaSprites;
import observers.ObserverGrafico;
import visitors.Visitante;

public abstract class Plataforma extends ElementoDeJuego {
	
	protected Plataforma(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico) {
		super(sprite, posicion, visitor, observerGrafico);
	}

	public  void actualizarSprite(FabricaSprites fabricaSprites) {
		if (this.removido) {
			this.establecerSprite(fabricaSprites.obtenerSpriteInvisible());
		}
	}
	
}
