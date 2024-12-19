package fabricas;

import elementos.Sprite;

public class FabricaSpritesModoAlternativo extends FabricaSprites {

	public FabricaSpritesModoAlternativo(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	@Override
    public Sprite obtenerMarioDefaultFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultFrontalQuieto.png");
    }
    
	@Override
    public Sprite obtenerMarioDefaultFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultFrontalCaminando.gif");
    }
    
	@Override
    public Sprite obtenerMarioDefaultCayendo() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultCayendo.png");
    }
	
	@Override
    public Sprite obtenerMarioDefaultFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultFrontalSaltando.png");
    }
    
	@Override
    public Sprite obtenerMarioDefaultReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultReversoQuieto.png");
    }
	
	@Override
    public Sprite obtenerMarioDefaultReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultReversoCaminando.gif");
    }

	@Override
    public Sprite obtenerMarioDefaultReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultReversoSaltando.png");
    }

	@Override
    public Sprite obtenerSuperMarioFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioFrontalQuieto.png");
    }

	@Override
    public Sprite obtenerSuperMarioFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioFrontalCaminando.gif");
    }

	@Override
    public Sprite obtenerSuperMarioFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioFrontalSaltando.png");
    }
    
	@Override
    public Sprite obtenerSuperMarioCayendo() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioCayendo.png");
    }

	@Override
    public Sprite obtenerSuperMarioReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioReversoQuieto.png");
    }

	@Override
    public Sprite obtenerSuperMarioReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioReversoCaminando.gif");
    }

	@Override
    public Sprite obtenerSuperMarioReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superMarioReversoSaltando.png");
    }
    
	@Override
    public Sprite obtenerMarioFuegoFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoFrontalQuieto.png");
    }

	@Override
    public Sprite obtenerMarioFuegoFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoFrontalCaminando.gif");
    }
    
	@Override
    public Sprite obtenerMarioFuegoFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoFrontalSaltando.png");
    }
    
	@Override
	public Sprite obtenerMarioFuegoCayendo() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoCayendo.png");
	}
	
	@Override
    public Sprite obtenerMarioFuegoReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoReversoQuieto.png");
    }
    
	@Override
    public Sprite obtenerMarioFuegoReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoReversoCaminando.gif");
    }
    
	@Override
    public Sprite obtenerMarioFuegoReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioFuegoReversoSaltando.png");
    }
    
	@Override
    public Sprite obtenerMarioInvulnerableFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableFrontalQuieto.png");
    }

	@Override
    public Sprite obtenerMarioInvulnerableFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableFrontalCaminando.gif");
    }

	@Override
    public Sprite obtenerMarioInvulnerableFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableFrontalSaltando.png");
    }

	@Override
    public Sprite obtenerMarioInvulnerableCayendo() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableCayendo.png");
    }
    
	@Override
    public Sprite obtenerMarioInvulnerableReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableReversoQuieto.png");
    }

	@Override
    public Sprite obtenerMarioInvulnerableReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableReversoCaminando.gif");
    }
    
	@Override
    public Sprite obtenerMarioInvulnerableReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioInvulnerableReversoSaltando.png");
    }
    
	@Override
    public Sprite obtenerMarioRecuperacionFrontalQuieto() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioRecuperacionFrontalQuieto.gif");
    }
    
	@Override
    public Sprite obtenerMarioRecuperacionFrontalCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioRecuperacionFrontalCaminando.gif");
    }
    
	@Override
    public Sprite obtenerMarioRecuperacionCayendo() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioDefaultCayendo.png");
    }
    
	@Override
    public Sprite obtenerMarioRecuperacionFrontalSaltando() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioRecuperacionFrontalSaltando.gif");
    }
    
	@Override
    public Sprite obtenerMarioRecuperacionReversoQuieto() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioRecuperacionReversoQuieto.gif");
    }
    
	@Override
    public Sprite obtenerMarioRecuperacionReversoCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioRecuperacionReversoCaminando.gif");
    }
    
	@Override
    public Sprite obtenerMarioRecuperacionReversoSaltando() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/marioRecuperacionReversoSaltando.gif");
    }
    
	@Override
    public Sprite obtenerKoopaTroopaDefaultFrontalCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/koopaTroopaDefaultFrontalCaminando.gif");
    }
    
	@Override
	public Sprite obtenerKoopaTroopaDefaultReversoCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/koopaTroopaDefaultReversoCaminando.gif");
    }
    
	@Override
    public Sprite obtenerKoopaTroopaCaparazonEstático() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/koopaTroopaCaparazonEstatico.gif");
    }
    
	@Override
    public Sprite obtenerKoopaTroopaMuerto() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/koopaTroopaMuerto.gif");
    }
    
	@Override
    public Sprite obtenerGoombaFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/goombaFrontalCaminando.gif");
    }
    
	@Override
    public Sprite obtenerGoombaReversoCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/goombaReversoCaminando.gif");
    }
    
	@Override
	public Sprite obtenerGoombaMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/goombaMuerto.gif");
	}

	@Override
    public Sprite obtenerLakituFrontalFueraDeLaNube() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/lakituFrontalFueraDeLaNube.gif");
    }

	@Override
    public Sprite obtenerLakituDentroDeLaNube() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/lakituFrontalDentroDeLaNube.png");
    }

	@Override
    public Sprite obtenerLakituReversoFueraDeLaNube() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/lakituReversoFueraDeLaNube.gif");
    }

	@Override
	public Sprite obtenerLakituMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/lakituMuerto.gif");
	}
    
	@Override
    public Sprite obtenerSpinyCayendo() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/spinyCayendo.png");
    }
    
	@Override
    public Sprite obtenerSpinyFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/spinyFrontalCaminando.gif");
    }
    
	@Override
    public Sprite obtenerSpinyReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/spinyReversoCaminando.gif");
    }
    
	@Override
	public Sprite obtenerSpinyMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/spinyMuerto.gif");
	}
    
	@Override
    public Sprite obtenerBuzzyBeetleFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/buzzyBeetleFrontalCaminando.gif");
    }

	@Override
    public Sprite obtenerBuzzyBeetleReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/buzzyBeetleReversoCaminando.gif");
    }
    
	@Override
	public Sprite obtenerBuzzyBeetleMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/buzzyBeetleMuerto.gif");
	}

	@Override
	public Sprite obtenerPiranhaPlant() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/piranhaPlant.gif");
	}

	@Override
	public Sprite obtenerPiranhaPlantMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/piranhaMuerto.gif");
	}

	@Override
    public Sprite obtenerEstrellaApagada() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/estrellaSaliendo.gif");
    }

	@Override
    public Sprite obtenerEstrellaEncendida() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/estrella.gif");
    }
    
	@Override
    public Sprite obtenerFlorDeFuegoSaliendoDelBloqueDePreguntas() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/florDeFuegoSaliendo.gif");
    }
    
	@Override
    public Sprite obtenerFlorDeFuegoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/florDeFuegoAfuera.gif");
    }
    
	@Override
    public Sprite obtenerChampinionVerde() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/champinionVerde.png");
    }

	@Override
    public Sprite obtenerChampinionVerdeSaliendoDelBloqueDePreguntas() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/champinionVerdeSaliendo.gif");
    }
    
	@Override
    public Sprite obtenerSuperChampinionSaliendoDelBloqueDePreguntas() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superChampinionSaliendo.gif");
    }
    
	@Override
    public Sprite obtenerSuperChampinionQuieto() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/superChampinionAfuera.gif");
    }

	@Override
    public Sprite obtenerMonedaApagada() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/monedaApagada.png");
    }
    
	@Override
    public Sprite obtenerMonedaEncendida() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/monedaEncendida.gif");
    }

	@Override
    public Sprite obtenerBolaDeFuego() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/bolaDeFuego.gif");
	}
    
	@Override
    public Sprite obtenerLadrillo() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/ladrillo.png");
    }
    
	@Override
    public Sprite obtenerBloqueSolido() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/bloqueSolido.png");
    }
    
	@Override
    public Sprite obtenerPiso() {
    	return new Sprite(rutaACarpeta + "/spritesModoAlternativo/piso.png");
    }

	@Override
    public Sprite obtenerTuberia(int altura) {
    	String rutaAux = rutaACarpeta;
    	if (altura == 1) {
    		rutaAux +=  "/spritesModoAlternativo/tuberiaBaja.png";
    	} else if (altura == 2) {
    		rutaAux +=  "/spritesModoAlternativo/tuberiaMediana.png";
    	} else if (altura == 3) {
    		rutaAux +=  "/spritesModoAlternativo/tuberiaAlta.png";
    	}
        return new Sprite(rutaAux);
    }

	@Override
    public Sprite obtenerBloqueDePreguntaApagado() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/bloqueDePreguntaApagado.png");
    }
    
	@Override
    public Sprite obtenerBloqueDePreguntaEncendido() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/bloqueDePreguntaEncendido.png");
    }

	@Override
    public Sprite obtenerBandera() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/bandera.gif");
    }

	@Override
    public Sprite obtenerVacio() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/vacio.png");
    }
	
	@Override
    public Sprite obtenerPrincesaPeach() {
        return new Sprite(rutaACarpeta + "/spritesModoAlternativo/princesaPeach.gif");
    }
	
	@Override
	public Sprite obtenerSpriteInvisible() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/spriteInvisible.png");
	}

	@Override
	public Sprite obtenerSpriteBanderaActivada() {
		return new Sprite(rutaACarpeta + "/spritesModoAlternativo/banderaActivada.gif");
	}
	
}