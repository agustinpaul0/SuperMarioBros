package fabricas;

import java.awt.Point;
import elementos.*;
import observers.ObserverGrafico;
import visitors.*;
import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.entidades.Entidad;
import elementos.entidades.Jugable;
import elementos.personajes.ContextoMario;
import elementos.personajes.MarioDefault;
import elementos.powerUps.*;
import generadores.GeneradorDeNivel;
import generadores.GeneradorSonidos;

public class FabricaEntidades {

    protected FabricaSprites fabricaSprites;
    
    protected GeneradorDeNivel generadorDeNivel;
    
    protected GeneradorSonidos generadorSonidos;

    public FabricaEntidades(FabricaSprites fabricaSprites, GeneradorDeNivel generadorDeNivel, 
    						GeneradorSonidos generadorSonidos) {
        this.generadorSonidos = generadorSonidos;
        this.fabricaSprites = fabricaSprites;
        this.generadorDeNivel = generadorDeNivel;
    }

    @SuppressWarnings("exports")
	public Spiny obtenerSpiny(Point posicion) {
        Spiny spiny = new Spiny(this.fabricaSprites.obtenerSpinyCayendo(), posicion, null, null);
        this.configurarEntidad(spiny, new VisitorSpiny(spiny, this.generadorSonidos));
        return spiny;
    }

    @SuppressWarnings("exports")
	public ContextoKoopaTroopa obtenerContextoKoopaTroopa(Point posicion) {
        KoopaDefault estadoInicial = new KoopaDefault();
        ContextoKoopaTroopa contextoKoopaTroopa = new ContextoKoopaTroopa(this.fabricaSprites.obtenerKoopaTroopaDefaultReversoCaminando(), 
        																  posicion, null, null, estadoInicial);
        this.configurarEntidad(contextoKoopaTroopa, 
        					   new VisitorContextoKoopaTroopa(contextoKoopaTroopa, this.generadorSonidos));
        return contextoKoopaTroopa;
    }

    @SuppressWarnings("exports")
	public PiranhaPlant obtenerPiranhaPlant(Point posicion, Sprite spriteTuberia) {
        int ajusteX = (spriteTuberia.obtenerAnchoImagen() - this.fabricaSprites.obtenerPiranhaPlant().obtenerAnchoImagen()) / 2;
        posicion = new Point(posicion.x + ajusteX, posicion.y);
        PiranhaPlant piranhaPlant = new PiranhaPlant(this.fabricaSprites.obtenerPiranhaPlant(), posicion, null, null);
        this.configurarEntidad(piranhaPlant, new VisitorPiranhaPlant(piranhaPlant, this.generadorSonidos));
        return piranhaPlant;
    }

    @SuppressWarnings("exports")
	public Lakitu obtenerLakitu(Point posicion, FabricaEntidades fabricaEntidades) {
        Lakitu lakitu = new Lakitu(this.fabricaSprites.obtenerLakituReversoFueraDeLaNube(), 
        						   posicion, null, null, fabricaEntidades);
        lakitu.establecerDebeMantenerseSiempreEnPantalla(true);
        this.configurarEntidad(lakitu, new VisitorLakitu(lakitu, this.generadorSonidos));
        return lakitu;
    }

    @SuppressWarnings("exports")
	public BuzzyBeetle obtenerBuzzyBeetle(Point posicion) {
        BuzzyBeetle buzzyBeetle = new BuzzyBeetle(this.fabricaSprites.obtenerBuzzyBeetleReversoCaminando(), 
        										  posicion, null, null);
        this.configurarEntidad(buzzyBeetle, new VisitorBuzzyBeetle(buzzyBeetle, this.generadorSonidos));
        return buzzyBeetle;
    }

    @SuppressWarnings("exports")
	public Goomba obtenerGoomba(Point posicion) {
        Goomba goomba = new Goomba(this.fabricaSprites.obtenerGoombaReversoCaminando(), posicion, null, null);
        this.configurarEntidad(goomba, new VisitorGoomba(goomba, this.generadorSonidos));
        return goomba;
    }

