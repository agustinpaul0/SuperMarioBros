package fabricas;

import elementos.Sonido;

public abstract class FabricaSonidos {
	
	protected String rutaACarpeta;
	
	public FabricaSonidos(String rutaACarpeta) {
		this.rutaACarpeta = rutaACarpeta;
	}
	
	public abstract Sonido obtenerAplastarEnemigo();

	public abstract Sonido obtenerAplastarEnemigo2();

	public abstract Sonido obtenerAplastarEnemigo3();
	
	public abstract Sonido obtenerChoqueFireball();
	
	public abstract Sonido obtenerDisparoBolaFuego();
	
	public abstract Sonido obtenerGolpeBloque();
	
	public abstract Sonido obtenerPowerUpEmerge();
	
	public abstract Sonido obtenerMarioPequenioDeNuevo();
	
	public abstract Sonido obtenerMatarBolaDeFuego();
	
	public abstract Sonido obtenerModoInvulnerable();

	public abstract Sonido obtenerModoRecuperacion();

	public abstract Sonido obtenerModoFuego();
	
	public abstract Sonido obtenerSonidoMoneda();
	
	public abstract Sonido obtenerMusica();
	
	public abstract Sonido obtenerPierdeJuego();
	
	public abstract Sonido obtenerPierdeVida();
	
	public abstract Sonido obtenerPowerUpAgarrado();
	
	public abstract Sonido obtenerRomperLadrillo();
	
	public abstract Sonido obtenerSalto();
	
	public abstract Sonido obtenerTocarBanderaFinNivel();
	
	public abstract Sonido obtenerRecuperarVida();
	
	public abstract Sonido obtenerRescatePrincesa();

}
