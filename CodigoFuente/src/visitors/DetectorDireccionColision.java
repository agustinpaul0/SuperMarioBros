package visitors;

import java.awt.Point;

import elementos.ElementoDeJuego;
import elementos.entidades.Entidad;

public class DetectorDireccionColision {
	
	public void verificarColisionElementoDeJuegoYEntidad(ElementoDeJuego elementoDeJuego, Entidad entidad) {
		if (choquePorDerecha(elementoDeJuego, entidad)) {
	    	this.realizarRespuestaAChoquePorDerecha(elementoDeJuego, entidad);
		} else if (choquePorIzquierda(elementoDeJuego, entidad)) {
	    	this.realizarRespuestaAChoquePorIzquierda(elementoDeJuego, entidad);
		} else if (choquePorArriba(elementoDeJuego, entidad)) {
			this.realizarRespuestaAChoquePorArriba(elementoDeJuego, entidad);
		} else if (choquePorAbajo(elementoDeJuego, entidad)){
			this.realizarRespuestaAChoquePorAbajo(elementoDeJuego, entidad);
		}
	}
	
	private void realizarRespuestaAChoquePorDerecha(ElementoDeJuego elementoDeJuego, Entidad entidad) {
    	entidad.retrotraerMovimientoHorizontal(elementoDeJuego.obtenerHitbox().x - entidad.obtenerAncho());
	}
	
	private void realizarRespuestaAChoquePorIzquierda(ElementoDeJuego elementoDeJuego, Entidad entidad) {
    	entidad.retrotraerMovimientoHorizontal(elementoDeJuego.obtenerHitbox().x + elementoDeJuego.obtenerAncho());
	}
		
	private void realizarRespuestaAChoquePorArriba(ElementoDeJuego elementoDeJuego, Entidad entidad) {
		entidad.establecerColisionAbajo(true);
		entidad.retrotraerMovimientoVertical(elementoDeJuego.obtenerHitbox().y - entidad.obtenerAlto());
		this.eleminarVelocidadVertical(entidad);
	}
	
	private void realizarRespuestaAChoquePorAbajo(ElementoDeJuego elementoDeJuego, Entidad entidad) {
		entidad.establecerColisionArriba(true);
		entidad.retrotraerMovimientoVertical(elementoDeJuego.obtenerHitbox().y + elementoDeJuego.obtenerAlto());
		this.eleminarVelocidadVertical(entidad);
	}
	

	private void eleminarVelocidadVertical(Entidad entidad) {
		int nuevaVelocidadY  = 0;
		Point nuevaVelocidad = new Point(entidad.obtenerVelocidadDireccional().x, nuevaVelocidadY);
		entidad.establecerVelocidadDireccional(nuevaVelocidad);
	}

	public void verificarColisionEntreEntidades(Entidad entidad1, Entidad entidad2) {
		boolean entidad2ChocaAEntidad1PorDerecha = choquePorDerecha(entidad1, entidad2);
		boolean entidad2ChocaAEntidad1PorIzquierda = choquePorIzquierda(entidad1, entidad2);
		if (entidad2ChocaAEntidad1PorDerecha) {
			entidad2.retrotraerMovimientoHorizontal(entidad1.obtenerHitbox().x - entidad2.obtenerAncho());
			entidad1.retrotraerMovimientoHorizontal(entidad2.obtenerHitbox().x + entidad2.obtenerAncho());
		} else if (entidad2ChocaAEntidad1PorIzquierda) {
			entidad2.retrotraerMovimientoHorizontal(entidad1.obtenerHitbox().x + entidad2.obtenerAncho());
			entidad1.retrotraerMovimientoHorizontal(entidad2.obtenerHitbox().x - entidad1.obtenerAncho());
		} else if (choquePorArriba(entidad1, entidad2)) {
			entidad2.establecerColisionAbajo(true);
			entidad2.retrotraerMovimientoVertical(entidad1.obtenerHitbox().y - entidad2.obtenerAlto());
		} else if (choquePorAbajo(entidad1, entidad2)){
			entidad2.establecerColisionArriba(true);
			entidad2.retrotraerMovimientoVertical(entidad1.obtenerHitbox().y + entidad1.obtenerAlto()); 
		}
	}
	
	public boolean verificarImpactoLateralEntreMarioYEnemigo(Entidad mario, Entidad enemigo) {
		boolean enemigoImpactaPorDerecha =  enemigo.obtenerHitbox().x < mario.obtenerHitbox().x + mario.obtenerHitbox().width;
		boolean enemigoImpactaPorIzquierda = enemigo.obtenerHitbox().x + enemigo.obtenerHitbox().width > mario.obtenerHitbox().x;
		boolean marioNoGolpeoPorArriba = !choquePorArriba(enemigo, mario);
		return ((enemigoImpactaPorIzquierda) || (enemigoImpactaPorDerecha)) && marioNoGolpeoPorArriba;
	}
	
	public boolean choquePorDerecha(ElementoDeJuego elementoDeJuego, Entidad entidad) {
		boolean hitboxSuperaPosicionDeElemento = entidad.obtenerHitbox().x + entidad.obtenerHitbox().width > elementoDeJuego.obtenerHitbox().x;
		boolean posicionTodaviaNoActualizada = !(entidad.obtenerPosicionLogica().x + entidad.obtenerAncho() > elementoDeJuego.obtenerPosicionLogica().x);
		return hitboxSuperaPosicionDeElemento && posicionTodaviaNoActualizada;
	}
	
	public boolean choquePorIzquierda(ElementoDeJuego elementoDeJuego, Entidad entidad) {
		boolean hitboxSuperaPosicionDeElemento = entidad.obtenerHitbox().x < elementoDeJuego.obtenerHitbox().x + elementoDeJuego.obtenerAncho();
		boolean posicionTodaviaNoActualizada = entidad.obtenerPosicionLogica().x >= elementoDeJuego.obtenerPosicionLogica().x + elementoDeJuego.obtenerAncho();
		return hitboxSuperaPosicionDeElemento && posicionTodaviaNoActualizada;
	}
	
	public boolean choquePorArriba(ElementoDeJuego elementoDeJuego, Entidad entidad) {
		boolean hitboxSuperaPosicionDeElemento = entidad.obtenerHitbox().y + entidad.obtenerAlto() > elementoDeJuego.obtenerHitbox().y;
		boolean posicionTodaviaNoActualizada = entidad.obtenerPosicionLogica().y + entidad.obtenerAlto() <= elementoDeJuego.obtenerPosicionLogica().y;
		boolean cayendo = entidad.obtenerVelocidadDireccional().y > 0;
		return hitboxSuperaPosicionDeElemento && posicionTodaviaNoActualizada && cayendo;
	}
	
	public boolean choquePorAbajo(ElementoDeJuego elementoDeJuego, Entidad entidad) {
		boolean hitboxSuperaPosicionDeElemento = entidad.obtenerHitbox().y < elementoDeJuego.obtenerHitbox().y + elementoDeJuego.obtenerAlto();
		boolean posicionTodaviaNoActualizada = entidad.obtenerPosicionLogica().y >= elementoDeJuego.obtenerPosicionLogica().y + elementoDeJuego.obtenerAlto();
		boolean subiendo = entidad.obtenerVelocidadDireccional().y < 0;
		return hitboxSuperaPosicionDeElemento && posicionTodaviaNoActualizada && subiendo;
	}
	
}