    @SuppressWarnings("exports")
	public Estrella obtenerEstrella(Point posicion) {
        Estrella estrella = new Estrella(this.fabricaSprites.obtenerSpriteInvisible(), posicion, null, null);
        this.configurarEntidad(estrella, new VisitorEstrella(estrella, this.generadorSonidos));
        return estrella;
    }

    @SuppressWarnings("exports")
	public ChampinionVerde obtenerChampinionVerde(Point posicion) {
        ChampinionVerde champinionVerde = new ChampinionVerde(this.fabricaSprites.obtenerSpriteInvisible(), 
        													  posicion, null, null);
        this.configurarEntidad(champinionVerde, new VisitorChampinionVerde(champinionVerde, this.generadorSonidos));
        return champinionVerde;
    }

    @SuppressWarnings("exports")
	public SuperChampinion obtenerSuperChampinion(Point posicion) {
        SuperChampinion superChampinion = new SuperChampinion(this.fabricaSprites.obtenerSpriteInvisible(), 
        													  posicion, null, null);
        this.configurarEntidad(superChampinion, new VisitorSuperChampinion(superChampinion, this.generadorSonidos));
        return superChampinion;
    }

    @SuppressWarnings("exports")
	public FlorDeFuego obtenerFlorDeFuego(Point posicion) {
        FlorDeFuego florDeFuego = new FlorDeFuego(this.fabricaSprites.obtenerSpriteInvisible(), 
        										  posicion, null, null);
        this.configurarEntidad(florDeFuego, 
        					   new VisitorFlorDeFuego(florDeFuego, this, this.generadorSonidos));
        return florDeFuego;
    }

    @SuppressWarnings("exports")
	public Moneda obtenerMonedas(Point posicion, boolean estaDentroDeBloqueDePreguntas) {
        Sprite sprite = estaDentroDeBloqueDePreguntas ? this.fabricaSprites.obtenerSpriteInvisible() : this.fabricaSprites.obtenerMonedaEncendida();
        Moneda moneda = new Moneda(sprite, posicion, null, null, true);
        this.configurarEntidad(moneda, new VisitorMoneda(moneda, this.generadorSonidos));
        return moneda;
    }

    @SuppressWarnings("exports")
    public ContextoMario obtenerContextoMario(Point posicion) {
        MarioDefault estadoInicial = new MarioDefault();
        ContextoMario contextoMario = new ContextoMario(this.fabricaSprites.obtenerMarioDefaultFrontalQuieto(), 
        												posicion, null, null, 3, estadoInicial, 
        												this.generadorSonidos);
        this.configurarJugable(contextoMario, new VisitorContextoMario(contextoMario, generadorSonidos));
        return contextoMario;
    }
    
    @SuppressWarnings("exports")
	public BolaDeFuego obtenerBolaDeFuego(Point posicion, Point velocidadDireccional, Jugable jugador) {
        BolaDeFuego bolaDeFuego = new BolaDeFuego(this.fabricaSprites.obtenerBolaDeFuego(), posicion, 
        										  null, velocidadDireccional, null, jugador);
        this.configurarEntidad(bolaDeFuego, new VisitorBolaDeFuego(bolaDeFuego, this.generadorSonidos));
        return bolaDeFuego;
    }

    private void configurarEntidad(Entidad entidad, Visitante visitante) {
        entidad.establecerVisitante(visitante);
        ObserverGrafico observerGrafico = new ObserverGrafico(entidad);
        entidad.establecerObserverGrafico(observerGrafico);
        this.generadorDeNivel.obtenerPantallaDeJuego().agregarLabel(observerGrafico);
    }
    
    private void configurarJugable(Jugable jugable, Visitante visitante) {
    	jugable.establecerVisitante(visitante);
        ObserverGrafico observerGrafico = new ObserverGrafico(jugable);
        jugable.establecerObserverGrafico(observerGrafico);
    }
    
}
