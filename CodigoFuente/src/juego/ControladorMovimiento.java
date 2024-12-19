package juego;

import java.awt.Point;
import elementos.ElementoDeJuego;
import elementos.entidades.Entidad;
import elementos.entidades.Jugable;
import sensoresDeTeclas.SensorDeTeclasJuego;

public class ControladorMovimiento {
	
	private SensorDeTeclasJuego sensorDeTeclasJuego;
	
	protected boolean movimientoPersonajeActivo;
	
	private Nivel nivel;
	
	public ControladorMovimiento(SensorDeTeclasJuego sensorDeTeclasJuego, Nivel nivel) {
		this.sensorDeTeclasJuego = sensorDeTeclasJuego;
		this.nivel = nivel;
		this.nivel.obtenerJugable().establecerVelocidadDireccional(new Point(0,0));
		this.movimientoPersonajeActivo = false;
	}
	
	public void actualizarNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	public void actualizarPosicion() {
		this.reiniciarVelocidadHorizontal();
		if (movimientoPersonajeActivo) {
			this.determinarAccion();
		}
		this.nivel.obtenerJugable().aplicarGravedad();
		this.cambiarYVerificarPosicionHitboxDelJugador();
	}
	
	private void reiniciarVelocidadHorizontal() {
		this.cambiarVelocidadHorizontal(0);
		this.nivel.obtenerJugable().establecerAvanzando(false);
		this.nivel.obtenerJugable().establecerRetrocediendo(false);
	}
	
	private void determinarAccion() {
		if (this.deteccionSalto() && this.nivel.obtenerJugable().obtenerColisionAbajo()) {
			this.iniciarSalto();
		} 
		if (this.deteccionMovimientoAIzquierda()) {
			this.realizarMovimientoALaIzquierda();
		}
		if (this.deteccionMovimientoADerecha()) {
			this.realizarMovimientoALaDerecha();
		}
		if (this.deteccionAccionEspecial()) {
			this.realizarAccionEspecial();
		}
	}
	
	private void cambiarYVerificarPosicionHitboxDelJugador() {
		this.nivel.obtenerJugable().establecerColisionAbajo(false);
		this.cambiarPosicionXDeLaHitboxDelJugador();
		this.verificarColisiones();
		this.cambiarPosicionYDeLaHitboxDelJugador();
		this.verificarColisiones();
	}
	
	public void desactivarMovimientoPersonaje() {
		this.movimientoPersonajeActivo = false;
	}
	
	public void activarMovimientoPersonaje() {
		this.movimientoPersonajeActivo = true;
	}

	private void verificarColisiones() {
		if (!this.nivel.fueCompletado()) {
			this.chequearChoquesConBordes();
			this.verificarColisionConPlataformas();
			this.verificarColisionConEntidades();
			this.nivel.obtenerJugable().establecerPosicion(this.nivel.obtenerJugable().obtenerHitbox().getLocation());
		} else {
			this.nivel.obtenerPartida().cambiarNivel();
		}
	}
	
	private void verificarColisionConPlataformas() {
	    for (ElementoDeJuego elemento : this.nivel.obtenerPlataformasAdyacentes(this.nivel.obtenerJugable())) {
	    	if (elemento != null && this.nivel.obtenerJugable().huboColision(elemento)) {
	            elemento.aceptarVisitante(this.nivel.obtenerJugable().obtenerVisitante());
	            this.nivel.obtenerJugable().aceptarVisitante(elemento.obtenerVisitante());
	        }
	    }
	    
	}
	
	private void verificarColisionConEntidades() {
		for (Entidad entidad : this.nivel.obtenerEntidadesVisiblesEnPantalla()) {
	        if (entidad != null && this.nivel.obtenerJugable().huboColision(entidad)) {
	        	entidad.aceptarVisitante(this.nivel.obtenerJugable().obtenerVisitante());
	        	this.nivel.obtenerJugable().aceptarVisitante(entidad.obtenerVisitante());
	        }
	    }
		
	}

	private void chequearChoquesConBordes() {
		boolean marioChocoBordeIzquierdo = this.nivel.obtenerJugable().obtenerPosicionGrafica().x < 0;
		boolean marioChocoBordeDerecho = this.nivel.obtenerJugable().obtenerPosicionGrafica().x + this.nivel.obtenerJugable().obtenerHitbox().width > ConstantesGlobales.PANEL_ANCHO;
		if (marioChocoBordeIzquierdo) {
			this.chocarBordeIzquierdo();
		} else if (marioChocoBordeDerecho) {
			this.chocarBordeDerecho();
		}
	}

	private void chocarBordeIzquierdo() {
		int nuevaPosicionLogicaX = this.nivel.obtenerJugable().obtenerPosicionLogica().x - this.nivel.obtenerJugable().obtenerPosicionGrafica().x;
		Point nuevaPosicionLogica = new Point(nuevaPosicionLogicaX, this.nivel.obtenerJugable().obtenerPosicionLogica().y);
		this.nivel.obtenerJugable().establecerPosicionLogica(nuevaPosicionLogica);
		this.nivel.obtenerJugable().establecerPosicionGrafica(new Point(0, this.nivel.obtenerJugable().obtenerPosicionLogica().y));
		this.nivel.obtenerJugable().moverHitbox(new Point(nuevaPosicionLogicaX, this.nivel.obtenerJugable().obtenerHitbox().y));
	}

