package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorPiso implements Visitante {

    private Piso miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;

    public VisitorPiso(Piso miEntidad, GeneradorSonidos generadorSonidos) {
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
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, spiny);
    }

    public void visitarGoomba(Goomba goomba) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, goomba);
    }

    public void visitarLakitu(Lakitu lakitu) {
    }

    public void visitarPiranhaPlant(PiranhaPlant planta) {
    }

    public void visitarSuperChampinion(SuperChampinion superChampinion) {    
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, superChampinion);
    }

    public void visitarFlorDeFuego(FlorDeFuego flor) {
    }

    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {    
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, champinionVerde);
    }

    public void visitarEstrella(Estrella estrella) {
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, estrella);
    }

    public void visitarMoneda(Moneda moneda) {
    	this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, moneda);
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

    public void visitarContextoMario(ContextoMario contextoMario) {   
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, contextoMario);
    }

    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {    
        this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(this.miEntidad, contextoKoopaTroopa);
    }

    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    }

    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    }

    public void visitarPiso(Piso piso) {
    }

   	public void visitarBolaDeFuego(BolaDeFuego fireball) {
   		if (this.detectorDireccionColision.choquePorArriba(miEntidad, fireball)) {
   			fireball.retrotraerMovimientoVertical(miEntidad.obtenerHitbox().y - fireball.obtenerAlto());
   			fireball.rebotar();
   		} else if(!fireball.obtenerRemovido()){
   			generadorSonidos.choqueFireball();
   			fireball.establecerRemovido(true);
   		}
   	}

	public void visitarVacio(Vacio vacio) {
	}

}