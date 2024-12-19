package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorGoomba implements Visitante {

    private Goomba miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;

    public VisitorGoomba(Goomba miEntidad, GeneradorSonidos generadorSonido) {
    	this.generadorSonidos = generadorSonido;
        this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }
    
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        this.detectorDireccionColision.verificarColisionEntreEntidades(this.miEntidad, buzzyBeetle);
    }
    
    public void visitarSpiny(Spiny spiny) {
        this.detectorDireccionColision.verificarColisionEntreEntidades(this.miEntidad, spiny);
    }
    
    public void visitarGoomba(Goomba goomba) {
        this.detectorDireccionColision.verificarColisionEntreEntidades(this.miEntidad, goomba);
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
    
    public void visitarContextoMario(ContextoMario contextoMario) {
        contextoMario.obtenerEstado().aceptarVisitante(this);
    }
    
    public void visitarMarioDefault(MarioDefault marioDefault) {
        if (this.detectorDireccionColision.verificarImpactoLateralEntreMarioYEnemigo(marioDefault.obtenerContexto(), this.miEntidad) 
        	&& !this.miEntidad.obtenerRemovido()) {
            ContextoMario contextoMario = marioDefault.obtenerContexto();
            int perdidaPuntos = this.miEntidad.obtenerPuntosSustraidosPorMuerteCausada();
            contextoMario.perderPuntos(perdidaPuntos);
            this.generadorSonidos.detenerSonidoActual();
            this.generadorSonidos.establecerSonidoPerderVida();
            this.generadorSonidos.reproducirSonidoActualPorUnicaVez();
            contextoMario.perderVida();
            miEntidad.obtenerNivel().obtenerPartida().reiniciarNivel();
        } else {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, marioDefault.obtenerContexto());
        }
    }

    public void visitarSuperMario(SuperMario superMario) {
    	if (this.detectorDireccionColision.verificarImpactoLateralEntreMarioYEnemigo(superMario.obtenerContexto(), this.miEntidad)
    		&& !this.miEntidad.obtenerRemovido()) {
        	this.generadorSonidos.modoRecuperacion();
    		EstadoMario marioRecuperacion = new MarioRecuperacion();
	        superMario.obtenerContexto().cambiarEstado(marioRecuperacion);
    	} else {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, superMario.obtenerContexto());
        }
    }

    public void visitarMarioFuego(MarioFuego marioFuego) {
    	if (this.detectorDireccionColision.verificarImpactoLateralEntreMarioYEnemigo(marioFuego.obtenerContexto(), this.miEntidad) 
    		&& !this.miEntidad.obtenerRemovido()) {
        	this.generadorSonidos.modoRecuperacion();
    		EstadoMario marioRecuperacion = new MarioRecuperacion();
    		marioFuego.obtenerContexto().cambiarEstado(marioRecuperacion);
    	} else {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, marioFuego.obtenerContexto());
        }
    }
    
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    }

    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    	if (this.miEntidad.obtenerRemovido()) {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, marioRecuperacion.obtenerContexto());
    	}
    }
    
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
    }

    public void visitarLadrillo(Ladrillo ladrillo) {
    }
    
    public void visitarPiso(Piso piso) {
    }

    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
    }
    
    public void visitarBandera(Bandera bandera) {
    }
    
    public void visitarTuberia(Tuberia tuberia) {
    }

    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
    }

    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        this.detectorDireccionColision.verificarColisionEntreEntidades(this.miEntidad, contextoKoopaTroopa);
    }
    
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    }
    
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    }
	
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		if(!fireball.obtenerRemovido()) {
			generadorSonidos.matarBolaDeFuego();
			fireball.establecerRemovido(true);
		}
	}

	public void visitarVacio(Vacio vacio) {
	}
    
}
