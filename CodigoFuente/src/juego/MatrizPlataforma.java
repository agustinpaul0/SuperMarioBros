package juego;

import java.awt.Point;
import java.util.ArrayList;

import elementos.entidades.Entidad;
import elementos.plataformas.Plataforma;

public class MatrizPlataforma {
    
    private static final int TAMANIO_CELDA = 50;
    
    private int columnas;
    
    private int filas;
    
    private Plataforma [][]grilla;
    
    public MatrizPlataforma(int anchoMapa, int altoMapa) {
        this.columnas = anchoMapa*2/TAMANIO_CELDA;
        // Se multiplica por 2 porque el piso se mueve a la mitad de la velocidad del fondo
        this.filas = (altoMapa/TAMANIO_CELDA)+2;
        // Se le añaden dos a las filas para modelar el vacio que se encuentra en -1
        this.grilla = new Plataforma[this.filas][this.columnas];
    }
    
    public Iterable<Plataforma> obtenerAdyacentes(Entidad entidad) {
		ArrayList<Plataforma> listaDePlataformasAdyacentes = new ArrayList<>();
		Point puntoEnLaGrilla = posicionEnLaGrilla(entidad);
		for (int y = puntoEnLaGrilla.y-2; y <= puntoEnLaGrilla.y+2; y++) {
			for (int x = puntoEnLaGrilla.x-2; x <= puntoEnLaGrilla.x+2; x++) {
				if (estanEnRango(x, y)) {
					Plataforma plataforma = this.grilla[y][x];
					if (plataforma != null) {
						listaDePlataformasAdyacentes.add(plataforma);
					}
				}
			}
		}
		return listaDePlataformasAdyacentes;
	}
	
	public Iterable<Plataforma> obtenerTodasLasPlataformas() {
		ArrayList<Plataforma> listaDePlataformas = new ArrayList<>();
		for (int y = 0-2; y <= this.filas; y++) {
			for (int x = 0; x <= this.columnas; x++) {
				if (estanEnRango(x, y)) {
					Plataforma plataforma = this.grilla[y][x];
					if (plataforma!=null) {
						listaDePlataformas.add(plataforma);
					}
				}
			}
		}
		return listaDePlataformas;
	}
    
    public void agregarPlataforma(Plataforma plataforma) {
    	Point posicionPlataforma = plataforma.obtenerPosicionLogica();
        int altoPlataforma = plataforma.obtenerAlto();
        int anchoPlataforma = plataforma.obtenerAncho();
        int posX = posicionPlataforma.x;
        int posY = posicionPlataforma.y;
        for (int i = posX; i < posX + anchoPlataforma; i += TAMANIO_CELDA) {
        	for (int j = posY; j < posY + altoPlataforma; j += TAMANIO_CELDA) {
        		this.grilla[j/TAMANIO_CELDA][i/TAMANIO_CELDA] = plataforma;
        		
        	}
        }
    }
    
    public void removerPlataforma(Plataforma plataforma) {
    	Point posicionPlataforma = plataforma.obtenerPosicionLogica();
        int altoPlataforma = plataforma.obtenerAlto();
        int anchoPlataforma = plataforma.obtenerAncho();
        int posX = posicionPlataforma.x;
        int posY = posicionPlataforma.y;
        for (int i = posX; i < posX + anchoPlataforma; i += TAMANIO_CELDA) {
        	for (int j = posY; j < posY + altoPlataforma; j += TAMANIO_CELDA) {
        		this.grilla[j/TAMANIO_CELDA][i/TAMANIO_CELDA] = null;
        	}
        }
    }
       
	private boolean estanEnRango(int x, int y) {
		return (x >= 0 && x < this.columnas && y >= 0 && y < this.filas); 
	}
	
	private Point posicionEnLaGrilla(Entidad entidad) {
		float posicionXDeElementoSinRedondear = entidad.obtenerPosicionLogica().x/(TAMANIO_CELDA* 1.0f);
		float posicionYDeElementoSinRedondear = entidad.obtenerPosicionLogica().y/(TAMANIO_CELDA* 1.0f);
		int posicionXDeElementoEnLaGrilla = Math.round(posicionXDeElementoSinRedondear);
		int posicionYDeElementoEnLaGrilla = Math.round(posicionYDeElementoSinRedondear);
		return new Point(posicionXDeElementoEnLaGrilla,posicionYDeElementoEnLaGrilla);
	}
	
}