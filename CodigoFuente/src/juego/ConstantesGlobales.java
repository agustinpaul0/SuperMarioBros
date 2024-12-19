package juego;

import java.awt.Toolkit;

public class ConstantesGlobales {
	
	public static final int VENTANA_ALTO = 750;
	
	public static final int VENTANA_ANCHO = Math.round(Toolkit.getDefaultToolkit().getScreenSize().width * 0.8f);
	
	public static final int PANEL_ALTO = 750;
	
	public static final int PANEL_ANCHO = Math.round(Toolkit.getDefaultToolkit().getScreenSize().width * 0.8f);	
	
	public static final int MITAD_PANTALLA = (ConstantesGlobales.PANEL_ANCHO / 2) - 100;
	
    public static final int ANCHO_ALTO_BLOQUES_PLATAFORMA = 50;
	
	public static final int NIVEL_PISO = 600;
	
	public static final int VELOCIDAD_MOVIMIENTO_HORIZONTAL = 10;
	
	public static final int FUERZA_SALTO = -30;
	
	public static final int VELOCIDAD_MAXIMA_DE_CAIDA = 30;
	
	public static final int GRAVEDAD = 2;
	
	public static final int VELOCIDAD_HORIZONTAL_POWERUP = 2;
	
	public static final int VELOCIDAD_HORIZONTAL_ENEMIGO = 2;
	
}
