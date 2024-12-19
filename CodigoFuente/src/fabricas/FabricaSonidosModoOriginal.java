package fabricas;

import elementos.Sonido;

public class FabricaSonidosModoOriginal extends FabricaSonidos{

	public FabricaSonidosModoOriginal(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	@Override
	public Sonido obtenerAplastarEnemigo() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/aplastarEnemigo.wav");
	}
	
	@Override
	public Sonido obtenerAplastarEnemigo2() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/aplastarEnemigo2.wav");
	}
	
	@Override
	public Sonido obtenerAplastarEnemigo3() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/aplastarEnemigo3.wav");
	}

	@Override
	public Sonido obtenerChoqueFireball() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/choqueFireball.wav");
	}

	@Override
	public Sonido obtenerDisparoBolaFuego() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/disparoBolaFuego.wav");
	}
	
	@Override
	public Sonido obtenerGolpeBloque() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/golpeBloque.wav");
	}

	@Override
	public Sonido obtenerPowerUpEmerge() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/powerUpEmerge.wav");
	}
	
	@Override
	public Sonido obtenerMarioPequenioDeNuevo() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/marioPequenioDeNuevo.wav");
	}
	
	@Override
	public Sonido obtenerMatarBolaDeFuego() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/matarBolaDeFuego.wav");
	}

	@Override
	public Sonido obtenerModoInvulnerable() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/modoInvulnerable.wav");
	}
	
	@Override
	public Sonido obtenerModoRecuperacion() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/marioRecuperacion.wav");
	}
	
	@Override
	public Sonido obtenerModoFuego() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/modoFuego.wav");
	}

	@Override
	public Sonido obtenerSonidoMoneda() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/moneda.wav");
	}
	
	@Override
	public Sonido obtenerMusica(){
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/musicaModoOriginal.wav");
	}
	
	@Override
	public Sonido obtenerPierdeJuego() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/pierdeJuego.wav");
	}
	
	@Override
	public Sonido obtenerPierdeVida() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/pierdeVida.wav");
	}
	
	@Override
	public Sonido obtenerPowerUpAgarrado() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/powerUpAgarrado.wav");
	}

	@Override
	public Sonido obtenerRomperLadrillo() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/romperLadrillo.wav");
	}

	@Override
	public Sonido obtenerSalto() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/salto.wav");
	}

	@Override
	public Sonido obtenerTocarBanderaFinNivel() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/tocarBanderaFinNivel.wav");
	}

	@Override
	public Sonido obtenerRecuperarVida() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/recuperarVida.wav");
	}

	@Override
	public Sonido obtenerRescatePrincesa() {
		return new Sonido(rutaACarpeta + "/sonidoModoOriginal/rescatarPrincesa.wav");
	}
	
}
