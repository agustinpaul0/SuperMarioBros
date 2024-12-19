package juego;

import java.awt.Point;
import elementos.ElementoDeJuego;
import elementos.enemigos.Enemigo;
import elementos.entidades.BolaDeFuego;
import elementos.entidades.Entidad;
import elementos.plataformas.Plataforma;
import elementos.powerUps.PowerUp;
import fabricas.FabricaSprites;

public class MasterMind {
	
	protected FabricaSprites fabricaSprites;
	
	protected Nivel nivel;
	
	protected boolean movimientoEnemigosActivo;
	
	public MasterMind(FabricaSprites fabricaSprites, Nivel nivel) {
		this.fabricaSprites = fabricaSprites;
		this.nivel = nivel;
		movimientoEnemigosActivo = false;
	}

	public void actualizar() {
		this.actualizarEnemigos();
		this.actualizarPowerUps();
		this.actualizarBolasDeFuego();
		this.actualizarPlataformas();
	}
	
	private void actualizarEnemigos() {
		for (Enemigo enemigo : this.nivel.obtenerEnemigos()) {
			this.moverEnemigo(enemigo);
			enemigo.actualizarSprite(this.fabricaSprites);
			enemigo.obtenerObserverGrafico().actualizar();
		}
	}
	
	private void actualizarPowerUps() {
		for (PowerUp powerUp : this.nivel.obtenerPowerUps()) {
			this.moverPowerUp(powerUp);
			powerUp.actualizarSprite(this.fabricaSprites);
			powerUp.obtenerObserverGrafico().actualizar();
		}
	}
	
	private void actualizarBolasDeFuego() {
		for (BolaDeFuego bola : this.nivel.obtenerBolasDeFuego()) {
			this.moverBolaDeFuego(bola);
			bola.actualizarSprite(this.fabricaSprites);
			bola.obtenerObserverGrafico().actualizar();
		}
	}
	
	private void actualizarPlataformas() {
		for (Plataforma plataforma: this.nivel.obtenerPlataformasAfectables()) {
			plataforma.actualizarSprite(this.fabricaSprites);
			plataforma.obtenerObserverGrafico().actualizar();
		}
	}
		
	public void cambiarNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	private void moverEnemigo(Enemigo enemigo) {
		if (enemigo.obtenerVisibleEnPantalla()) {
			this.agregarEntidadVisible(enemigo);
			if (this.movimientoEnemigosActivo) {
				enemigo.mover();
				enemigo.aplicarGravedad();
			} else {
				enemigo.establecerVelocidadDireccional(new Point(0,0));
			}
		} else {
			this.nivel.removerEntidadVisible(enemigo);
		}
		this.chequearChoqueBordesEnemigo(enemigo);
		this.cambiarYVerificarPosicionHitboxDeEntidad(enemigo);
	}
	
	private void agregarEntidadVisible(Entidad entidad) {
		if (!this.nivel.estaEntidadVisible(entidad)) {
			this.nivel.agregarEntidadVisible(entidad);
		}
	}
	
	private void chequearChoqueBordesEnemigo(Enemigo enemigo) {
		boolean chocoBordeIzquierdo = enemigo.obtenerPosicionGrafica().x <=  0; 
		boolean chocoBordeDerecho = enemigo.obtenerPosicionGrafica().x + enemigo.obtenerAncho() >=  ConstantesGlobales.PANEL_ANCHO;									
		if (enemigo.obtenerDebeMantenerseSiempreEnPantalla()) {
			if (chocoBordeIzquierdo) {
				this.chocarBordeIzquierdo(enemigo);
			} else if (chocoBordeDerecho) {
				this.chocarBordeDerecho(enemigo);
			}
		}
	}

	private void chocarBordeIzquierdo(Enemigo enemigo) {
		int desplazamientoHaciaFueraDeLaPantalla = Math.abs(enemigo.obtenerPosicionGrafica().x);
		Point nuevaPosicionGrafica = new Point(enemigo.obtenerPosicionGrafica().x + desplazamientoHaciaFueraDeLaPantalla, enemigo.obtenerPosicionGrafica().y);
		enemigo.establecerPosicionGrafica(nuevaPosicionGrafica);
		Point nuevaPosicionLogica = new Point(enemigo.obtenerPosicionLogica().x + desplazamientoHaciaFueraDeLaPantalla, enemigo.obtenerPosicionLogica().y);
		enemigo.establecerPosicionLogica(nuevaPosicionLogica);
		enemigo.moverHitbox(nuevaPosicionLogica);
		enemigo.invertirDireccion();
	}
	
	private void chocarBordeDerecho(Enemigo enemigo) {
		int desplazamientoHaciaFueraDeLaPantalla = enemigo.obtenerPosicionGrafica().x + enemigo.obtenerAncho() - ConstantesGlobales.PANEL_ANCHO;
		Point nuevaPosicionGrafica = new Point(enemigo.obtenerPosicionGrafica().x - desplazamientoHaciaFueraDeLaPantalla, enemigo.obtenerPosicionGrafica().y);
		Point nuevaPosicionLogica = new Point(enemigo.obtenerPosicionLogica().x - desplazamientoHaciaFueraDeLaPantalla, enemigo.obtenerPosicionLogica().y);
		enemigo.establecerPosicionLogica(nuevaPosicionLogica);
		enemigo.establecerPosicionGrafica(nuevaPosicionGrafica);
		enemigo.moverHitbox(nuevaPosicionLogica);
		enemigo.invertirDireccion();
	}

