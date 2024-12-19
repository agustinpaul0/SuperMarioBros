package ranking;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Ranking implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private List<Jugador> topJugadores;
	
	public Ranking () {
		this.topJugadores = new ArrayList<>();
	}
	
	public List<Jugador> obtenerTopRanking() {
		Collections.sort(topJugadores, Collections.reverseOrder());
		List<Jugador> top5 = new ArrayList<>();
		Iterator<Jugador> iterador = topJugadores.iterator();
		int i = 0;
		while (iterador.hasNext() && i < 5) {
			top5.add(iterador.next());
			i++;
		}
		return top5;
	}
	
	public Jugador obtenerJugador(String nombre) {
		Jugador jugador = null;
		for (Jugador jug : topJugadores) {
			if (jug.obtenerNombre().equals(nombre)) {
				jugador = jug;
			}
		}
		return jugador;
	}
	
	public void agregarJugador(Jugador jugador) {
        Collections.sort(topJugadores, Collections.reverseOrder());
        if (topJugadores.size() < 5) {
            topJugadores.add(jugador);
            Collections.sort(topJugadores, Collections.reverseOrder());
        } else {
            Jugador menorPuntaje = topJugadores.get(topJugadores.size() - 1);
            if (jugador.obtenerPuntaje() > menorPuntaje.obtenerPuntaje()) {
                topJugadores.remove(menorPuntaje);
                topJugadores.add(jugador);
                Collections.sort(topJugadores, Collections.reverseOrder());
            }
        }
    }
	
    public void guardarEstado() {
		try {
			FileOutputStream  fileOutputStream = new FileOutputStream("./src/puntos");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(this);
			objectOutputStream.flush();
			objectOutputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		  catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    public void reiniciarRanking() {
    	topJugadores.clear();
    	guardarEstado();
    }
    
    public boolean esTop(int puntaje) {
        boolean esTop = false;
        List<Jugador> ranking = obtenerTopRanking();
        if (ranking.size() < 5) {
            esTop  = true;
        }
        else {
	        int quintoPuntaje = ranking.get(4).obtenerPuntaje();
	        esTop = puntaje > quintoPuntaje;
        }
    	return esTop;
    }

}
