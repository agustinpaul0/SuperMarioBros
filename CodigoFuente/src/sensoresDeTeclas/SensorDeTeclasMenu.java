package sensoresDeTeclas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SensorDeTeclasMenu implements KeyListener{
	
	private boolean teclaWPresionada;

	private boolean teclaWAccionada;

	private boolean teclaSAccionada;
	
	private boolean teclaSPresionada;
	
	private boolean teclaEnterPresionada;
	
	private boolean teclaEnterAccionado;
	
	public SensorDeTeclasMenu() {
		this.teclaSPresionada = false;
		this.teclaWPresionada = false;
		this.teclaEnterPresionada = false;
		this.teclaWAccionada = false;
		this.teclaSAccionada = false;
		this.teclaEnterAccionado = false;
	}
	
	public boolean obtenerSPresionado() {
		return this.teclaSPresionada;
	}
	
	public boolean obtenerWPresionado() {
		return this.teclaWPresionada;
	}
	
	public boolean obtenerWAccionada() {
		return this.teclaWAccionada;
	}
	
	public boolean obtenerSAccionada() {
		return this.teclaSAccionada;
	}
	
	public boolean obtenerEnterPresionado() {
		return this.teclaEnterPresionada;
	}
	
	public boolean obtenerEnterAccionada() {
		return this.teclaEnterAccionado;
	}

	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode ==  KeyEvent.VK_ENTER) {
			this.teclaEnterPresionada = true;
		} else if (keyCode ==  KeyEvent.VK_S) {
			this.teclaSPresionada = true;
		} else if (keyCode ==  KeyEvent.VK_W) {
			this.teclaWPresionada = true;
		}
    }

    public void keyReleased(KeyEvent e) {
    	int keyCode = e.getKeyCode();
    	if (keyCode ==  KeyEvent.VK_ENTER) {
    		this.teclaEnterPresionada = false;
    		this.teclaEnterAccionado = false;
    	} else if (keyCode ==  KeyEvent.VK_S) {
    		this.teclaSPresionada = false;
    		this.teclaSAccionada = false;
    	} else if (keyCode ==  KeyEvent.VK_W) {
    		this.teclaWPresionada = false;
    		this.teclaWAccionada = false;
    	}
    }

    public void keyTyped(KeyEvent e) {
    }
    
    public void accionarW() {
    	this.teclaWAccionada = true;
    }
    
    public void accionarS() {
    	this.teclaSAccionada = true;
    }
    
    public void accionarEnter() {
    	this.teclaEnterAccionado = true;
    }
    
}
