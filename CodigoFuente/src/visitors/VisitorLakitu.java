package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorLakitu implements Visitante {
    
    private Lakitu miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;
    
    public VisitorLakitu(Lakitu miEntidad, GeneradorSonidos generadorSonidos) {
    	this.generadorSonidos = generadorSonidos;
        this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }
    
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    }
    
    public void visitarSpiny(Spiny spiny) {
    }
    
    public void visitarGoomba(Goomba goomba) {
    }
    
    public void visitarLakitu(Lakitu lakitu) {
        this.detectorDireccionColision.verificarColisionEntreEntidades(this.miEntidad, lakitu);
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
    
    public void visitarMoneda(Moneda moneda) {
    }
    
    public void visitarContextoMario(ContextoMario contextoMario) {
        contextoMario.obtenerEstado().aceptarVisitante(this);
    }
    
    public void visitarMarioDefault(MarioDefault marioDefault) {
    	if (this.detectorDireccionColision.verificarImpactoLateralEntreMarioYEnemigo(marioDefault.obtenerContexto(), this.miEntidad) 
            && !this.miEntidad.obtenerRemovido()) {
            this.generadorSonidos.detenerSonidoActual();
        	this.generadorSonidos.establecerSonidoPerderVida();
        	this.generadorSonidos.reproducirSonidoActualPorUnicaVez();
    		ContextoMario contextoMario = marioDefault.obtenerContexto();
            int perdidaPuntos = this.miEntidad.obtenerPuntosSustraidosPorMuerteCausada();
            contextoMario.perderPuntos(perdidaPuntos);
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
    
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
    }
    
    public void visitarBandera(Bandera bandera) {
    }
    
    public void visitarTuberia(Tuberia tuberia) {
    }
    
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
    }
    
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
    }
    
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    }
    
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    }
    
    public void visitarPiso(Piso piso) {
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
