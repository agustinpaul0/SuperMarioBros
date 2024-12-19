package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;
import generadores.GeneradorSonidos;

public class VisitorMarioInvulnerable implements Visitante {

    private EstadoMario miEstado;
    
    private ContextoMario miContexto;
    
    protected DetectorDireccionColision detectorDireccionColision;
    
    protected GeneradorSonidos generadorSonidos;

    public VisitorMarioInvulnerable(MarioInvulnerable miEstado, GeneradorSonidos generadorSonidos) {
    	this.generadorSonidos = generadorSonidos;
        this.miEstado = miEstado;
        this.miContexto = this.miEstado.obtenerContexto();
        this.detectorDireccionColision = new DetectorDireccionColision();
    }

    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle) {
    	if(!buzzyBeetle.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
    		this.otorgarPuntosYEliminar(buzzyBeetle);
    	}
    }
    
    public void visitarSpiny(Spiny spiny) {
    	if(!spiny.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo3();
    		this.otorgarPuntosYEliminar(spiny);
    	}
    }

    public void visitarGoomba(Goomba goomba) {
    	if(!goomba.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo();
    		this.otorgarPuntosYEliminar(goomba);
    	}
    }

    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa) {
    	contextoKoopaTroopa.obtenerEstado().aceptarVisitante(this.miContexto.obtenerEstado().obtenerVisitante());
    }

    public void visitarKoopaDefault(KoopaDefault koopaDefault) {
    	if(!koopaDefault.obtenerContext().obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
    		this.otorgarPuntosYEliminar(koopaDefault.obtenerContext());
    	}
    }

    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon) {
    	if(!koopaEnCaparazon.obtenerContext().obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo2();
    		koopaEnCaparazon.obtenerContext().establecerRemovido(true);
    	}
    }

    public void visitarLakitu(Lakitu lakitu) {
    	if(!lakitu.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo();
    		this.otorgarPuntosYEliminar(lakitu);
    	}
    }
    
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant) {
    	if(!piranhaPlant.obtenerRemovido()) {
    		this.generadorSonidos.emitirSonidoAplastarEnemigo3();
    		this.otorgarPuntosYEliminar(piranhaPlant);
    	}
    }

    public void visitarSuperChampinion(SuperChampinion superChampinion) {
    	if(!superChampinion.obtenerRemovido()) {
    		this.miContexto.ganarPuntos(superChampinion.obtenerPuntosPorInvulnerable());
    		superChampinion.establecerRemovido(true);
    	}
    }
    
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego) {
    	if(!florDeFuego.obtenerRemovido()) {
    		this.miContexto.ganarPuntos(florDeFuego.obtenerPuntosPorInvulnerable());
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
    	}
    }

    public void visitarMoneda(Moneda monedas) {
    }
    
    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta) {
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

	private void otorgarPuntosYEliminar(Enemigo enemigo) {
		int puntos = enemigo.obtenerPuntosOtorgadosPorEliminacion();
		this.miContexto.ganarPuntos(puntos);
		enemigo.establecerRemovido(true);
	}
    
}
