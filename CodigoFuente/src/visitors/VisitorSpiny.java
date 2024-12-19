package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorSpiny implements Visitante {
	
	private Spiny miEntidad;

    protected DetectorDireccionColision detectorDireccionColision;

    protected GeneradorSonidos generadorSonidos;
	
	public VisitorSpiny(Spiny miEntidad, GeneradorSonidos generadorSonidos) {
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

	public void visitarLakitu(Lakitu lakitu) {
        this.detectorDireccionColision.verificarColisionEntreEntidades(this.miEntidad, lakitu);
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
	
	public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
	}

	public void visitarKoopaDefault(KoopaDefault koopaDefault) {
	}

	public void visitarMarioDefault(MarioDefault marioDefault) {
		this.generadorSonidos.detenerSonidoActual();
    	this.generadorSonidos.establecerSonidoPerderVida();
    	this.generadorSonidos.reproducirSonidoActualPorUnicaVez();
		ContextoMario contextoMario = marioDefault.obtenerContexto();
        int perdidaPuntos = this.miEntidad.obtenerPuntosSustraidosPorMuerteCausada();
        contextoMario.perderPuntos(perdidaPuntos);
        contextoMario.perderVida();
        miEntidad.obtenerNivel().obtenerPartida().reiniciarNivel();
	}
	
	public void visitarSuperMario(SuperMario superMario) {
    	this.generadorSonidos.modoRecuperacion();
		EstadoMario marioRecuperacion = new MarioRecuperacion();
        superMario.obtenerContexto().cambiarEstado(marioRecuperacion);
	}

	public void visitarMarioFuego(MarioFuego marioFuego) {
    	this.generadorSonidos.modoRecuperacion();
		EstadoMario marioRecuperacion = new MarioRecuperacion();
		marioFuego.obtenerContexto().cambiarEstado(marioRecuperacion);
	}
	
	public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
	}
	
	public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
	}

	public void visitarPiso(Piso piso) {
	}

	public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
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
