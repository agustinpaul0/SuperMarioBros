package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorBandera implements Visitante {
    
    private Bandera miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;
   
    public VisitorBandera(Bandera miEntidad, GeneradorSonidos generadorSonidos) {
        this.generadorSonidos = generadorSonidos;
        this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, buzzyBeetle);
    }
    
    public void visitarSpiny(Spiny spiny) {    
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, spiny);
    }

    public void visitarGoomba(Goomba goomba) {    
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, goomba);
    }
    
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {    
    	contextoKoopaTroopa.obtenerEstado().aceptarVisitante(this.miEntidad.obtenerVisitante());
    }

    public void visitarLakitu(Lakitu lakitu) {    
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, lakitu);
    }
    
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {    
    }
    
    public void visitarSuperChampinion(SuperChampinion superChampinion) {   
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, superChampinion);
    }
    
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {        
    }
    
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {    
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, champinionVerde);
    }
    
    public void visitarEstrella(Estrella estrella) {    
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, estrella);
    }
    
    public void visitarMoneda(Moneda monedas) {    
    }
    
    public void visitarContextoMario(ContextoMario contextoMario) {
    	this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, contextoMario);
    }

    public void visitarMarioDefault(MarioDefault marioDefault) {
    }
    
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    }
    
    public void visitarMarioFuego(MarioFuego marioFuego) {
    }
    
    public void visitarSuperMario(SuperMario superMario) {
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
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
    
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {        
    }
    
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {        
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, koopaDefault.obtenerContext());
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