	private void chocarBordeDerecho() {
		int desplazamientoLogicoX = ConstantesGlobales.PANEL_ANCHO - (ConstantesGlobales.PANEL_ANCHO + nivel.obtenerJugable().obtenerAncho());
		int nuevaPosicionLogicaX = this.nivel.obtenerJugable().obtenerPosicionLogica().x + desplazamientoLogicoX;
		Point nuevaPosicionLogica = new Point(nuevaPosicionLogicaX, this.nivel.obtenerJugable().obtenerPosicionLogica().y);
		this.nivel.obtenerJugable().establecerPosicionLogica(nuevaPosicionLogica);
		this.nivel.obtenerJugable().establecerPosicionGrafica(new Point(0, this.nivel.obtenerJugable().obtenerPosicionLogica().y));
		this.nivel.obtenerJugable().moverHitbox(new Point(nuevaPosicionLogicaX, this.nivel.obtenerJugable().obtenerHitbox().y));		
	}

	private void cambiarPosicionXDeLaHitboxDelJugador() {
		int nuevaPosicionX = this.nivel.obtenerJugable().obtenerHitbox().x + this.nivel.obtenerJugable().obtenerVelocidadDireccional().x;
		Point nuevaPosicion = new Point(nuevaPosicionX, this.nivel.obtenerJugable().obtenerPosicionLogica().y);
		this.nivel.obtenerJugable().moverHitbox(nuevaPosicion);
	}
	
	private void cambiarPosicionYDeLaHitboxDelJugador() {
		int nuevaPosicionY = this.nivel.obtenerJugable().obtenerHitbox().y + this.nivel.obtenerJugable().obtenerVelocidadDireccional().y;
		Point nuevaPosicion = new Point(this.nivel.obtenerJugable().obtenerPosicionLogica().x, nuevaPosicionY);
		this.nivel.obtenerJugable().moverHitbox(nuevaPosicion);
	}

	private boolean deteccionSalto() {
		boolean retornar = false;
		if (this.sensorDeTeclasJuego.obtenerWPresionada()) {
			retornar = !this.sensorDeTeclasJuego.obtenerWAccionada();
			this.sensorDeTeclasJuego.establecerWAccionada(true);
		}
		return retornar;
	}
	
	private boolean deteccionMovimientoAIzquierda() {
		return this.sensorDeTeclasJuego.obtenerAPresionada() && !this.sensorDeTeclasJuego.obtenerDPresionada();
	}
	
	private boolean deteccionMovimientoADerecha() {
		return this.sensorDeTeclasJuego.obtenerDPresionada() && !this.sensorDeTeclasJuego.obtenerAPresionada();
	}
	
	private boolean deteccionAccionEspecial() {
		boolean retornar = false;
		if (this.sensorDeTeclasJuego.obtenerSpacePresionada()) {
			retornar = !this.sensorDeTeclasJuego.obtenerSpaceAccionada();
			this.sensorDeTeclasJuego.establecerSpaceAccionada(true);
		}
		return retornar;
	}
	
	private void iniciarSalto() {
		this.cambiarVelocidadVertical(ConstantesGlobales.FUERZA_SALTO);
		this.nivel.obtenerJugable().establecerColisionAbajo(false);
		this.nivel.obtenerJugable().obtenerNivel().obtenerPartida().obtenerGeneradorSonidos().salto();
	}
	
	private void realizarMovimientoALaIzquierda() {
		this.cambiarVelocidadHorizontal(-ConstantesGlobales.VELOCIDAD_MOVIMIENTO_HORIZONTAL);
		this.nivel.obtenerJugable().establecerMirandoAlFrente(false);
		this.nivel.obtenerJugable().establecerRetrocediendo(true);
	}
	
	private void realizarMovimientoALaDerecha() {
		this.cambiarVelocidadHorizontal(ConstantesGlobales.VELOCIDAD_MOVIMIENTO_HORIZONTAL);
		this.nivel.obtenerJugable().establecerMirandoAlFrente(true);
		this.nivel.obtenerJugable().establecerAvanzando(true);
	}

	private void realizarAccionEspecial() {
		this.nivel.obtenerJugable().realizarAccionEspecial();
	}

	private void cambiarVelocidadHorizontal(int velocidadX) {
		int nuevaVelocidadX = velocidadX;
		int velocidadY = this.nivel.obtenerJugable().obtenerVelocidadDireccional().y;
		Point nuevaVelocidad = new Point(nuevaVelocidadX,velocidadY);
		this.nivel.obtenerJugable().establecerVelocidadDireccional(nuevaVelocidad);
	}
	
	private void cambiarVelocidadVertical(int velocidadY) {
		int nuevaVelocidadY = velocidadY;
		int velocidadX = this.nivel.obtenerJugable().obtenerVelocidadDireccional().x;
		Point nuevaVelocidad = new Point(velocidadX,nuevaVelocidadY);
		this.nivel.obtenerJugable().establecerVelocidadDireccional(nuevaVelocidad);
	}
	
}

