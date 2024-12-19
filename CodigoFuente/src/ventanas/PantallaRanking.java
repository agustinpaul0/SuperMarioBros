package ventanas;

import javax.swing.*;
import fuentes.Fuente;
import juego.ConstantesGlobales;
import ranking.Jugador;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PantallaRanking extends Pantalla {

	private static final long serialVersionUID = 6769720571520373550L;
	
	private boolean enFoco;
	
	private Fuente tipoFuentes;
    
	private List<JLabel> rankingLabel;
    
	private JLabel fondo;
    
	private Dimension tamanioPanel;
    
	protected ControladorVistas controlador;
    
	public PantallaRanking(List<Jugador> topJugadores,ControladorVistas controladorVistas) {
		this.tamanioPanel = new Dimension(ConstantesGlobales.PANEL_ANCHO, ConstantesGlobales.PANEL_ALTO);
    	this.enFoco = false;
    	this.controlador = controladorVistas;
        setLayout(null);
        setPreferredSize(tamanioPanel);
        this.tipoFuentes = new Fuente();
        this.rankingLabel = new ArrayList<>();
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(null);
        layeredPane.setBounds(0, 0, tamanioPanel.width, tamanioPanel.height);
        establecerFondo(layeredPane);
        establecerTitulo(layeredPane);
        agregarJugadores(layeredPane, topJugadores);
        agregarBotonRegresar();
        add(layeredPane);
    }

    private void agregarJugadores(JLayeredPane layeredPane, List<Jugador> topJugadores) {
        JPanel jugadoresPanel = new JPanel();
        jugadoresPanel.setLayout(null);
        jugadoresPanel.setOpaque(false);
        
        int y = 0;
        int labelHeight = 60;
        int startY = 150;
        
        for (Jugador jugador : topJugadores) {
            JLabel jugadorLabel = new JLabel(jugador.obtenerNombre() + " " + jugador.obtenerPuntaje());
            jugadorLabel.setBounds(0, y, tamanioPanel.width, labelHeight);
            jugadorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            rankingLabel.add(jugadorLabel);
            jugadoresPanel.add(jugadorLabel);
            y +=  labelHeight;
        }
        jugadoresPanel.setBounds(0, startY, tamanioPanel.width, tamanioPanel.height - startY);
        layeredPane.add(jugadoresPanel, Integer.valueOf(1));
        configurarFuenteJugadores();
    }
    
    private void agregarBotonRegresar(){
    	JLabel botonRegresar =  new JLabel("Regresar");
    	Font font = tipoFuentes.fuente(tipoFuentes.nombreFuente(), 0, ConstantesGlobales.PANEL_ANCHO / 30);
    	botonRegresar.setFont(font);
    	botonRegresar.setBounds((tamanioPanel.width - botonRegresar.getPreferredSize().width) / 2, ConstantesGlobales.PANEL_ALTO - (ConstantesGlobales.PANEL_ALTO / 3), botonRegresar.getPreferredSize().width, botonRegresar.getPreferredSize().height);
    	add(botonRegresar);
    }

    private void configurarFuenteJugadores() {
        Font font = tipoFuentes.fuente(tipoFuentes.nombreFuente(), 0, ConstantesGlobales.PANEL_ANCHO / 30);
        for (JLabel top : rankingLabel) {
            top.setFont(font);
            top.setForeground(Color.WHITE);
        }
    }

    private void establecerFondo(JLayeredPane layeredPane) {
        fondo = new JLabel(new ImageIcon("src/imagenes/fondos/fondoModoOriginal/fondoPantallaNombre.png"));
        fondo.setBounds(0, 0, tamanioPanel.width, tamanioPanel.height);
        layeredPane.add(fondo, Integer.valueOf(0));
    }

    private void establecerTitulo(JLayeredPane layeredPane) {
        JLabel titulo = new JLabel("Ranking mejores 5 jugadores");
        titulo.setFont(tipoFuentes.fuente(tipoFuentes.nombreFuente(), 0, ConstantesGlobales.PANEL_ANCHO / 30));
        titulo.setForeground(Color.WHITE);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        
        JPanel tituloPanel = new JPanel();
        tituloPanel.setLayout(null);
        tituloPanel.setOpaque(false);
        tituloPanel.setBounds(0, 30, tamanioPanel.width, 50);
        
        titulo.setBounds(0, 0, tamanioPanel.width, 50);
        tituloPanel.add(titulo);
        
        layeredPane.add(tituloPanel, Integer.valueOf(1));
    }
    
    public void establecerEnFoco(boolean condicion){
    	this.enFoco = condicion;
    }
    
    public boolean obtenerEnFoco(){
    	return this.enFoco;
    }
    
    public void refrescar(){
    	if (this.controlador.ObtenerSensorDeTeclasMenu().obtenerEnterPresionado() && !this.controlador.ObtenerSensorDeTeclasMenu().obtenerEnterAccionada()){
    		this.controlador.ObtenerSensorDeTeclasMenu().accionarEnter();
    		controlador.dePantallaRankingAPantallaInicial();
    	}
    }
    
}