package fabricas;

import elementos.Sprite;

public abstract class FabricaSprites {
	
	protected String rutaACarpeta;
	
	protected FabricaSprites(String rutaACarpeta) {
		this.rutaACarpeta = rutaACarpeta;
	}
	
	public abstract Sprite obtenerMarioDefaultFrontalQuieto();
		
	public abstract Sprite obtenerMarioDefaultFrontalCaminando();
	
	public abstract Sprite obtenerMarioDefaultCayendo();

	public abstract Sprite obtenerMarioDefaultFrontalSaltando();
	
	public abstract Sprite obtenerMarioDefaultReversoQuieto();
	
	public abstract Sprite obtenerMarioDefaultReversoCaminando();
	
	public abstract Sprite obtenerMarioDefaultReversoSaltando();
	
	public abstract Sprite obtenerMarioRecuperacionFrontalQuieto();
	
	public abstract Sprite obtenerMarioRecuperacionFrontalCaminando();
	
	public abstract Sprite obtenerMarioRecuperacionCayendo();
	
	public abstract Sprite obtenerMarioRecuperacionFrontalSaltando();
	
	public abstract Sprite obtenerMarioRecuperacionReversoQuieto();
	
	public abstract Sprite obtenerMarioRecuperacionReversoCaminando();
	
	public abstract Sprite obtenerMarioRecuperacionReversoSaltando();
	
	public abstract Sprite obtenerSuperMarioFrontalQuieto();
	
	public abstract Sprite obtenerSuperMarioFrontalCaminando();
		
	public abstract Sprite obtenerSuperMarioFrontalSaltando();
	
	public abstract Sprite obtenerSuperMarioReversoQuieto();
	
	public abstract Sprite obtenerSuperMarioCayendo();
	
	public abstract Sprite obtenerSuperMarioReversoCaminando();
	
	public abstract Sprite obtenerSuperMarioReversoSaltando();
	
	public abstract Sprite obtenerMarioFuegoFrontalQuieto();
	
	public abstract Sprite obtenerMarioFuegoFrontalCaminando();
		
	public abstract Sprite obtenerMarioFuegoFrontalSaltando();
	
	public abstract Sprite obtenerMarioFuegoReversoQuieto();
	
	public abstract Sprite obtenerMarioFuegoReversoCaminando();
	
	public abstract Sprite obtenerMarioFuegoReversoSaltando();
	
	public abstract Sprite obtenerMarioFuegoCayendo();
	
	public abstract Sprite obtenerMarioInvulnerableFrontalQuieto();
	
	public abstract Sprite obtenerMarioInvulnerableFrontalCaminando();
		
	public abstract Sprite obtenerMarioInvulnerableFrontalSaltando();
	
	public abstract Sprite obtenerMarioInvulnerableCayendo();
	
	public abstract Sprite obtenerMarioInvulnerableReversoQuieto();
	
	public abstract Sprite obtenerMarioInvulnerableReversoCaminando();
	
	public abstract Sprite obtenerMarioInvulnerableReversoSaltando();
	
	public abstract Sprite obtenerKoopaTroopaDefaultFrontalCaminando();
	
	public abstract Sprite obtenerKoopaTroopaDefaultReversoCaminando();
	
	public abstract Sprite obtenerKoopaTroopaCaparazonEstático();

	public abstract Sprite obtenerKoopaTroopaMuerto();
	
	public abstract Sprite obtenerGoombaFrontalCaminando();

	public abstract Sprite obtenerGoombaReversoCaminando();
	
	public abstract Sprite obtenerGoombaMuerto();

	public abstract Sprite obtenerPiranhaPlant();
	
	public abstract Sprite obtenerPiranhaPlantMuerto();

	public abstract Sprite obtenerLakituFrontalFueraDeLaNube();
	
	public abstract Sprite obtenerLakituReversoFueraDeLaNube();

	public abstract Sprite obtenerLakituDentroDeLaNube();
	
	public abstract Sprite obtenerLakituMuerto();
	
	public abstract Sprite obtenerSpinyCayendo();

	public abstract Sprite obtenerSpinyFrontalCaminando();
	
	public abstract Sprite obtenerSpinyMuerto();
	
	public abstract Sprite obtenerSpinyReversoCaminando();

	public abstract Sprite obtenerBuzzyBeetleFrontalCaminando();
	
	public abstract Sprite obtenerBuzzyBeetleReversoCaminando();
	
	public abstract Sprite obtenerBuzzyBeetleMuerto();

	public abstract Sprite obtenerEstrellaApagada();
	
	public abstract Sprite obtenerEstrellaEncendida();
	
	public abstract Sprite obtenerFlorDeFuegoSaliendoDelBloqueDePreguntas();
	
	public abstract Sprite obtenerFlorDeFuegoQuieto();
	
	public abstract Sprite obtenerChampinionVerde();
	
    public abstract Sprite obtenerChampinionVerdeSaliendoDelBloqueDePreguntas();

	public abstract Sprite obtenerSuperChampinionSaliendoDelBloqueDePreguntas();
	
	public abstract Sprite obtenerSuperChampinionQuieto();
	
	public abstract Sprite obtenerMonedaApagada();

	public abstract Sprite obtenerMonedaEncendida();
	
	public abstract Sprite obtenerBolaDeFuego();
	
	public abstract Sprite obtenerLadrillo();
	
	public abstract Sprite obtenerBloqueSolido();
	
	public abstract Sprite obtenerPiso();
	
	public abstract Sprite obtenerTuberia(int altura);
	
	public abstract Sprite obtenerBloqueDePreguntaApagado();
	
	public abstract Sprite obtenerBloqueDePreguntaEncendido();
	
	public abstract Sprite obtenerBandera();
	
	public abstract Sprite obtenerVacio();
	
	public abstract Sprite obtenerPrincesaPeach();
	
	public abstract Sprite obtenerSpriteInvisible();
	
	public abstract Sprite obtenerSpriteBanderaActivada();
	
}
