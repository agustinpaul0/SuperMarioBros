package visitors;

import java.awt.Point;
import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorSuperMario implements Visitante {

    private EstadoMario miEstado;
    
    private ContextoMario miContexto;

    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;
    
    public VisitorSuperMario(SuperMario miEstado, GeneradorSonidos generadorSonidos) {
        this.generadorSonidos = generadorSonidos;
    	this.miEstado = miEstado;
        this.miContexto = this.miEstado.obtenerContexto();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    	if (this.detectorDireccionColision.choquePorArriba(buzzyBeetle, this.miContexto) &&
    	   !buzzyBeetle.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
    		buzzyBeetle.establecerRemovido(true);
            this.miContexto.ganarPuntos(buzzyBeetle.obtenerPuntosOtorgadosPorEliminacion());
    	}
    }

    public void visitarSpiny(Spiny spiny) {
    }

    public void visitarGoomba(Goomba goomba) {
    	if (this.detectorDireccionColision.choquePorArriba(goomba, this.miContexto) 
    	   && !goomba.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo();
            goomba.establecerRemovido(true);
            this.miContexto.ganarPuntos(goomba.obtenerPuntosOtorgadosPorEliminacion());
        }
    }

    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
		contextoKoopaTroopa.obtenerEstado().aceptarVisitante(this);
    }

    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    	if (this.detectorDireccionColision.choquePorArriba(koopaEnCaparazon.obtenerContext(), this.miContexto)
    		&& this.miContexto.obtenerVelocidadDireccional().y > koopaEnCaparazon.obtenerVelocidadNecesariaParaMatarKoopa()) {
    	   koopaEnCaparazon.obtenerContext().establecerRemovido(true);
    	   this.generadorSonidos.emitirSonidoAplastarEnemigo2();
        }
    }

    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    	if (this.detectorDireccionColision.choquePorArriba(koopaDefault.obtenerContext(), this.miContexto)) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
    		EstadoKoopa nuevoEstado = new KoopaEnCaparazon();
	        koopaDefault.obtenerContext().cambiarEstado(nuevoEstado);
	        this.miContexto.ganarPuntos(koopaDefault.obtenerContext().obtenerPuntosOtorgadosPorEliminacion());
	        koopaDefault.obtenerContext().establecerVelocidadDireccional(new Point(0, 0));
		}
    }

    public void visitarLakitu(Lakitu lakitu) {
    	if (this.detectorDireccionColision.choquePorArriba(lakitu, this.miContexto) 
    	   && !lakitu.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo();
    		lakitu.establecerRemovido(true);
            this.miContexto.ganarPuntos(lakitu.obtenerPuntosOtorgadosPorEliminacion());
        }
    }

    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
    }

    public void visitarSuperChampinion(SuperChampinion superChampinion) {
    	if (!superChampinion.obtenerRemovido()) {
			this.miContexto.ganarPuntos(superChampinion.obtenerPuntosPorSuper());
	        superChampinion.establecerRemovido(true);
		}
    }

    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    	if (!florDeFuego.obtenerRemovido()) {
			this.miContexto.ganarPuntos(florDeFuego.obtenerPuntosPorSuper());
			florDeFuego.establecerRemovido(true);
		}
    }

    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
    }

    public void visitarEstrella(Estrella estrella) {
    	if (!estrella.obtenerRemovido()) {
    		this.miContexto.ganarPuntos(estrella.obtenerPuntosPorSuper());
    		generadorSonidos.PowerupAgarrado();
            estrella.establecerRemovido(true);
            generadorSonidos.detenerSonidoActual();
            generadorSonidos.establecerSonidoInvulnerable();
            generadorSonidos.reproducirSonidoActual();
    	}
    }

    public void visitarMoneda(Moneda monedas) {
    	if (!monedas.obtenerRemovido()) {
    		this.miContexto.ganarPuntos(monedas.obtenerPuntosPorSuper());
        	monedas.establecerRemovido(true);
    	}
    }

    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
    	if (detectorDireccionColision.choquePorAbajo(bloqueDePregunta, this.miContexto)) {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(bloqueDePregunta, miContexto);
    		generadorSonidos.golpeBloque();
        }
    }

    public void visitarLadrillo(Ladrillo ladrillo) {
    	if (detectorDireccionColision.choquePorAbajo(ladrillo, this.miContexto)) {
            detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(ladrillo, miContexto);
    		ladrillo.eliminarDelNivel();
    		generadorSonidos.romperLadrillo();
        }
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
