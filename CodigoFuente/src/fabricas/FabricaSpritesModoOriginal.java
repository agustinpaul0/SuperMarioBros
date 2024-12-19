package fabricas;

import elementos.Sprite;

public class FabricaSpritesModoOriginal extends FabricaSprites {

	public FabricaSpritesModoOriginal(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	@Override
    public Sprite obtenerMarioDefaultFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioDefaultFrontalQuieto.png");
    }

	@Override
    public Sprite obtenerMarioDefaultFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioDefaultFrontalCaminando.gif");
    }

	@Override
    public Sprite obtenerMarioDefaultCayendo() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioDefaultCayendo.png");
    }
    
	@Override
    public Sprite obtenerMarioDefaultFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioDefaultFrontalSaltando.png");
    }

	@Override
    public Sprite obtenerMarioDefaultReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioDefaultReversoQuieto.png");
    }

	@Override
    public Sprite obtenerMarioDefaultReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioDefaultReversoCaminando.gif");
    }

	@Override
    public Sprite obtenerMarioDefaultReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioDefaultReversoSaltando.png");
    }

	@Override
    public Sprite obtenerSuperMarioFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/superMarioFrontalQuieto.png");
    }

	@Override
    public Sprite obtenerSuperMarioFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/superMarioFrontalCaminando.gif");
    }

	@Override
    public Sprite obtenerSuperMarioFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/superMarioFrontalSaltando.png");
    }
    
	@Override
    public Sprite obtenerSuperMarioCayendo() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/superMarioCayendo.png");
    }

	@Override
    public Sprite obtenerSuperMarioReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/superMarioReversoQuieto.png");
    }

	@Override
    public Sprite obtenerSuperMarioReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/superMarioReversoCaminando.gif");
    }

	@Override
    public Sprite obtenerSuperMarioReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/superMarioReversoSaltando.png");
    }

	@Override
    public Sprite obtenerMarioFuegoFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioFuegoFrontalQuieto.png");
    }

	@Override
    public Sprite obtenerMarioFuegoFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioFuegoFrontalCaminando.gif");
    }

	@Override
    public Sprite obtenerMarioFuegoFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioFuegoFrontalSaltando.png");
    }
    
	@Override
	public Sprite obtenerMarioFuegoCayendo() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioFuegoCayendo.png");
	}

	@Override
    public Sprite obtenerMarioFuegoReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioFuegoReversoQuieto.png");
    }

	@Override
    public Sprite obtenerMarioFuegoReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioFuegoReversoCaminando.gif");
    }

	@Override
    public Sprite obtenerMarioFuegoReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioFuegoReversoSaltando.png");
    }
    
	@Override
    public Sprite obtenerMarioInvulnerableFrontalQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioInvulnerableFrontalQuieto.gif");
    }

	@Override
    public Sprite obtenerMarioInvulnerableFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioInvulnerableFrontalCaminando.gif");
    }

	@Override
    public Sprite obtenerMarioInvulnerableFrontalSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioInvulnerableFrontalSaltando.gif");
    }

	@Override
    public Sprite obtenerMarioInvulnerableCayendo() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioInvulnerableCayendo.gif");
    }
    
	@Override
    public Sprite obtenerMarioInvulnerableReversoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioInvulnerableReversoQuieto.gif");
    }

	@Override
    public Sprite obtenerMarioInvulnerableReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioInvulnerableReversoCaminando.gif");
    }

	@Override
    public Sprite obtenerMarioInvulnerableReversoSaltando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioInvulnerableReversoSaltando.gif");
    }

	@Override
    public Sprite obtenerMarioRecuperacionFrontalQuieto() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioRecuperacionFrontalQuieto.gif");
    }
    
	@Override
    public Sprite obtenerMarioRecuperacionFrontalCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioRecuperacionFrontalCaminando.gif");
    }
    
	@Override
    public Sprite obtenerMarioRecuperacionCayendo() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioDefaultFrontalCayendo.gif");
    }
    
	@Override
    public Sprite obtenerMarioRecuperacionFrontalSaltando() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioRecuperacionFrontalSaltando.gif");
    }
    
	@Override
    public Sprite obtenerMarioRecuperacionReversoQuieto() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioRecuperacionReversoQuieto.gif");
    }
    
	@Override
    public Sprite obtenerMarioRecuperacionReversoCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioRecuperacionReversoCaminando.gif");
    }
    
	@Override
    public Sprite obtenerMarioRecuperacionReversoSaltando() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/marioRecuperacionReversoSaltando.gif");
    }
    
	@Override
    public Sprite obtenerKoopaTroopaDefaultFrontalCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/koopaTroopaDefaultFrontalCaminando.gif");
    }
    
	@Override
	public Sprite obtenerKoopaTroopaDefaultReversoCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/koopaTroopaDefaultReversoCaminando.gif");
    }
    
	@Override
    public Sprite obtenerKoopaTroopaCaparazonEstático() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/koopaTroopaCaparazonEstatico.png");
    }

	@Override
    public Sprite obtenerKoopaTroopaMuerto() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/koopaTroopaMuerto.png");
    }
    
	@Override
    public Sprite obtenerGoombaFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/goombaCaminando.gif");
    }
    
	@Override
    public Sprite obtenerGoombaReversoCaminando() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/goombaCaminando.gif");
    }
    
	@Override
	public Sprite obtenerGoombaMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoOriginal/goombaMuerto.png");
	}

	@Override
    public Sprite obtenerLakituFrontalFueraDeLaNube() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/lakituFrontalFueraDeLaNube.png");
    }

	@Override
    public Sprite obtenerLakituDentroDeLaNube() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/lakituFrontalDentroDeLaNube.png");
    }

	@Override
    public Sprite obtenerLakituReversoFueraDeLaNube() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/lakituReversoFueraDeLaNube.png");
    }

	@Override
	public Sprite obtenerLakituMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoOriginal/lakituMuerto.png");
	}
    
	@Override
    public Sprite obtenerSpinyCayendo() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/spinyCayendo.gif");
    }

	@Override
    public Sprite obtenerSpinyFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/spinyFrontalCaminando.gif");
    }

	@Override
    public Sprite obtenerSpinyReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/spinyReversoCaminando.gif");
    }
	
	@Override
	public Sprite obtenerSpinyMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoOriginal/spinyMuerto.png");
	}

	@Override
    public Sprite obtenerBuzzyBeetleFrontalCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/buzzyBeetleFrontalCaminando.gif");
    }

	@Override
    public Sprite obtenerBuzzyBeetleReversoCaminando() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/buzzyBeetleReversoCaminando.gif");
    }
    
	@Override
	public Sprite obtenerBuzzyBeetleMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoOriginal/buzzyBeetleMuerto.gif");
	}

	@Override
	public Sprite obtenerPiranhaPlant() {
		return new Sprite(rutaACarpeta + "/spritesModoOriginal/piranhaPlant.gif");
	}

	@Override
	public Sprite obtenerPiranhaPlantMuerto() {
		return new Sprite(rutaACarpeta + "/spritesModoOriginal/piranhaMuerto.png");
	}

	@Override
    public Sprite obtenerEstrellaApagada() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/estrella.gif");
    }

	@Override
    public Sprite obtenerEstrellaEncendida() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/estrella.gif");
    }
	
	@Override
    public Sprite obtenerFlorDeFuegoSaliendoDelBloqueDePreguntas() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/florDeFuegoSaliendo.gif");
    }

	@Override
    public Sprite obtenerFlorDeFuegoQuieto() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/florDeFuegoAfuera.gif");
    }

	@Override
    public Sprite obtenerChampinionVerde() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/champinionVerde.png");
    }

	@Override
    public Sprite obtenerChampinionVerdeSaliendoDelBloqueDePreguntas() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/champinionVerdeSaliendo.gif");
    }
    
	@Override
    public Sprite obtenerSuperChampinionSaliendoDelBloqueDePreguntas() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/superChampinionSaliendo.gif");
    }
    
	@Override
    public Sprite obtenerSuperChampinionQuieto() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/superChampinionAfuera.png");
    }

	@Override
    public Sprite obtenerMonedaApagada() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/monedaApagada.png");
    }

	@Override
    public Sprite obtenerMonedaEncendida() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/monedaEncendida.gif");
    }

	@Override
    public Sprite obtenerBolaDeFuego() {
		return new Sprite(rutaACarpeta + "/spritesModoOriginal/bolaDeFuego.gif");
	}

	@Override
    public Sprite obtenerLadrillo() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/ladrillo.png");
    }

	@Override
    public Sprite obtenerBloqueSolido() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/bloqueSolido.png");
    }
    
	@Override
    public Sprite obtenerPiso() {
    	return new Sprite(rutaACarpeta + "/spritesModoOriginal/piso.png");
    }

	@Override
    public Sprite obtenerTuberia(int altura) {
    	String rutaAux = rutaACarpeta;
    	if (altura == 1) {
    		rutaAux +=  "/spritesModoOriginal/tuberiaBaja.png";
    	} else if (altura == 2) {
    		rutaAux +=  "/spritesModoOriginal/tuberiaMediana.png";
    	} else if (altura == 3) {
    		rutaAux +=  "/spritesModoOriginal/tuberiaAlta.png";
    	}
        return new Sprite(rutaAux);
    }

	@Override
    public Sprite obtenerBloqueDePreguntaApagado() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/bloqueDePreguntaApagado.png");
    }

	@Override
    public Sprite obtenerBloqueDePreguntaEncendido() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/bloqueDePreguntaEncendido.gif");
    }

	@Override
    public Sprite obtenerBandera() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/bandera.png");
    }

	@Override
    public Sprite obtenerVacio() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/vacio.png");
    }

	@Override
    public Sprite obtenerPrincesaPeach() {
        return new Sprite(rutaACarpeta + "/spritesModoOriginal/princesaPeach.png");
    }
	
	@Override
	public Sprite obtenerSpriteInvisible() {
		return new Sprite(rutaACarpeta + "/spritesModoOriginal/spriteInvisible.png");
	}

	@Override
	public Sprite obtenerSpriteBanderaActivada() {
		return new Sprite(rutaACarpeta + "/spritesModoOriginal/banderaActivada.gif");
	}
	
}
