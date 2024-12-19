package observers;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import elementos.ElementoDeJuego;
import juego.ConstantesGlobales;

@SuppressWarnings("serial")
public class ObserverGrafico extends JLabel implements Observer {
	
	private ElementoDeJuego entidadObservada;
	
	private boolean removido;
	
	public ObserverGrafico(ElementoDeJuego entidadObservada) {
		super();
		this.entidadObservada = entidadObservada;
		this.removido = false;
	}
	
	public ElementoDeJuego obtenerEntidadObservada() {
		return this.entidadObservada;
	}
	
	public void establecerRemovido(boolean removido) {
		this.removido = removido;
	}
	
	public boolean obtenerRemovido() {
		return this.removido;
	}
	
	public void actualizar() {
		this.actualizarImagen();
		this.actualizarPosicionTamanio();
		this.actualizarVisibilidadElemento();
	}
	
	private void actualizarVisibilidadElemento() {
		if(this.entidadObservada.obtenerPosicionGrafica().x <  ConstantesGlobales.PANEL_ANCHO
		&& this.entidadObservada.obtenerPosicionGrafica().x + this.entidadObservada.obtenerAncho() > 0) {
			this.entidadObservada.establecerVisibleEnPantalla(true);
		} else {
			this.entidadObservada.establecerVisibleEnPantalla(false);
		}
	}

	protected void actualizarImagen() {
		String rutaImagen = entidadObservada.obtenerSprite().obtenerRutaImagen();
		ImageIcon icono = new ImageIcon(rutaImagen);
		this.setIcon(icono);
	}
	
	protected void actualizarPosicionTamanio() {
		int x = entidadObservada.obtenerPosicionGrafica().x;
		int y = entidadObservada.obtenerPosicionGrafica().y;
		int ancho = this.getIcon().getIconWidth();
		int alto = this.getIcon().getIconHeight();
		this.setBounds(x, y, ancho, alto);
	}
	
}
