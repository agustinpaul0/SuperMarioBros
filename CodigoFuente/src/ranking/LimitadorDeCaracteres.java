package ranking;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class LimitadorDeCaracteres extends DocumentFilter {
	
	private int limiteCaracteres;
	
	public LimitadorDeCaracteres (int limiteCaracteres) {
		this.limiteCaracteres = limiteCaracteres;
	}
	
	public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (fb.getDocument().getLength() + string.length() <= limiteCaracteres) {
            super.insertString(fb, offset, string, attr);
        }
    }
	
	public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (fb.getDocument().getLength() + text.length() - length <= limiteCaracteres) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
	
}
