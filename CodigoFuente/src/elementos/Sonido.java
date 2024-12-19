package elementos;

public class Sonido {
	
	protected String rutaSonido;
	
	public Sonido(String rutaSonido) {
		this.rutaSonido = rutaSonido;
	}
	
	public String obtenerRutaSonido() {
		return this.rutaSonido;
	}
	
	public void establecerRutaSonido(String rutaSonido) {
		this.rutaSonido = rutaSonido;
	}
	
	public boolean equals(Sonido sonido) {
		return this.obtenerRutaSonido().equals(sonido.obtenerRutaSonido());
	}
	
}
