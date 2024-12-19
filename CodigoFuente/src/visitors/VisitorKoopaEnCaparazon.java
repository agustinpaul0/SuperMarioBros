package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorKoopaEnCaparazon implements Visitante {

    private EstadoKoopa miEstado;
    
    private ContextoKoopaTroopa miContexto;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;

    public VisitorKoopaEnCaparazon(KoopaEnCaparazon miEstado, GeneradorSonidos generadorSonidos) {
        this.generadorSonidos = generadorSonidos;
    	this.miEstado = miEstado;
        this.miContexto = miEstado.obtenerContext();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }
    
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, buzzyBeetle);
    }

    public void visitarSpiny(Spiny spiny) {
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, spiny);
    }
    
    public void visitarGoomba(Goomba goomba) {
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, goomba);
    }
    
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, contextoKoopaTroopa);
    }

    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    }

    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, koopaDefault.obtenerContext());
    }
    
    public void visitarLakitu(Lakitu lakitu) {
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, lakitu);
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
    }

    public void visitarMarioDefault(MarioDefault marioDefault) {
    	if(!this.miContexto.obtenerRemovido()) {
    		this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, marioDefault.obtenerContexto());
    	}
    }

    public void visitarSuperMario(SuperMario superMario) {
    	if(!this.miContexto.obtenerRemovido()) {
    		this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, superMario.obtenerContexto());
    	}
    }
    
    public void visitarMarioFuego(MarioFuego marioFuego) {
    	if(!this.miContexto.obtenerRemovido()) {
    		this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, marioFuego.obtenerContexto());
    	}
    }

    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    	if(!this.miContexto.obtenerRemovido()) {
    		this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, marioInvulnerable.obtenerContexto());
    	}
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    	if(!this.miContexto.obtenerRemovido()) {
    		this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miContexto, marioRecuperacion.obtenerContexto());
    	}
    }

    public void visitarPiso(Piso piso) {
    }
	
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
	}
	
	public void visitarVacio(Vacio vacio) {
	}
    
}
