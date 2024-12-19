package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorMarioDefault implements Visitante {

    private EstadoMario miEstado;
    
    private ContextoMario miContexto;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;

    public VisitorMarioDefault(MarioDefault miEstado, GeneradorSonidos generadorSonidos) {
        this.generadorSonidos = generadorSonidos;
    	this.miEstado = miEstado;
        this.miContexto = miEstado.obtenerContexto();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    	if (this.detectorDireccionColision.choquePorArriba(buzzyBeetle, this.miContexto) &&
    	   !buzzyBeetle.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
    		buzzyBeetle.establecerRemovido(true);
            this.miContexto.ganarPuntos(buzzyBeetle.obtenerPuntosOtorgadosPorEliminacion());
            this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(buzzyBeetle, miContexto);
            this.miContexto.rebotar();
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
            this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(goomba, miContexto);
            this.miContexto.rebotar();
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
           this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(koopaEnCaparazon.obtenerContext(), miContexto);
           this.miContexto.rebotar();
        }
    }

    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    	if (this.detectorDireccionColision.choquePorArriba(koopaDefault.obtenerContext(), this.miContexto)) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
    		EstadoKoopa nuevoEstado = new KoopaEnCaparazon();
	        koopaDefault.obtenerContext().cambiarEstado(nuevoEstado);
	        this.miContexto.ganarPuntos(koopaDefault.obtenerContext().obtenerPuntosOtorgadosPorEliminacion());
            this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(koopaDefault.obtenerContext(), miContexto);
            this.miContexto.rebotar();
		}
    }

    public void visitarLakitu(Lakitu lakitu) {
    	if (this.detectorDireccionColision.choquePorArriba(lakitu, this.miContexto) 
    	   && !lakitu.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo();
    		lakitu.establecerRemovido(true);
            this.miContexto.ganarPuntos(lakitu.obtenerPuntosOtorgadosPorEliminacion());
            this.miContexto.rebotar();
        }
    }

    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
    }

    public void visitarSuperChampinion(SuperChampinion superChampinion) {
		if (!superChampinion.obtenerRemovido()) {
			this.miContexto.ganarPuntos(superChampinion.obtenerPuntosPorDefault());
	        superChampinion.establecerRemovido(true);
		}
    }

    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    	if (!florDeFuego.obtenerRemovido()) {
    		this.miContexto.ganarPuntos(florDeFuego.obtenerPuntosPorDefault());
            florDeFuego.establecerRemovido(true);
    	}
    }
    
    public void visitarChampinionVerde(ChampinionVerde champinionVerde) {
    	
    }

    public void visitarEstrella(Estrella estrella) {
    	if (!estrella.obtenerRemovido()) {
    		this.miContexto.ganarPuntos(estrella.obtenerPuntosPorDefault());
            estrella.establecerRemovido(true);
            generadorSonidos.PowerupAgarrado();
            generadorSonidos.detenerSonidoActual(); 
            generadorSonidos.establecerSonidoInvulnerable();
            generadorSonidos.reproducirSonidoActual();
    		}
    }

    public void visitarMoneda(Moneda monedas) {
    }
    
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
    }

    public void visitarLadrillo(Ladrillo ladrillo) {
    	if(detectorDireccionColision.choquePorAbajo(ladrillo, miContexto)){
    		generadorSonidos.golpeBloque();
    	}
    	detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(ladrillo, miContexto);
    }
    
    public void visitarPiso(Piso piso) {
    }

    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
    }

    public void visitarBandera(Bandera bandera) {
    	bandera.aceptarVisitante(miContexto.obtenerVisitante());
    }

    public void visitarTuberia(Tuberia tuberia) {
    }
    
    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
    	if(detectorDireccionColision.choquePorAbajo(bloqueSolido, miContexto)){
    		generadorSonidos.golpeBloque();
    	}
    	detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(bloqueSolido, miContexto);
    }

    public void visitarContextoMario(ContextoMario contextoMario) {
    }
    
    public void visitarMarioDefault(MarioDefault marioDefault) {
    }

    public void visitarSuperMario(SuperMario superMario) {
    }
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
    }

    public void visitarMarioFuego(MarioFuego marioFuego) {
    }
    
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    }
	
	public void visitarBolaDeFuego(BolaDeFuego fireball) {
	}

	public void visitarVacio(Vacio vacio) {
	}
    
}
