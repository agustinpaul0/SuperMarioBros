package elementos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Silueta {
    
	protected String rutaImagen;
	
    private BufferedImage imagenCargada;  
    
	public Silueta(String rutaImagen) {
		this.rutaImagen = rutaImagen;
		this.cargarImagen();  
	}
	
	private void cargarImagen() {
		try {
			this.imagenCargada = ImageIO.read(new File(obtenerRutaSilueta()));
		} catch (IOException exception) {
			System.err.println("El error está en Silueta.java");
			System.err.println("Error al cargar la imagen desde la ruta: " + obtenerRutaSilueta());
			System.err.println("Detalles del error: " + exception.getMessage());
			this.imagenCargada = null;  
		}
	}
	
	public String obtenerRutaSilueta() {
		return this.rutaImagen;
	}
	
	public void establecerRutaSilueta(String rutaImagen) {
		this.rutaImagen = rutaImagen;
		this.cargarImagen(); 
	}

	public int obtenerAncho() {
		if (this.imagenCargada !=  null) {
            return this.imagenCargada.getWidth();
        } else {
            System.err.println("Imagen no cargada.");
            return 0;
        }
	}
	
	public int obtenerAlto() {
		if (this.imagenCargada !=  null) {
            return this.imagenCargada.getHeight();
        } else {
            System.err.println("Imagen no cargada.");
            return 0;
        }
	}
	
}
