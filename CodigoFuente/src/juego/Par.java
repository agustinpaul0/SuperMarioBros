package juego;

public class Par {
	
	private int primerComponente; 
	
	private int segundoComponente;
	
	public Par(int primerComponente, int segundoComponente) {
		this.primerComponente = primerComponente;
		this.segundoComponente = segundoComponente;
	}
	
	public int obtenerPrimerComponente() {
		return this.primerComponente;
	}
	
	public int obtenerSegundoComponente() {
		return this.segundoComponente;
	}
	
	public void establecerPrimero(int primerComponente) {
		this.primerComponente = primerComponente;
	}
	
	public void establecerSegundo(int segundoComponente) {
		this.segundoComponente = segundoComponente;
	}
	
}
