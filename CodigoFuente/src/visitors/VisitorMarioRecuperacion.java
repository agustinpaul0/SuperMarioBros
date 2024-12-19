package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorMarioRecuperacion implements Visitante{
	
	private MarioRecuperacion miEstado;
	
	private ContextoMario miContexto;
	
	protected DetectorDireccionColision detectorDireccionColision;
	
	protected GeneradorSonidos generadorSonidos;
	 
	public VisitorMarioRecuperacion (MarioRecuperacion miEstado, GeneradorSonidos generadorSonidos) {
		this.generadorSonidos = generadorSonidos;
		this.miEstado = miEstado;
		this.miContexto = miEstado.obtenerContexto();
		this.detectorDireccionColision = new DetectorDireccionColision();
	}
	
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    	if (this.detectorDireccionColision.choquePorArriba(buzzyBeetle, this.miContexto)
    		&& !buzzyBeetle.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
    		otorgarPuntosYEliminar(buzzyBeetle);
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
    		otorgarPuntosYEliminar(goomba);
            this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(goomba, miContexto);
            this.miContexto.rebotar();
		}
    }

    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
		contextoKoopaTroopa.obtenerEstado().aceptarVisitante(this);
    }

    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    	if (this.detectorDireccionColision.choquePorArriba(koopaEnCaparazon.obtenerContext(), this.miContexto)
    		&& this.miContexto.obtenerVelocidadDireccional().y > koopaEnCaparazon.obtenerVelocidadNecesariaParaMatarKoopa()
    		&& !koopaEnCaparazon.obtenerContext().obtenerRemovido()) {
			this.generadorSonidos.emitirSonidoAplastarEnemigo2();
			koopaEnCaparazon.obtenerContext().establecerRemovido(true);
            this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(koopaEnCaparazon.obtenerContext(), miContexto);
            this.miContexto.rebotar();
        }
    }

    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    	if (this.detectorDireccionColision.choquePorArriba(koopaDefault.obtenerContext(), this.miContexto)) {
			ContextoKoopaTroopa contextoKoopa = koopaDefault.obtenerContext();
	        EstadoKoopa nuevoEstado = new KoopaEnCaparazon();
    		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
	        this.miContexto.ganarPuntos(koopaDefault.obtenerContext().obtenerPuntosOtorgadosPorEliminacion());
	        contextoKoopa.cambiarEstado(nuevoEstado);
            this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(koopaDefault.obtenerContext(), miContexto);
            this.miContexto.rebotar();
		}
    }

    public void visitarLakitu(Lakitu lakitu) {
    	if (this.detectorDireccionColision.choquePorArriba(lakitu, this.miContexto) 
    	   && !lakitu.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo();
    		otorgarPuntosYEliminar(lakitu);
            this.detectorDireccionColision.verificarColisionElementoDeJuegoYEntidad(lakitu, miContexto);
            this.miContexto.rebotar();
    	}
    }

    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
    }

    public void visitarSuperChampinion(SuperChampinion superChampinion) {
		if (!superChampinion.obtenerRemovido()) {
			EstadoMario nuevoEstado = new SuperMario();
			this.miContexto.ganarPuntos(superChampinion.obtenerPuntosPorDefault());
			this.miContexto.cambiarEstado(nuevoEstado);
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
    }

    public void visitarPiso(Piso piso) {
    }

    public void visitarPrincesaPeach(PrincesaPeach princesaPeach) {
    }

    public void visitarBandera(Bandera bandera) {
    	bandera.aceptarVisitante(miContexto.obtenerVisitante());
    }

    public void visitarTuberia(Tuberia tuberia) {}

    public void visitarBloqueSolido(BloqueSolido bloqueSolido) {
    	if(detectorDireccionColision.choquePorAbajo(bloqueSolido, miContexto)){
    		generadorSonidos.golpeBloque();
    	}
    }

    public void visitarContextoMario(ContextoMario contextoMario) {
    }

    public void visitarMarioDefault(MarioDefault marioDefault) {
    }

    public void visitarSuperMario(SuperMario superMario) {
    }

    public void visitarMarioFuego(MarioFuego marioFuego) {
    }
    
	public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion) {
	}

    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable) {
    }

	public void visitarBolaDeFuego(BolaDeFuego fireball) {
	}

	public void visitarVacio(Vacio vacio) {
	}
	
	private void otorgarPuntosYEliminar(Enemigo enemigo) {
		int puntos = enemigo.obtenerPuntosOtorgadosPorEliminacion();
		this.miContexto.ganarPuntos(puntos);
		enemigo.establecerRemovido(true);
	}

}
