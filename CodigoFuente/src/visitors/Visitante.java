package visitors;

import elementos.enemigos.*;
import elementos.entidades.BolaDeFuego;
import elementos.personajes.*;
import elementos.plataformas.*;
import elementos.powerUps.*;

public interface Visitante {
    
    public void visitarBuzzyBeetle(BuzzyBeetle buzzyBeetle);

    public void visitarSpiny(Spiny spiny);

    public void visitarGoomba(Goomba goomba);
    
    public void visitarContextoKoopaTroopa(ContextoKoopaTroopa contextoKoopaTroopa);
    
    public void visitarKoopaEnCaparazon(KoopaEnCaparazon koopaEnCaparazon);

    public void visitarKoopaDefault(KoopaDefault koopaDefault);
    
    public void visitarLakitu(Lakitu lakitu);
    
    public void visitarPiranhaPlant(PiranhaPlant piranhaPlant);
    
    public void visitarBolaDeFuego(BolaDeFuego fireball);
    
    public void visitarSuperChampinion(SuperChampinion superChampinion);
    
    public void visitarFlorDeFuego(FlorDeFuego florDeFuego);

    public void visitarChampinionVerde(ChampinionVerde champinionVerde);
    
    public void visitarEstrella(Estrella estrella);
    
    public void visitarMoneda(Moneda monedas);

    public void visitarBloqueDePregunta(BloqueDePregunta bloqueDePregunta);

    public void visitarLadrillo(Ladrillo ladrillo);
    
    public void visitarPrincesaPeach(PrincesaPeach princesaPeach);

    public void visitarBandera(Bandera bandera);
    
    public void visitarTuberia(Tuberia tuberia);

    public void visitarBloqueSolido(BloqueSolido bloqueSolido);
    
    public void visitarContextoMario(ContextoMario contextoMario);
    
    public void visitarMarioDefault(MarioDefault marioDefault);
    
    public void visitarSuperMario(SuperMario superMario);

    public void visitarMarioFuego(MarioFuego marioFuego);
    
    public void visitarMarioInvulnerable(MarioInvulnerable marioInvulnerable);
    
    public void visitarMarioRecuperacion(MarioRecuperacion marioRecuperacion);
    
    public void visitarPiso(Piso piso);
    
    public void visitarVacio(Vacio vacio);
    
}

