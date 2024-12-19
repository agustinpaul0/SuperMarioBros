package elementos.plataformas;

import java.awt.Point;
import elementos.Sprite;
import observers.ObserverGrafico;
import visitors.Visitante;

public class Tuberia extends Plataforma{
    
    protected int altura;
    
    protected final int ancho;

    @SuppressWarnings("exports")
	public Tuberia (Sprite sprite, Point pos, Visitante visitor, ObserverGrafico observerGrafico, 
    				int altura, int ancho) {
        super(sprite,pos,visitor,observerGrafico);
        this.altura = altura;
        this.ancho = ancho;
    }

    @Override
    public int obtenerAlto() {
    	return this.altura;
    }

    @Override
    public int obtenerAncho() {
    	return this.ancho;
    }
    
    @Override
    public void aceptarVisitante(Visitante visitante) {
    	visitante.visitarTuberia(this);
    }
    
}