	private void moverPowerUp(PowerUp powerUp) {
		if (powerUp.obtenerVisibleEnPantalla()) {
			this.agregarEntidadVisible(powerUp);
			this.realizarComportamientoPowerUp(powerUp);
			if (!powerUp.estaDentroDeBloqueDePreguntas()) {
				powerUp.aplicarGravedad();
			}
		}else {
			this.nivel.removerEntidadVisible(powerUp);
		}
	}
	
	private void realizarComportamientoPowerUp(PowerUp powerUp) {
		boolean ticksEnCero = powerUp.obtenerContadorTicks() ==  0;
		boolean ticksAlcanzaronMarca = powerUp.obtenerContadorTicks() ==  powerUp.obtenerTicksHastaSalirDelBloque();
		if (!powerUp.estaDentroDeBloqueDePreguntas() && ticksEnCero) {
			sacarPowerUpDeBloqueDePreguntas(powerUp);
			powerUp.incrementarContadorTicks();
		} else if (!powerUp.estaDentroDeBloqueDePreguntas() && ticksAlcanzaronMarca && powerUp.esMovible()) {
			powerUp.mover();
			powerUp.aplicarGravedad();
		} else if (!ticksEnCero && !ticksAlcanzaronMarca) {
			powerUp.incrementarContadorTicks();
		}
		this.cambiarYVerificarPosicionHitboxDeEntidad(powerUp);
	}
	
	private void sacarPowerUpDeBloqueDePreguntas(PowerUp powerUp) {
		powerUp.establecerPosicion(new Point(powerUp.obtenerPosicionLogica().x, powerUp.obtenerBloquePregunta().obtenerPosicionLogica().y - powerUp.obtenerAlto()));
		powerUp.moverHitbox(powerUp.obtenerPosicionLogica());
		powerUp.actualizarSprite(this.fabricaSprites);
	}

	private void moverBolaDeFuego(BolaDeFuego bolaFuego) {
		if (bolaFuego.obtenerVisibleEnPantalla()) {
			if (!this.nivel.estaEntidadVisible(bolaFuego)) {
				this.nivel.agregarEntidadVisible(bolaFuego);
			}
			bolaFuego.aplicarGravedad();
			this.cambiarYVerificarPosicionHitboxDeEntidad(bolaFuego);
		} else {
			this.nivel.removerEntidadVisible(bolaFuego);
		}
	}
	
	private void cambiarYVerificarPosicionHitboxDeEntidad(Entidad entidad) {
		this.cambiarPosicionXHitboxDeEntidad(entidad);
		this.verificarColisiones(entidad);
		this.cambiarPosicionYHitboxDeEntidad(entidad);
		this.verificarColisiones(entidad);
	}
	
	private void cambiarPosicionXHitboxDeEntidad(Entidad entidad) {
		int nuevaPosicionX = entidad.obtenerHitbox().x + entidad.obtenerVelocidadDireccional().x;
		Point nuevaPosicion = new Point(nuevaPosicionX, entidad.obtenerHitbox().y);
		entidad.moverHitbox(nuevaPosicion);
	}
	
	private void cambiarPosicionYHitboxDeEntidad(Entidad entidad) {
		int nuevaPosicionY = entidad.obtenerHitbox().y + entidad.obtenerVelocidadDireccional().y;
		Point nuevaPosicion = new Point(entidad.obtenerHitbox().x, nuevaPosicionY);
		entidad.moverHitbox(nuevaPosicion);
	}
	
	private void verificarColisiones(Entidad entidad) {
		this.verificarColisionConPlataformas(entidad);
		this.verificarColisionesConEntidades(entidad);
	}
	
	private void verificarColisionesConEntidades(Entidad entidad) {
		if ((entidad.obtenerPosicionGrafica().x + entidad.obtenerAncho() < -50) && !entidad.obtenerDebeMantenerseSiempreEnPantalla()) {
			entidad.establecerRemovido(true);
		} else {
			for (ElementoDeJuego elemento : this.nivel.obtenerEntidadesVisiblesEnPantalla()) {
		        if (entidad.huboColision(elemento) && entidad !=  elemento) {
		            elemento.aceptarVisitante(entidad.obtenerVisitante());
		            entidad.aceptarVisitante(elemento.obtenerVisitante());
		        }
		    }
		}
		entidad.establecerPosicion(entidad.obtenerHitbox().getLocation());
	}
	
	private void verificarColisionConPlataformas(Entidad entidad) {
		for (Plataforma plataforma : this.nivel.obtenerPlataformasAdyacentes(entidad)) {
	        if (plataforma != null && entidad.huboColision(plataforma)) {
	        	plataforma.aceptarVisitante(entidad.obtenerVisitante());
	            entidad.aceptarVisitante(plataforma.obtenerVisitante());
	        }
	    }
	}

	public void desactivarMovimientoEnemigos() {
		this.movimientoEnemigosActivo = false;
	}

	public void activarMovimientoEnemigos() {
		this.movimientoEnemigosActivo = true;
	}
	
}