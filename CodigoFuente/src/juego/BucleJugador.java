package juego;

public class BucleJugador implements Runnable {
	
	private static final int MILISEGUNDOS_POR_SEGUNDO = 1000;
	
	private static final int NANOSEGUNDOS_POR_SEGUNDO = 1_000_000_000;
	
	private static final double CANTIDAD_TICKS = 60.0;
	
	private volatile boolean bucleJugadorEnEjecucion;
	
	private Partida partida;
	
	private Thread hilo;
	
	public BucleJugador(Partida partida) {
		this.partida = partida;
		this.iniciarBucleJugador();
	}
	
	private synchronized void iniciarBucleJugador() {
		this.bucleJugadorEnEjecucion = true;
		this.hilo = new Thread(this);
		this.hilo.start();
	}
	
	public synchronized void detenerBucleJugador() {
		if (!this.bucleJugadorEnEjecucion) {
			return;
		}
		this.bucleJugadorEnEjecucion = false;
        try {
            if (this.hilo !=  null && this.hilo.isAlive()) {
                this.hilo.join();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
	}

	@Override
	public void run() {
	    long ultimoTiempoCapturado = System.nanoTime();
	    
	    double cantidadTicks = CANTIDAD_TICKS;
	    
	    double nanoSegundosPorTick = NANOSEGUNDOS_POR_SEGUNDO / cantidadTicks;
	    
	    double delta = 0;
	    
	    long cronometro = System.currentTimeMillis();
	    
	    @SuppressWarnings("unused")
		int frames = 0;
	    
	    @SuppressWarnings("unused")
		int actualizaciones = 0;

	    while (this.bucleJugadorEnEjecucion) {
	        long tiempoActual = System.nanoTime();
	        
	        delta +=  (tiempoActual - ultimoTiempoCapturado);
	        
	        ultimoTiempoCapturado = tiempoActual;
	        
	        while (delta >=  nanoSegundosPorTick) {
	        	this.actualizarBucleJugador();
	            actualizaciones++;
	            delta -=  nanoSegundosPorTick;
	        }
	        
	        if (this.bucleJugadorEnEjecucion) {
	            frames++;
	        }
	        
	        if (System.currentTimeMillis() - cronometro > MILISEGUNDOS_POR_SEGUNDO) {
	            cronometro +=  MILISEGUNDOS_POR_SEGUNDO;
	            actualizaciones = 0;
	            frames = 0;
	        }
	    }
	    
	    this.detenerBucleJugador();
	}

	
	private void actualizarBucleJugador() {
		this.partida.actualizar();
	}
	
}
