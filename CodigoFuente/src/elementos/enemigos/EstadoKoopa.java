package elementos.enemigos;

import fabricas.FabricaSprites;
import visitors.Visitante;

public interface EstadoKoopa {
	
	public void establecerContexto(ContextoKoopaTroopa contextoKoopaTroopa);

	public Visitante obtenerVisitante();
	
	public void aceptarVisitante(Visitante visitante);
	
	public void actualizarSprite(FabricaSprites fabricaSprites);

	public void actualizarHitboxYPosicion(FabricaSprites fabricaSprites);

	public void mover();
	
	public void invertirDireccion();
	
}
