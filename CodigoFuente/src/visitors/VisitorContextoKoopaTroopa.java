package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorContextoKoopaTroopa implements Visitante {
    
    private ContextoKoopaTroopa miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;
    
    public VisitorContextoKoopaTroopa(ContextoKoopaTroopa miEntidad, GeneradorSonidos generadorSonidos) {
        this.generadorSonidos = generadorSonidos;
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

    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
		contextoKoopaTroopa.obtenerEstado().aceptarVisitante(this);
    }
    
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(koopaEnCaparazon.obtenerContext() ,this.miEntidad);
    }
    
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
        this.detectorDireccionColision.verificarColisionEntreEntidades(koopaDefault.obtenerContext(), this.miEntidad);
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
    	marioDefault.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
    }

    public void visitarSuperMario(SuperMario superMario) {  
    	superMario.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
    }
    
    public void visitarMarioFuego(MarioFuego marioFuego) {
    	marioFuego.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
    }
    
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    	marioRecuperacion.aceptarVisitante(this.miEntidad.obtenerEstado().obtenerVisitante());
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
