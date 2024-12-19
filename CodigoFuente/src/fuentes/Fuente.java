package fuentes;

import java.awt.Font;
import java.io.InputStream;

public class Fuente {

    private Font font;

    private String nombreFuente;

    public Fuente(){
    	this.nombreFuente = "VT323-Regular.ttf";
    }
    
    @SuppressWarnings("exports")
	public Font fuente( String fontName, int estilo, float tamanio){
         try {
            InputStream is =  getClass().getResourceAsStream(fontName);
            font = Font.createFont(Font.TRUETYPE_FONT, is);
        } catch (Exception ex) {
            System.err.println("La fuente " + fontName + " no se pudo cargar. Cargando Arial...");
            font = new Font("Arial", Font.PLAIN, 14);
        }
        return font.deriveFont(estilo, tamanio);
    }
    
    public String nombreFuente() {
    	return this.nombreFuente;
    }
}