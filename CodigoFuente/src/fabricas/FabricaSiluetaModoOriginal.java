package fabricas;

import elementos.Silueta;

public class FabricaSiluetaModoOriginal extends FabricaSilueta {

	public FabricaSiluetaModoOriginal(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	@Override
	public Silueta obtenerSilueta(int numeroNivel) {
		return new Silueta(rutaACarpeta + "/siluetaModoOriginal/siluetaNivel-" + numeroNivel + ".png");
	}

}
