package elementos.personajes;

import java.awt.Point;

import elementos.Sprite;
import elementos.entidades.Jugable;
import fabricas.FabricaSprites;
import generadores.GeneradorSonidos;
import observers.ObserverGrafico;
import visitors.Visitante;

public class ContextoMario extends Jugable {

	private EstadoMario estadoMario;
	
	protected GeneradorSonidos generadorSonidos;
		
	@SuppressWarnings("exports")
	public ContextoMario(Sprite sprite, Point posicion, Visitante visitor, ObserverGrafico observerGrafico,
						 int vidas, MarioDefault estadoMario, GeneradorSonidos generadorSonidos) {
		super(sprite, posicion, visitor, observerGrafico);
		this.generadorSonidos= generadorSonidos;
		this.estadoMario = estadoMario;
		this.estadoMario.establecerContexto(this);
	}
	
	public void cambiarEstado(EstadoMario estadoMario) {
		this.estadoMario = estadoMario;
		estadoMario.establecerContexto(this);
	}

	public void actualizarSprite(FabricaSprites fabricaSprites) {
		this.estadoMario.actualizarHitboxYPosicion(fabricaSprites);
		this.estadoMario.actualizarSprite(fabricaSprites);
	}
	
	public EstadoMario obtenerEstado() {
		return this.estadoMario;
	}
	
	public void reiniciarEstado() {
        this.estadoMario.reiniciarEstado();
	}
	
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarContextoMario(this);
	}

	public void realizarAccionEspecial() {
		this.estadoMario.realizarAccionEspecial();
	}
	
}
