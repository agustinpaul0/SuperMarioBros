package ventanas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;

import fuentes.Fuente;
import juego.ConstantesGlobales;

public class PantallaFinal extends Pantalla {
    
    private static final long serialVersionUID = 893955111831369738L;

    protected JButton botonVolver;
    
    private JLabel puntajeLabel;
    
    private JLayeredPane panelCapas;
    
    protected ArregloDeBotones arregloDeBotones;
    
    protected Dimension tamanioPanel;
    
    protected ControladorVistas controlador;
    
    protected Fuente tipoFuentes;
    
    protected boolean enFoco;
    
    public PantallaFinal (ControladorVistas controlador) {
    	this.tamanioPanel = new Dimension(ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
        this.controlador = controlador;
        this.enFoco = false;
        setLayout(null);
        setPreferredSize(tamanioPanel);
        
        this.panelCapas = new JLayeredPane();
        this.panelCapas.setLayout(null);
        this.panelCapas.setBounds(0, 0, tamanioPanel.width, tamanioPanel.height);
        this.botonVolver = new JButton("Volver al menu");

        this.configurarFuente();
        this.establecerFondo();
        this.establecerMensaje();
        this.configurarBotones();
        
        add(panelCapas);
        this.configurarMapasTeclado();
    }
    
    private void configurarFuente() {
    	this.tipoFuentes = new Fuente();
    	this.botonVolver.setFont(tipoFuentes.fuente(tipoFuentes.nombreFuente(), 0, ConstantesGlobales.PANEL_ANCHO / 40));
    }
    
        
    private void establecerFondo() {
       JLabel fondo = new JLabel();
       fondo.setBackground(Color.BLACK);
       fondo.setOpaque(true);
       fondo.setBounds(0, 0, tamanioPanel.width, tamanioPanel.height);
       this.panelCapas.add(fondo, Integer.valueOf(0));
    }
    
    private void establecerMensaje() {
        JLabel titulo = new JLabel("¡Fin de la partida!");
        titulo.setFont(tipoFuentes.fuente(tipoFuentes.nombreFuente(), 0, ConstantesGlobales.PANEL_ANCHO / 30));
        titulo.setForeground(Color.WHITE);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        int posicionTituloY = tamanioPanel.height / 6;
        titulo.setBounds(0, posicionTituloY, tamanioPanel.width, 50);
        panelCapas.add(titulo, Integer.valueOf(1));
    }

    private void configurarBotones() {
        int alturaPantalla = tamanioPanel.height;
        int posicionPrimerBotonY = (2 * alturaPantalla / 3) + 50; 
        
        this.botonVolver.setBounds(
            (this.tamanioPanel.width - this.botonVolver.getPreferredSize().width) / 2, 
            posicionPrimerBotonY,
            this.botonVolver.getPreferredSize().width + 20, 
            this.botonVolver.getPreferredSize().height
        );
        
        this.botonVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                realizarAccionVolver();
            }
        });

        this.botonVolver.setBorderPainted(false);       
        this.botonVolver.setContentAreaFilled(false);    
        this.botonVolver.setFocusPainted(false);        
        this.botonVolver.setOpaque(false);               
        this.botonVolver.setForeground(Color.LIGHT_GRAY);
        

        add(botonVolver);
    }
    
    private void realizarAccionVolver() {
    	this.controlador.dePantallaFinalAPantallaInicial();
    }
    
    @SuppressWarnings("serial")
	private void configurarMapasTeclado() {
        InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke("ENTER"), "volver");
        actionMap.put("volver", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                realizarAccionVolver();
            }
        });
    }
    
    public void puntajeJugador(int puntaje) {
    	this.puntajeLabel = new JLabel("Puntaje: " + puntaje, SwingConstants.CENTER);
    	this.puntajeLabel.setFont(tipoFuentes.fuente(tipoFuentes.nombreFuente(), 0, ConstantesGlobales.PANEL_ANCHO / 30));
    	this.puntajeLabel.setForeground(Color.WHITE);
    	this.puntajeLabel.setHorizontalAlignment(SwingConstants.CENTER);
    	
    	int posicionPuntajeY = tamanioPanel.height / 3;
    	this.puntajeLabel.setBounds(0, posicionPuntajeY, tamanioPanel.width, 50);
    	this.panelCapas.add(puntajeLabel, Integer.valueOf(1)); 
    }
    
    public void refrescar() {
    }
    
    public void establecerEnFoco (boolean foco) {
    	this.enFoco = foco;
    }
   
}
