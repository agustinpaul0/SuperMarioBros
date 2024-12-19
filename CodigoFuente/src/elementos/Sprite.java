package elementos;

import javax.swing.ImageIcon;

public class Sprite {
	
	protected String rutaImagen;
	
	public Sprite(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	public String obtenerRutaImagen() {
		return this.rutaImagen;
	}
	
	
	public int obtenerAnchoImagen() {
		ImageIcon imagen = new ImageIcon(this.obtenerRutaImagen());
		return imagen.getIconWidth();
	}
	
	public int obtenerAltoImagen() {
		ImageIcon imagen = new ImageIcon(this.obtenerRutaImagen());
		return imagen.getIconHeight();
	}
	
	public void establecerRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	
	public boolean equals(Sprite sprite) {
		return this.obtenerRutaImagen().equals(sprite.obtenerRutaImagen());
	}

}
