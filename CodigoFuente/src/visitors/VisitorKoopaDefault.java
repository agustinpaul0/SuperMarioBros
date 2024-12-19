package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorKoopaDefault implements Visitante {

    private EstadoKoopa miEstado;
    
    private ContextoKoopaTroopa miContexto;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;

    public VisitorKoopaDefault(KoopaDefault miEstado, GeneradorSonidos generadorSonidos) {
        this.generadorSonidos = generadorSonidos;
    	this.miEstado = miEstado;
        this.miContexto = miEstado.obtenerContext();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }
    
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    }
    
    public void visitarSpiny(Spiny spiny) {
    }
    
    public void visitarGoomba(Goomba goomba) {
    }
    
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
    }
    
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    }

    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    }

    public void visitarLakitu(Lakitu lakitu) {
    }

    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
    }

    public void visitarSuperChampinion(SuperChampinion superChampinion) {
    }

    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    }

    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
    }

    public void visitarEstrella(Estrella estrella) {
    }

    public void visitarMoneda(Moneda monedas) {
    }
    
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
    }

    public void visitarLadrillo(Ladrillo ladrillo) {
    }

    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
    }

    public void visitarBandera(Bandera bandera) {
    }

    public void visitarTuberia(Tuberia tuberia) {
    }

    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
    }
    
    public void visitarContextoMario(ContextoMario contextoMario) {
        contextoMario.obtenerEstado().aceptarVisitante(this);
    }
    
    public void visitarMarioDefault(MarioDefault marioDefault) {
    	if (this.detectorDireccionColision.verificarImpactoLateralEntreMarioYEnemigo(marioDefault.obtenerContexto(), this.miContexto)
    		&& !this.miContexto.obtenerRemovido()) {
    		generadorSonidos.detenerSonidoActual();
    		generadorSonidos.establecerSonidoPerderVida();
    		generadorSonidos.reproducirSonidoActualPorUnicaVez();
            ContextoMario contextoMario = marioDefault.obtenerContexto();
            int perdidaPuntos = this.miContexto.obtenerPuntosSustraidosPorMuerteCausada();
            contextoMario.perderPuntos(perdidaPuntos);
            contextoMario.perderVida();
            miContexto.obtenerNivel().obtenerPartida().reiniciarNivel();
        }
    }
    
    public void visitarSuperMario(SuperMario superMario) {
    	if (this.detectorDireccionColision.verificarImpactoLateralEntreMarioYEnemigo(superMario.obtenerContexto(), this.miContexto)
        	&& !this.miContexto.obtenerRemovido()) {
        	this.generadorSonidos.modoRecuperacion();
    		EstadoMario marioRecuperacion = new MarioRecuperacion();
	        superMario.obtenerContexto().cambiarEstado(marioRecuperacion);
    	} else {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, superMario.obtenerContexto());
    	}
    }

    public void visitarMarioFuego(MarioFuego marioFuego) {
    	if (this.detectorDireccionColision.verificarImpactoLateralEntreMarioYEnemigo(marioFuego.obtenerContexto(), this.miContexto)
        	&& !this.miContexto.obtenerRemovido()) {
        	this.generadorSonidos.modoRecuperacion();
    		EstadoMario marioRecuperacion = new MarioRecuperacion();
    		marioFuego.obtenerContexto().cambiarEstado(marioRecuperacion);
    	} else {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, marioFuego.obtenerContexto());
    	}
    }
    
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    	if (this.miContexto.obtenerRemovido()) {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, marioRecuperacion.obtenerContexto());
    	}
    }

    public void visitarPiso(Piso piso) {
    }
	
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
	}

	public void visitarVacio(Vacio vacio) {
	}
    
}
