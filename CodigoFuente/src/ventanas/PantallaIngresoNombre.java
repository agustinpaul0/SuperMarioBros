package ventanas;

import javax.swing.*;
import javax.swing.text.AbstractDocument;

import fuentes.Fuente;
import juego.ConstantesGlobales;
import juego.Partida;
import ranking.Jugador;
import ranking.LimitadorDeCaracteres;
import ranking.Ranking;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class PantallaIngresoNombre extends Pantalla {
	
    private static final long serialVersionUID = 1L;
    
    private Fuente tipoFuentes;
    
    private JLabel fondo;
    
    private Dimension tamanioPanel;
    
    private JTextField campoNombre;
    
    private JButton botonConfirmar;
    
    private ControladorVistas controlador;
    
    private String modo;

    public PantallaIngresoNombre(ControladorVistas controlador, String modo) {
    	this.tamanioPanel = new Dimension(ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
        this.modo = modo;
        this.controlador = controlador;
        tipoFuentes = new Fuente();
        setLayout(new BorderLayout());  
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(tamanioPanel);
        layeredPane.setLayout(null); 

        establecerFondo(layeredPane);
        establecerContenido(layeredPane);
        add(layeredPane, BorderLayout.CENTER); 
    }
    

    private void establecerFondo(JLayeredPane layeredPane) {
        if (this.modo.equals("Modo original")) {
            fondo = new JLabel(new ImageIcon("src/imagenes/fondos/fondoModoOriginal/fondoPantallaNombre.png"));
        } else if (this.modo.equals("Modo alternativo")) {
            	fondo = new JLabel(new ImageIcon("src/imagenes/fondos/fondoModoAlternativo/fondoPantallaNombre.png"));
        }
        fondo.setBounds(0, 0, tamanioPanel.width, tamanioPanel.height);
        layeredPane.add(fondo, Integer.valueOf(0));
    }

    private void establecerContenido(JLayeredPane layeredPane) {
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
        panelContenido.setOpaque(false);  
        
        panelContenido.setBounds((ConstantesGlobales.PANEL_ANCHO - ConstantesGlobales.PANEL_ANCHO / 2) / 2,
        	    (ConstantesGlobales.PANEL_ALTO - ConstantesGlobales.PANEL_ALTO / 4) / 2,
        	    ConstantesGlobales.PANEL_ANCHO / 2, ConstantesGlobales.PANEL_ALTO / 2);

        establecerTitulo(panelContenido);
        ajustarCampoNombre(panelContenido);
        configurarBotonConfirmar(panelContenido);
        layeredPane.add(panelContenido, Integer.valueOf(1)); 
    }

    private void establecerTitulo(JPanel panelContenido) {
        JLabel etiqueta = new JLabel("Ingresa tu nombre:");
        etiqueta.setFont(tipoFuentes.fuente(tipoFuentes.nombreFuente(), 0, ConstantesGlobales.PANEL_ANCHO / 60));
        etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiqueta.setForeground(Color.WHITE);  
        etiqueta.setPreferredSize(new Dimension(tamanioPanel.width, 50));
        panelContenido.add(etiqueta);
        panelContenido.add(Box.createRigidArea(new Dimension(10, 30))); 
    }

    private void ajustarCampoNombre(JPanel panelContenido) {
        campoNombre = new JTextField(15);
        campoNombre.setMaximumSize(new Dimension(300, 30)); 
        campoNombre.setAlignmentX(Component.CENTER_ALIGNMENT);
        campoNombre.setHorizontalAlignment(JTextField.CENTER);
        campoNombre.setFocusable(true);
        campoNombre.setBorder(null);
        campoNombre.setOpaque(false);
        campoNombre.setFont(tipoFuentes.fuente(tipoFuentes.nombreFuente(), 0, ConstantesGlobales.PANEL_ANCHO / 75));
        ((AbstractDocument) campoNombre.getDocument()).setDocumentFilter(new LimitadorDeCaracteres(4));
        panelContenido.add(campoNombre);
        panelContenido.add(Box.createRigidArea(new Dimension(0, 20))); 
    }

    @SuppressWarnings("serial")
	private void configurarBotonConfirmar(JPanel panelContenido) {
        botonConfirmar = new JButton("Confirmar");
        botonConfirmar.setAlignmentX(Component.CENTER_ALIGNMENT);
        botonConfirmar.setFont(tipoFuentes.fuente(tipoFuentes.nombreFuente(), 0, ConstantesGlobales.PANEL_ANCHO / 45));
        botonConfirmar.setFocusPainted(false);
        botonConfirmar.setContentAreaFilled(false);
        botonConfirmar.setBorderPainted(false);

        botonConfirmar.addActionListener(e -> confirmarNombre());
        botonConfirmar.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
                      .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "confirmar");
        botonConfirmar.getActionMap().put("confirmar", new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                confirmarNombre();
            }
        });

        panelContenido.add(botonConfirmar);
    }

    private void confirmarNombre() {
        String nombre = campoNombre.getText().trim();
        if (!nombre.isEmpty()) {
            if (procesarJugador(nombre)) {
                controlador.obtenerRanking().guardarEstado();
                controlador.accionarPantallaFinal();
            }
        } else {
            JOptionPane.showMessageDialog(this, 
                "Por favor, ingresa un nombre.", "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean procesarJugador(String nombre) {
    	boolean toRet = false;
        try {
            Ranking ranking = controlador.obtenerRanking();
            Partida partida = controlador.obtenerJuego().obtenerPartida();
            int puntajeActual = partida.obtenerJugable().obtenerPuntos();
            Jugador jugadorExistente = ranking.obtenerJugador(nombre);

            if (jugadorExistente == null) {
                Jugador nuevoJugador = new Jugador();
                nuevoJugador.establecerNombre(nombre);
                nuevoJugador.actualizarPuntos(puntajeActual);
                ranking.agregarJugador(nuevoJugador);
            } else 
                if (puntajeActual > jugadorExistente.obtenerPuntaje()) {
                    jugadorExistente.actualizarPuntos(puntajeActual);
            }
            toRet = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, 
                "Por favor ingresa un nombre: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
        return toRet;
    }
    
    public void solicitarFocoCampoTexto() {
    	campoNombre.requestFocusInWindow();
    }
    
    public void refrescar() {
    }
    
    public boolean esRefrescable() {
    	return false;
    }
    
}