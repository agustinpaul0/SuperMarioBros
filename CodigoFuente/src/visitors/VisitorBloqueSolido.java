package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorBloqueSolido implements Visitante {
    
    private BloqueSolido miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;
    
    public VisitorBloqueSolido(BloqueSolido miEntidad, GeneradorSonidos generadorSonidos) {
        this.generadorSonidos = generadorSonidos;
    	this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }
    
    public void visitarBuzzyBeetle(BuzzyBeetle buzzy) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, buzzy);
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
    
    public void visitarLakitu(Lakitu lakitu) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, lakitu);
    }
    
    public void visitarPiranhaPlant(PiranhaPlant planta) {    
    }
    
    public void visitarSuperChampinion(SuperChampinion superChamp) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, superChamp);
    }
    
    public void visitarFlorDeFuego(FlorDeFuego flor) {        
    }

    public void visitarChampinionVerde(ChampinionVerde champVerde) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, champVerde);
    }
    
    public void visitarEstrella(Estrella estrella) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, estrella);
    }
    
    public void visitarMoneda(Moneda moneda) {
    	this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, moneda);
    }
    
    public void visitarMarioDefault(MarioDefault marioNormal) {
    }
    
    public void visitarMarioInvulnerable(MarioInvulnerable marioInv) {
    }
    
    public void visitarMarioFuego(MarioFuego marioFuego) {
    }

    public void visitarSuperMario(SuperMario superMario) {
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    }
    
    public void visitarBloqueDePregunta(BloqueDePregunta bloquePregunta) {        
    }

    public void visitarLadrillo(Ladrillo ladrillo) { 
    }
    
    public void visitarPrincesaPeach(PrincesaPeach princesa) {
    }

    public void visitarBandera(Bandera bandera) {
    }
    
    public void visitarTuberia(Tuberia tuberia) {
    }

    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
    }
    
    public void visitarContextoMario(ContextoMario contextoMario) {        
    }
    
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopa) {    
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, contextoKoopa);
    }

    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    }

    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    }

	public void visitarPiso(Piso piso) {
	}

	public void visitarBolaDeFuego(BolaDeFuego fireball) {
		if (detectorDireccionColision.choquePorArriba(this.miEntidad, fireball)) {
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
