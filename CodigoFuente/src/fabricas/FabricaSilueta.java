package fabricas;

import elementos.Silueta;

public abstract class FabricaSilueta {

	protected String rutaACarpeta;
	
	protected FabricaSilueta(String rutaACarpeta) {
		this.rutaACarpeta = rutaACarpeta;
	}
	
	public abstract Silueta obtenerSilueta(int numeroNivel);
	
}
