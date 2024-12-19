package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorEstrella implements Visitante {
    
    private Estrella miEntidad;
    
    protected GeneradorSonidos generadorSonidos;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    public VisitorEstrella(Estrella miEntidad, GeneradorSonidos generadorSonidos) {
        this.generadorSonidos = generadorSonidos;
    	this.miEntidad = miEntidad;
    	detectorDireccionColision = new DetectorDireccionColision();
    }
    
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    }
    
    public void visitarSpiny(Spiny spiny) {
    }

    public void visitarGoomba(Goomba goomba) {
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
        ContextoMario contextoMario = marioDefault.obtenerContexto();
        EstadoMario nuevoEstado = new MarioInvulnerable(marioDefault,  this.generadorSonidos);
        contextoMario.cambiarEstado(nuevoEstado);
    }

    public void visitarSuperMario(SuperMario superMario) {
        ContextoMario contextoMario = superMario.obtenerContexto();
        EstadoMario nuevoEstado = new MarioInvulnerable(superMario, this.generadorSonidos);
        contextoMario.cambiarEstado(nuevoEstado);
    }

    public void visitarMarioFuego(MarioFuego marioFuego) {
        ContextoMario contextoMario = marioFuego.obtenerContexto();
        EstadoMario nuevoEstado = new MarioInvulnerable(marioFuego,  this.generadorSonidos);
        contextoMario.cambiarEstado(nuevoEstado);
    }

    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
        marioInvulnerable.reiniciarDuracion();
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    	ContextoMario contextoMario = marioRecuperacion.obtenerContexto();
        EstadoMario nuevoEstado = new MarioInvulnerable(new MarioDefault(),  this.generadorSonidos);
        contextoMario.cambiarEstado(nuevoEstado);
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
	}
	
	public void visitarVacio(Vacio vacio) {
	}
	
}
