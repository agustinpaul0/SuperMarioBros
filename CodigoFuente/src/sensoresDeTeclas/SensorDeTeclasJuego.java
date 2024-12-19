package sensoresDeTeclas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SensorDeTeclasJuego implements KeyListener{
	
	private boolean teclaAPresionada;
	
	private boolean teclaDPresionada;
	
	private boolean teclaWPresionada;
	
	private boolean teclaWAccionada;
	
	private boolean teclaEspacioPresionada;
	
	private boolean teclaEsapcioAccionado;
	
	public SensorDeTeclasJuego() {
		this.teclaAPresionada = false;
		this.teclaDPresionada = false;
		this.teclaWPresionada = false;
		this.teclaWAccionada = false;
		this.teclaEspacioPresionada = false;
		this.teclaEsapcioAccionado = false;
	}
	
	public void establecerWAccionada(boolean accionada) {
		this.teclaWAccionada = accionada;
	}
	
	public void establecerSpaceAccionada(boolean accionada) {
		this.teclaEsapcioAccionado = accionada;
	}
	
	public boolean obtenerAPresionada() {
		return teclaAPresionada;
	}
	
	public boolean obtenerDPresionada() {
		return teclaDPresionada;
	}
	
	public boolean obtenerWPresionada() {
		return teclaWPresionada;
	}
	
	public boolean obtenerSpacePresionada() {
		return teclaEspacioPresionada;
	}
	
	public boolean obtenerSpaceAccionada() {
		return teclaEsapcioAccionado;
	}
	
	public boolean obtenerWAccionada() {
		return teclaWAccionada;
	}

	public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode ==  KeyEvent.VK_A) {
        	this.teclaAPresionada = true;
        } else if (keyCode ==  KeyEvent.VK_D) {
        	this.teclaDPresionada = true;
        } else if (keyCode ==  KeyEvent.VK_W) {
        	this.teclaWPresionada = true;
        } else if (keyCode ==  KeyEvent.VK_SPACE) {
        	this.teclaEspacioPresionada = true;
        }
    }

    public void keyReleased(KeyEvent e) {
    	int keyCode = e.getKeyCode();
        if (keyCode ==  KeyEvent.VK_A) {
        	this.teclaAPresionada = false;
        } else if (keyCode ==  KeyEvent.VK_D) {
            teclaDPresionada = false;
        } else if (keyCode ==  KeyEvent.VK_W) {
        	this.teclaWAccionada = false;
        	this.teclaWPresionada = false;
        } else if (keyCode ==  KeyEvent.VK_SPACE) {
        	this.teclaEsapcioAccionado = false;
        	this.teclaEspacioPresionada = false;
        }
    }

    public void keyTyped(KeyEvent e) {
    }

}
