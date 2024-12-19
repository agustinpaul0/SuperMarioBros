package ventanas;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import elementos.Silueta;
import elementos.entidades.Jugable;
import juego.ConstantesGlobales;
import observers.ObserverGrafico;

@SuppressWarnings("serial")
public class PantallaDeJuego extends Pantalla {

    private List<ObserverGrafico> labelsElementoDeJuego;

    private Dimension tamanioPanel;
    
    private ControladorVistas controladorVistas;
    
    private ObserverGrafico labelJugable;
    
    private InterfazJuego hud;
    
    private JLabel fondo;
    
    private Point posicionOriginalLogicaJugable;
    
    private Point posicionOriginalLabelJugable;
    
    private JLayeredPane panelCapas;
   
    public PantallaDeJuego(ControladorVistas controladorVistas) {
    	this.controladorVistas = controladorVistas;
        this.configurarVentana();
        this.labelsElementoDeJuego = new CopyOnWriteArrayList<>();
    }
    
    public InterfazJuego obtenerHUD() {
    	return this.hud;
    }
    
    private void configurarVentana(){
        this.setVisible(true);
        this.setLayout(null);
        establecerTamanio();
        crearLayeredPane();
        this.add(this.panelCapas);
        this.crearHUD();
        this.revalidate();
        this.repaint();
    }
    
    private void crearLayeredPane() {
    	this.panelCapas = new JLayeredPane();
        this.panelCapas.setPreferredSize(this.tamanioPanel);
        this.panelCapas.setBounds(0, 0, ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
	}

	private void establecerTamanio() {
    	this.tamanioPanel = new Dimension(ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
        this.setPreferredSize(this.tamanioPanel);
        this.setMaximumSize(this.tamanioPanel);
        this.setMinimumSize(this.tamanioPanel);
	}

	private void crearHUD() {
    	this.hud = new InterfazJuego();
    	this.hud.setBounds(0, 0, ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
    	this.panelCapas.add(this.hud, JLayeredPane.PALETTE_LAYER);
        this.hud.setVisible(true);
        this.revalidate();
        this.repaint();
	}

    public void registrarFondo(Silueta siluetaFondo) {
    	ImageIcon fondoImagen = new ImageIcon(siluetaFondo.obtenerRutaSilueta());
        this.fondo = new JLabel(fondoImagen);
        this.establecerFondo();
    }
    
	private void establecerFondo() {
        this.fondo.setBounds(0, 0, this.fondo.getIcon().getIconWidth(), this.fondo.getIcon().getIconHeight());
        this.panelCapas.add(this.fondo, JLayeredPane.DEFAULT_LAYER); 
        this.revalidate();
        this.repaint();
    }

	public void registrarJugable(Jugable jugable) {
        this.labelJugable = controladorVistas.obtenerJugable().obtenerObserverGrafico();
        this.establecerPosicionOriginalJugable();
        this.establecerPosicionOriginalLabelJugable();
        this.panelCapas.add(this.labelJugable, JLayeredPane.MODAL_LAYER);
        this.labelJugable.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    private void establecerPosicionOriginalLabelJugable() {
		this.posicionOriginalLabelJugable = controladorVistas.obtenerJugable().obtenerPosicionGrafica();
	}

	private void establecerPosicionOriginalJugable () {
		this.posicionOriginalLogicaJugable = controladorVistas.obtenerJugable().obtenerPosicionLogica();	
	}
	
	public void agregarLabel(ObserverGrafico labelElementoDeJuego) {
		this.labelsElementoDeJuego.add(labelElementoDeJuego);
		this.panelCapas.add(labelElementoDeJuego, JLayeredPane.MODAL_LAYER);
		labelElementoDeJuego.setVisible(true);
		this.revalidate();
        this.repaint();
    }
	
    public void refrescar() {
        this.actualizarHUD();
        this.moverLabels();
    }

    
    private void moverLabels() {
    	int desplazamiento = controladorVistas.obtenerJugable().obtenerDesplazamiento();
        boolean fondoMovido = false;
        
        if (desplazamiento > 0) {
            Point posicionFondo = this.fondo.getLocation();
            int nuevaPosicionFondoX = posicionFondo.x - (desplazamiento / 2);
            int anchoFondo = this.fondo.getWidth();
            
            if (nuevaPosicionFondoX < -anchoFondo + ConstantesGlobales.PANEL_ANCHO) {
                nuevaPosicionFondoX = -anchoFondo + ConstantesGlobales.PANEL_ANCHO;
            }
            
        	if (nuevaPosicionFondoX != posicionFondo.x) {
        		this.fondo.setLocation(nuevaPosicionFondoX, posicionFondo.y);
        		fondoMovido = true; 
        	}

        	if (fondoMovido) {
    			for (ObserverGrafico observerGrafico : this.labelsElementoDeJuego) {
    				Point posicionLabel = observerGrafico.getLocation();
    				posicionLabel.x -=  desplazamiento;
    				observerGrafico.obtenerEntidadObservada().establecerPosicionGrafica(posicionLabel);
    				observerGrafico.actualizar();
    				if (observerGrafico.obtenerRemovido()) {
    					this.panelCapas.remove(observerGrafico);
    					this.labelsElementoDeJuego.remove(observerGrafico);
    				}
    			}
    			int cambioDesplazamiento = this.controladorVistas.obtenerJugable().obtenerDesplazamiento() - desplazamiento;
    			this.controladorVistas.obtenerJugable().establecerDesplazamiento(cambioDesplazamiento);
            }
        	this.revalidate();
        	this.repaint();
        }
	}

	private void actualizarHUD() {
    	this.hud.actualizarTiempo();
        this.hud.actualizarVidas(this.controladorVistas.obtenerJugable().obtenerVidas());
        this.hud.actualizarPuntaje(this.controladorVistas.obtenerJugable().obtenerPuntos());
        this.hud.actualizarNivel(this.controladorVistas.obtenerJugable().obtenerNivel().obtenerNumeroNivel());
	}

	public void eliminarNivelActual() {
    	this.removerLabelsDelPanel();
    	this.labelsElementoDeJuego = new CopyOnWriteArrayList<>();
    }
    
    public void cambiarDeNivel() {
    	this.crearHUD();
    	this.establecerJugableEnNuevoNivel();
    	this.revalidate();
    	this.repaint();
    }

	private void establecerJugableEnNuevoNivel() {
		this.controladorVistas.obtenerJugable().establecerPosicionLogica(new Point(this.posicionOriginalLogicaJugable.x, this.posicionOriginalLogicaJugable.y + (50 - this.controladorVistas.obtenerJugable().obtenerAlto())));
    	this.controladorVistas.obtenerJugable().establecerPosicionGrafica(this.controladorVistas.obtenerJugable().obtenerPosicionLogica());
    	this.controladorVistas.obtenerJugable().moverHitbox(this.controladorVistas.obtenerJugable().obtenerPosicionLogica());
    	this.labelJugable.setLocation(this.posicionOriginalLabelJugable.x, this.posicionOriginalLabelJugable.y + (50 - this.controladorVistas.obtenerJugable().obtenerAlto()));
    	this.controladorVistas.obtenerJugable().establecerDesplazamiento(0);
    	this.revalidate();
    	this.repaint();
	}

	private void removerLabelsDelPanel() {
		this.panelCapas.remove(fondo);
    	this.panelCapas.remove(hud);
		for(ObserverGrafico observerGrafico : this.labelsElementoDeJuego) {
			this.panelCapas.remove(observerGrafico);
		}
		this.revalidate();
    	this.repaint();
	}
    
}