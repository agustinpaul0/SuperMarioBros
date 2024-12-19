package ventanas;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class Pantalla extends JPanel {
	
	public abstract void refrescar();
	
	public boolean esRefrescable() {
		return true;
	}
	
}
