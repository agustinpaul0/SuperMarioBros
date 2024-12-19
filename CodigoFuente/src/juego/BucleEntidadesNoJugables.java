package juego;

public class BucleEntidadesNoJugables implements Runnable {
	
	private static final int MILISEGUNDOS_POR_SEGUNDO = 1000;
	
	private static final int NANOSEGUNDOS_POR_SEGUNDO = 1_000_000_000;
	
	private static final double CANTIDAD_TICKS = 60.0;
	
	private volatile boolean bucleEntidadesNoJugablesEnEjecucion;
	
	private MasterMind masterMind;
	
	private Thread hilo;
	
	public BucleEntidadesNoJugables(MasterMind masterMind) {
		this.masterMind = masterMind;
		this.iniciarBucleEntidadesNoJugables();
	}
	
	private void iniciarBucleEntidadesNoJugables() {
		this.bucleEntidadesNoJugablesEnEjecucion = true;
		this.hilo = new Thread(this);
		this.hilo.start();
	}
	
	public synchronized void detenerBucleEntidadesNoJugables() {
		if (!this.bucleEntidadesNoJugablesEnEjecucion) {
			return;
		}
		this.bucleEntidadesNoJugablesEnEjecucion = false;
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

	    while(this.bucleEntidadesNoJugablesEnEjecucion) {
	        long tiempoActual = System.nanoTime();
	        
	        delta +=  (tiempoActual - ultimoTiempoCapturado);
	        
	        ultimoTiempoCapturado = tiempoActual;
	        
	        while (delta >=  nanoSegundosPorTick) {
	        	this.actualizarBucleEntidadesNoJugables();
	            actualizaciones++;
	            delta -=  nanoSegundosPorTick;
	        }
	        
	        if (this.bucleEntidadesNoJugablesEnEjecucion) {
	            frames++;
	        }
	        
	        if (System.currentTimeMillis() - cronometro > MILISEGUNDOS_POR_SEGUNDO) {
	            cronometro +=  MILISEGUNDOS_POR_SEGUNDO;
	            actualizaciones = 0;
	            frames = 0;
	        }
	    }
	    
	    this.detenerBucleEntidadesNoJugables();
	}

	
	private void actualizarBucleEntidadesNoJugables() {
		this.masterMind.actualizar();
	}

}
