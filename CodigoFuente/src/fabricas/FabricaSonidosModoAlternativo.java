package fabricas;
import elementos.Sonido;

public class FabricaSonidosModoAlternativo extends FabricaSonidos{

    public FabricaSonidosModoAlternativo(String rutaACarpeta) {
        super(rutaACarpeta);
    }

    @Override
    public Sonido obtenerAplastarEnemigo() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/aplastarEnemigo.wav");
    }
    
    @Override
    public Sonido obtenerAplastarEnemigo2() {
    	return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/aplastarEnemigo2.wav");
    }
    
    @Override
    public Sonido obtenerAplastarEnemigo3() {
    	return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/aplastarEnemigo3.wav");
    }

    @Override
    public Sonido obtenerChoqueFireball() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/choqueFireball.wav");
    }

    @Override
    public Sonido obtenerDisparoBolaFuego() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/disparoBolaFuego.wav");
    }

    @Override
    public Sonido obtenerGolpeBloque() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/golpeBloque.wav");
    }

    @Override
    public Sonido obtenerPowerUpEmerge() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/powerUpEmerge.wav");
    }

    @Override
    public Sonido obtenerMarioPequenioDeNuevo() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/marioPequenioDeNuevo.wav");
    }

    @Override
    public Sonido obtenerMatarBolaDeFuego() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/matarBolaDeFuego.wav");
    }

    @Override
    public Sonido obtenerModoInvulnerable() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/modoInvulnerable.wav");
    }
    
    @Override
    public Sonido obtenerModoRecuperacion() {
    	return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/modoRecuperacion.wav");
    }
    
    @Override
    public Sonido obtenerModoFuego() {
    	return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/modoFuego.wav");
    }

    @Override
    public Sonido obtenerSonidoMoneda() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/moneda.wav");
    }
    
    @Override
    public Sonido obtenerMusica(){
		return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/musicaModoAlternativo.wav");
	}

    @Override
    public Sonido obtenerPierdeJuego() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/pierdeJuego.wav");
    }

    @Override
    public Sonido obtenerPierdeVida() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/pierdeVida.wav");
    }

    @Override
    public Sonido obtenerPowerUpAgarrado() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/powerUpAgarrado.wav");
    }

    @Override
    public Sonido obtenerRomperLadrillo() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/romperLadrillo.wav");
    }

    @Override
    public Sonido obtenerSalto() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/salto.wav");
    }

    @Override
    public Sonido obtenerTocarBanderaFinNivel() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/tocarBanderaFinNivel.wav");
    }

    @Override
    public Sonido obtenerRecuperarVida() {
        return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/recuperarVida.wav");
    }
    
	@Override
	public Sonido obtenerRescatePrincesa() {
		return new Sonido(rutaACarpeta + "/sonidoModoAlternativo/rescatarPrincesa.wav");
	}
    
}
