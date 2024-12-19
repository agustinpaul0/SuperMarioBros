package elementos.personajes;

import fabricas.FabricaSprites;
import visitors.Visitante;

public interface EstadoMario{
	
	public ContextoMario obtenerContexto();
	
	public void actualizarSprite(FabricaSprites fabricaSprites);

	public void aceptarVisitante(Visitante visitante);

	public void establecerContexto(ContextoMario contextoMario);
	
	public Visitante obtenerVisitante();
	
	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites);
	
	public void realizarAccionEspecial();
	
	public void actualizarTiempo();

	public void reiniciarEstado();
		
}
