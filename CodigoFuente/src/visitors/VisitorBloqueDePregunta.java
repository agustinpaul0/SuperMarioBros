package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorBloqueDePregunta implements Visitante {
    
    private BloqueDePregunta miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;
    
    public VisitorBloqueDePregunta(BloqueDePregunta miEntidad, GeneradorSonidos generadorSonidos) {
        this.generadorSonidos = generadorSonidos;
    	this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, buzzyBeetle);
    }
    
    public void visitarSpiny(Spiny spiny) {
    	if (!spiny.obtenerAterrizo()) {
    		spiny.establecerAterrizo(true);
    	}
        detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, spiny);
    }

    public void visitarGoomba(Goomba goomba) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, goomba);
    }
    
    public void visitarContextoMario(ContextoMario contextoMario) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, contextoMario);
    }
    
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, contextoKoopaTroopa);
    }

    public void visitarLakitu(Lakitu lakitu) {    
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, lakitu);
    }
    
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {}
    
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
    
    public void visitarMarioDefault(MarioDefault marioDefault) {
    }

    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    }
    
    public void visitarMarioFuego(MarioFuego marioFuego) { 
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    }
    
    public void visitarSuperMario(SuperMario superMario) {
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
    }

	public void visitarPiso(Piso piso) {
	}

	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		if (this.detectorDireccionColision.choquePorArriba(this.miEntidad, fireball)) {
   			fireball.retrotraerMovimientoVertical(this.miEntidad.obtenerHitbox().y - fireball.obtenerAlto());
   			fireball.rebotar();
   		} else if(!fireball.obtenerRemovido()){
   			generadorSonidos.choqueFireball();
   			fireball.establecerRemovido(true);
   		}
	}

	public void visitarVacio(Vacio vacio) {
	}

}
