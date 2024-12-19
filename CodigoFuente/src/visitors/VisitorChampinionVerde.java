package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorChampinionVerde implements Visitante {
    
    private ChampinionVerde miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;
    
    public VisitorChampinionVerde(ChampinionVerde miEntidad, GeneradorSonidos generadorSonidos) {
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
    }

    public void visitarMarioDefault(MarioDefault marioDefault) {
    }
    
    public void visitarSuperMario(SuperMario superMario) {
    }

    public void visitarMarioFuego(MarioFuego marioFuego) {
    }
    
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    }
    
    public void visitarBloqueDePregunta(BloqueDePregunta bloquePregunta) {
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
	}

	public void visitarVacio(Vacio vacio) {
	}

}
