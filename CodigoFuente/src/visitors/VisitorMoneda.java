package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorMoneda implements Visitante {
    
    private Moneda miEntidad;
    
    protected GeneradorSonidos generadorSonidos;

    public VisitorMoneda(Moneda miEntidad, GeneradorSonidos generadorSonidos) {
    	this.generadorSonidos = generadorSonidos;
        this.miEntidad = miEntidad;
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
    
    public void visitarPiso(Piso piso) {
    }

	public void visitarBolaDeFuego(BolaDeFuego fireball) {
	}

	public void visitarVacio(Vacio vacio) {
	}
    
}
