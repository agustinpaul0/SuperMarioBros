package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import fuentes.Fuente;
import juego.ConstantesGlobales;
import sensoresDeTeclas.SensorDeTeclasMenu;

@SuppressWarnings("serial")
public class PantallaInicial extends Pantalla {
	
	private static final int CANTIDAD_BOTONES = 3;
	
	protected JLabel fondo;
	
	protected JLabel botonModo1;
	
	protected JLabel botonModo2;
	
	protected JLabel botonEnfocado;
	
	protected JLabel botonRanking;

	private ArregloDeBotones arregloDeBotones;
	
	protected Dimension tamanioPanel;
	
	protected ControladorVistas controlador;
	
	private Fuente tipoFuentes;
	
	private String modo;
	
	private boolean enFoco;
	
	public PantallaInicial(ControladorVistas controladorVistas){
		this.tamanioPanel = new Dimension(ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
		this.enFoco = true;
		this.controlador =  controladorVistas;
		this.fondo = new JLabel();
		this.botonModo1 = new JLabel("MODO ORIGINAL");
		this.botonModo2 = new JLabel("MODO ALTERNATIVO"); 
		this.botonRanking =  new JLabel("RANKING");
		this.inicializarArregloDeBotones();
		this.configurarFuente();
		this.configurarVentana();
		this.ajustarDisposicion();
		this.registrarOyenteTeclas();
	}
	
	private void inicializarArregloDeBotones() {
		this.arregloDeBotones = new ArregloDeBotones(CANTIDAD_BOTONES);
		this.arregloDeBotones.agregar(this.botonModo1);
		this.arregloDeBotones.agregar(this.botonModo2);
		this.arregloDeBotones.agregar(this.botonRanking);
	}
	
	private void configurarFuente() {
		this.tipoFuentes =  new Fuente();
		this.botonModo1.setFont(this.tipoFuentes.fuente(this.tipoFuentes.nombreFuente(), 0, ConstantesGlobales.PANEL_ANCHO / 30));
		this.botonModo2.setFont(this.tipoFuentes.fuente(this.tipoFuentes.nombreFuente(), 0, ConstantesGlobales.PANEL_ANCHO / 30));
		this.botonRanking.setFont(this.tipoFuentes.fuente(this.tipoFuentes.nombreFuente(), 0, ConstantesGlobales.PANEL_ANCHO / 30));
		this.botonModo1.setForeground(Color.WHITE);
		this.botonModo2.setForeground(Color.WHITE);
		this.botonRanking.setForeground(Color.WHITE);
		this.botonEnfocado = this.botonModo1;
		this.arregloDeBotones.siguiente();
		this.botonEnfocado.setForeground(Color.DARK_GRAY);
	}
	
	private void configurarVentana(){
		new JPanel();
		setLayout(null);
		setPreferredSize(tamanioPanel);
		setMaximumSize(tamanioPanel);
		setMinimumSize(tamanioPanel);
		setBounds(0, 0, tamanioPanel.width * 2, tamanioPanel.height);
		this.establecerFondo();
	}
	
	private void establecerFondo(){
		 ImageIcon fondoImagen = new ImageIcon("src/imagenes/fondos/fondoModoOriginal/fondoMenuPrincipal.png");
		 
		 this.fondo = new JLabel(fondoImagen);
		 this.fondo.setPreferredSize(tamanioPanel);
		 this.fondo.setMaximumSize(tamanioPanel);
		 this.fondo.setMinimumSize(tamanioPanel);
		 add(fondo);
	}
	
	
	private void ajustarDisposicion(){
		this.botonModo1.setBounds((tamanioPanel.width - botonModo1.getPreferredSize().width) / 2, (tamanioPanel.height / 2) - 30, botonModo1.getPreferredSize().width, botonModo1.getPreferredSize().height);
		this.botonModo2.setBounds((tamanioPanel.width - botonModo2.getPreferredSize().width) / 2, (tamanioPanel.height / 2) + 30, botonModo2.getPreferredSize().width, botonModo2.getPreferredSize().height);
		this.botonRanking.setBounds((tamanioPanel.width - botonRanking.getPreferredSize().width) / 2, (tamanioPanel.height / 2) + 90, botonRanking.getPreferredSize().width, botonRanking.getPreferredSize().height);
		this.fondo.add(botonModo1);
		this.fondo.add(botonModo2);
		this.fondo.add(botonRanking);
		this.fondo.setBounds(0, 0, tamanioPanel.width, tamanioPanel.height);
	}
	
	private void registrarOyenteTeclas(){
		this.botonEnfocado.setFocusable(true);
		this.setFocusable(true);
		this.requestFocusInWindow(); 
		addKeyListener(this.controlador.ObtenerSensorDeTeclasMenu());
	}
	
	
	 public void refrescar() {
		 if (this.enFoco) {
		 if (this.controlador.ObtenerSensorDeTeclasMenu().obtenerEnterPresionado() && !this.controlador.ObtenerSensorDeTeclasMenu().obtenerEnterAccionada()){
			
			 if (botonEnfocado ==  botonModo1){
				this.controlador.accionarInicioJuego("Modo original");
			 }
			 else if (botonEnfocado ==  botonModo2){
				 this.controlador.accionarInicioJuego("Modo alternativo");
			 } 
			 else if (botonEnfocado ==  botonRanking) {
				 this.controlador.mostrarPantallaRanking();
				 this.controlador.ObtenerSensorDeTeclasMenu().accionarEnter();
			 }
			 
		 }
		 
	        if (this.controlador.ObtenerSensorDeTeclasMenu().obtenerSPresionado() && !this.controlador.ObtenerSensorDeTeclasMenu().obtenerSAccionada()) {
	        	this.botonEnfocado.setForeground(Color.WHITE);
	        	this.botonEnfocado = arregloDeBotones.siguiente();
	        	this. botonEnfocado.setForeground(Color.DARK_GRAY);
	        	this.controlador.ObtenerSensorDeTeclasMenu().accionarS();
	        } else if (this.controlador.ObtenerSensorDeTeclasMenu().obtenerWPresionado()  && !this.controlador.ObtenerSensorDeTeclasMenu().obtenerWAccionada()) {
	        	this.botonEnfocado.setForeground(Color.WHITE);
	        	this.botonEnfocado = arregloDeBotones.previo();
	        	this.botonEnfocado.setForeground(Color.DARK_GRAY);
	        	this.controlador.ObtenerSensorDeTeclasMenu().accionarW();
	        }
		 }
	       
    }
	 
	
	public void establecerEnFoco(boolean condicion){
			this.enFoco =  condicion;
	}
		
	public boolean obtenerEnFoco(){
			return this.enFoco;
	}
		
	public void guardarModo(String modo) {
		this.modo = modo;
	}
	
	public String obtenerModo() {
		return modo;
	}
	
}