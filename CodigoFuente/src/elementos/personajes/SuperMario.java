package elementos.personajes;

import elementos.Sprite;
import fabricas.FabricaSprites;
import visitors.Visitante;
import visitors.VisitorSuperMario;

public class SuperMario extends MarioDefault {
	
	@Override
	public Visitante obtenerVisitante() {
		return new VisitorSuperMario(this, this.contexto.obtenerNivel().obtenerPartida().obtenerGeneradorSonidos());
	}
	
	@Override
	public Sprite obtenerSpriteInicial(FabricaSprites fabricaSprites) {
		return fabricaSprites.obtenerSuperMarioFrontalQuieto();
	}
	
	@Override
	public void aceptarVisitante(Visitante visitante) {
		visitante.visitarSuperMario(this);
	}
	
	@Override
	public void actualizarSprite(FabricaSprites fabricaSprites) {
		Sprite aRetornar = null;
		if (bajoElNivelDelPiso()){
			aRetornar = fabricaSprites.obtenerSuperMarioCayendo();
		} else if (mirandoAlFrente() && enElAire()) {
			aRetornar = fabricaSprites.obtenerSuperMarioFrontalSaltando();
		} else if (!mirandoAlFrente() && enElAire()) {
			aRetornar = fabricaSprites.obtenerSuperMarioReversoSaltando();
		} else if (avanzando()) {
			aRetornar = fabricaSprites.obtenerSuperMarioFrontalCaminando();
		} else if (retrocediendo()) {
			aRetornar = fabricaSprites.obtenerSuperMarioReversoCaminando();
		} else if (mirandoAlFrente() && !avanzando()) {
			aRetornar = fabricaSprites.obtenerSuperMarioFrontalQuieto();
		} else if (!mirandoAlFrente() && !retrocediendo()) {
			aRetornar = fabricaSprites.obtenerSuperMarioReversoQuieto();
		} else {
			aRetornar = obtenerSpriteInicial(fabricaSprites);
		}
		this.contexto.establecerSprite(aRetornar);
	}
	
	@Override
	public void reiniciarEstado() {
		this.contexto.generadorSonidos.marioPequenioDeNuevo();
		this.contexto.cambiarEstado(new MarioDefault());
	}
	
}