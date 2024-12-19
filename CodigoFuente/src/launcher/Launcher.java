package launcher;

import juego.Juego;
import ventanas.ControladorVistas;

public class Launcher {
	
    public static void main(String[] args) {
    	Juego juego = new Juego();
        juego.establecerControladorVistas(new ControladorVistas(juego)); 
    }
    
}