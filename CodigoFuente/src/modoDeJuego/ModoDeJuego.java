package modoDeJuego;

import fabricas.FabricaSilueta;
import fabricas.FabricaSiluetaModoAlternativo;
import fabricas.FabricaSiluetaModoOriginal;
import fabricas.FabricaSonidos;
import fabricas.FabricaSonidosModoAlternativo;
import fabricas.FabricaSonidosModoOriginal;
import fabricas.FabricaSprites;
import fabricas.FabricaSpritesModoAlternativo;
import fabricas.FabricaSpritesModoOriginal;

public class ModoDeJuego {
	
	protected FabricaSprites fabricaSprites;
	
	protected FabricaSilueta fabricaSilueta;
	
	protected FabricaSonidos fabricaSonidos;
	
	public ModoDeJuego(String modoDeJuegoSeleccionado) {
		if (modoDeJuegoSeleccionado.equals("Modo original")) {
			this.fabricaSilueta = new FabricaSiluetaModoOriginal("src/imagenes/siluetas");
			this.fabricaSprites = new FabricaSpritesModoOriginal("src/imagenes/sprites");
			this.fabricaSonidos = new FabricaSonidosModoOriginal("src/sonido");
		} else if (modoDeJuegoSeleccionado.equals("Modo alternativo")) {
			this.fabricaSilueta = new FabricaSiluetaModoAlternativo("src/imagenes/siluetas");
			this.fabricaSprites = new FabricaSpritesModoAlternativo("src/imagenes/sprites");
			this.fabricaSonidos = new FabricaSonidosModoAlternativo("src/sonido");
		}
	}
	
	public FabricaSprites obtenerFabricaSprites() {
		return this.fabricaSprites;
	}

	public FabricaSilueta obtenerFabricaSilueta() {
		return this.fabricaSilueta;
	}

	public FabricaSonidos obtenerFabricaSonidos() {
		return this.fabricaSonidos;
	}
	
}
