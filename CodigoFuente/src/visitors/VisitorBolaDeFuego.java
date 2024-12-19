package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorBolaDeFuego implements Visitante {

    private BolaDeFuego miEntidad;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;

    public VisitorBolaDeFuego(BolaDeFuego miEntidad, GeneradorSonidos generadorSonidos) {
        this.generadorSonidos = generadorSonidos;
    	this.miEntidad = miEntidad;
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
        otorgarPuntosYEliminar(buzzyBeetle);
    }

    public void visitarSpiny(Spiny spiny) {
		this.generadorSonidos.emitirSonidoAplastarEnemigo3();
        otorgarPuntosYEliminar(spiny);
    }

    public void visitarGoomba(Goomba goomba) {
		this.generadorSonidos.emitirSonidoAplastarEnemigo();
    	otorgarPuntosYEliminar(goomba);
    }
    
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
    	contextoKoopaTroopa.obtenerEstado().aceptarVisitante(this.miEntidad.obtenerVisitante());
    }
    
    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
    	otorgarPuntosYEliminar(koopaDefault.obtenerContext());
    }

    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
    	koopaEnCaparazon.obtenerContext().establecerRemovido(true);
    }

    public void visitarLakitu(Lakitu lakitu) {
		this.generadorSonidos.emitirSonidoAplastarEnemigo();
        otorgarPuntosYEliminar(lakitu);
    }

    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
		this.generadorSonidos.emitirSonidoAplastarEnemigo3();
        otorgarPuntosYEliminar(piranhaPlant);
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
    }

    public void visitarPiso(Piso piso) {
    }
	
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
	}
	
	public void visitarVacio(Vacio vacio) {
	}
	
	private void otorgarPuntosYEliminar(Enemigo enemigo) {
		int puntos = enemigo.obtenerPuntosOtorgadosPorEliminacion();
		this.miEntidad.obtenerJugador().ganarPuntos(puntos);
		enemigo.establecerRemovido(true);
	}
}
