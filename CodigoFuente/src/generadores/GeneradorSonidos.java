package generadores;

import fabricas.FabricaSonidos;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import elementos.Sonido;

import java.io.File;
import java.io.IOException;

public class GeneradorSonidos {
    
    private FabricaSonidos fabricaSonidos;
    
    private File archivoMusicaFondo;
    
    private File archivoMusicaInvulnerable;
    
    private File archivoPerderJuego;

    private File archivoPerderVida;
    
    private File archivoTocarBandera;
    
    private File archivoGanarJuego;
    
    private Clip clipMusicaFondo;

    private Clip clipPerderJuego;
    
    private Clip clipMusicaInvulnerable;
    
    private Clip clipPerderVida;
    
    private Clip clipTocarBandera;
    
    private Clip clipGanarJuego;
    
    private Clip clipSonidoActual;

    private Clip clipSonidoPrevio;
    
    private int frameCancionPrevia;
    
    public GeneradorSonidos(FabricaSonidos fabricaSonidos){
    	this.fabricaSonidos = fabricaSonidos;
    	this.establecerArchivos();
    	this.frameCancionPrevia = 0;
    }
    
    public void establecerSonidoGanarJuego() {
    	this.clipSonidoPrevio = this.clipSonidoActual;
    	this.frameCancionPrevia = this.clipSonidoActual.getFramePosition();
        this.clipSonidoActual = this.clipGanarJuego;
    }
    
    public void establecerSonidoInvulnerable() {
    	this.clipSonidoPrevio = this.clipSonidoActual;
    	this.frameCancionPrevia = this.clipSonidoActual.getFramePosition();
    	this.clipSonidoActual = this.clipMusicaInvulnerable;
    }
    
    public void establecerSonidoMusicaFondo() {
    	this.clipSonidoPrevio = this.clipSonidoActual;
    	this.frameCancionPrevia = this.clipSonidoActual.getFramePosition();
    	this.clipSonidoActual = this.clipMusicaFondo;
    }
    
    public void establecerSonidoTocarBandera() {
    	this.clipSonidoPrevio = this.clipSonidoActual;
    	this.frameCancionPrevia = this.clipSonidoActual.getFramePosition();
    	this.clipSonidoActual = this.clipTocarBandera;
    }
    
    public void establecerSonidoPerderJuego() {
    	this.clipSonidoPrevio = this.clipSonidoActual;
    	this.frameCancionPrevia = this.clipSonidoActual.getFramePosition();
    	this.clipSonidoActual = this.clipPerderJuego;
    }
    
    public void establecerSonidoPerderVida() {
    	this.clipSonidoPrevio = this.clipSonidoActual;
    	this.frameCancionPrevia = this.clipSonidoActual.getFramePosition();
    	this.clipSonidoActual = this.clipPerderVida;
    }

    protected void establecerArchivos() {
        this.archivoMusicaFondo = new File(fabricaSonidos.obtenerMusica().obtenerRutaSonido());
        this.archivoMusicaInvulnerable = new File(fabricaSonidos.obtenerModoInvulnerable().obtenerRutaSonido());
        this.archivoTocarBandera = new File(fabricaSonidos.obtenerTocarBanderaFinNivel().obtenerRutaSonido());
        this.archivoPerderJuego = new File(fabricaSonidos.obtenerPierdeJuego().obtenerRutaSonido());
        this.archivoPerderVida = new File(fabricaSonidos.obtenerPierdeVida().obtenerRutaSonido());
        this.archivoGanarJuego = new File(fabricaSonidos.obtenerRescatePrincesa().obtenerRutaSonido());
        this.establecerMusicaFondo();
        this.establecerMusicaInvulnerable();
        this.establecerTocarBandera();
        this.establecerPerderJuego();
        this.establecerPerderVida();
        this.establecerGanarJuego();
        this.clipSonidoActual = clipMusicaFondo;
    }
    
    protected void establecerMusicaFondo(){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoMusicaFondo);
            this.clipMusicaFondo = AudioSystem.getClip();
            this.clipMusicaFondo.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    protected void establecerGanarJuego(){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoGanarJuego);
            this.clipGanarJuego = AudioSystem.getClip();
            this.clipGanarJuego.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    protected void establecerPerderVida(){
    	try {
    		AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoPerderVida);
    		this.clipPerderVida = AudioSystem.getClip();
    		this.clipPerderVida.open(audioStream);
    	} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
    		e.printStackTrace();
    	}
    }

    protected void establecerPerderJuego(){
    	try {
    		AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoPerderJuego);
    		this.clipPerderJuego = AudioSystem.getClip();
    		this.clipPerderJuego.open(audioStream);
    	} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
    		e.printStackTrace();
    	}
    }
    
    protected void establecerMusicaInvulnerable(){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoMusicaInvulnerable);
            this.clipMusicaInvulnerable = AudioSystem.getClip();
            this.clipMusicaInvulnerable.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    protected void establecerTocarBandera(){
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoTocarBandera);
            this.clipTocarBandera = AudioSystem.getClip();
            this.clipTocarBandera.open(audioStream);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    public void emitirSonidoAplastarEnemigo() {
        try {
            Sonido sonido = fabricaSonidos.obtenerAplastarEnemigo();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
    }
    
    public void emitirSonidoAplastarEnemigo2() {
        try {
            Sonido sonido = fabricaSonidos.obtenerAplastarEnemigo2();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
    }
    
    public void emitirSonidoAplastarEnemigo3(){
        try {
            Sonido sonido = fabricaSonidos.obtenerAplastarEnemigo3();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
    }
    
    public void reproducirSonidoActual(){
    	this.clipSonidoActual.setFramePosition(0);
    	this.clipSonidoActual.start();
    	this.clipSonidoActual.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
    public void reproducirSonidoActualPorUnicaVez(){
    	this.clipSonidoActual.setFramePosition(0);
    	this.clipSonidoActual.start();
    }
    
    public void detenerSonidoActual(){
    	this.clipSonidoActual.stop();
    }
    
    public void reproducirSonidoPrevio() {
    	this.clipSonidoActual = this.clipSonidoPrevio;
    	this.clipSonidoActual.setFramePosition(this.frameCancionPrevia);
    	this.clipSonidoActual.start();
    	this.clipSonidoActual.loop(Clip.LOOP_CONTINUOUSLY);
    }
    
	public void choqueFireball(){
		 try {
			    Sonido sonido = fabricaSonidos.obtenerChoqueFireball();
	            
	            File archivoSonido = new File(sonido.obtenerRutaSonido());
	            
	            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
	            
	            Clip clip = AudioSystem.getClip();
	            
	            clip.open(audioStream);
	            
	            clip.start();
	            
	            clip.addLineListener(event -> {
	                if (event.getType() ==  LineEvent.Type.STOP) {
	                    clip.close();
	                }
	            });
	        } catch (UnsupportedAudioFileException e) {
	            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
	        } catch (IOException e) {
	            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
	        } catch (LineUnavailableException e) {
	            System.err.println("Línea de audio no disponible: " + e.getMessage());
	        }
	}
	
	public void matarBolaDeFuego(){
		try {
			Sonido sonido = fabricaSonidos.obtenerMatarBolaDeFuego();
			
			File archivoSonido = new File(sonido.obtenerRutaSonido());
			
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
			
			Clip clip = AudioSystem.getClip();
			
			clip.open(audioStream);
			
			clip.start();
			
			clip.addLineListener(event -> {
				if (event.getType() ==  LineEvent.Type.STOP) {
					clip.close();
				}
			});
		} catch (UnsupportedAudioFileException e) {
			System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error al leer el archivo de audio: " + e.getMessage());
		} catch (LineUnavailableException e) {
			System.err.println("Línea de audio no disponible: " + e.getMessage());
		}
	}
	
	public void disparoBolaFuego(){
		 try {
			    Sonido sonido = fabricaSonidos.obtenerDisparoBolaFuego();
	            
	            File archivoSonido = new File(sonido.obtenerRutaSonido());
	            
	            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
	            
	            Clip clip = AudioSystem.getClip();
	            
	            clip.open(audioStream);
	            
	            clip.start();
	            
	            clip.addLineListener(event -> {
	                if (event.getType() ==  LineEvent.Type.STOP) {
	                    clip.close();
	                }
	            });
	        } catch (UnsupportedAudioFileException e) {
	            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
	        } catch (IOException e) {
	            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
	        } catch (LineUnavailableException e) {
	            System.err.println("Línea de audio no disponible: " + e.getMessage());
	        }
	}
	
	public void golpeBloque(){
		try {
		    Sonido sonido = fabricaSonidos.obtenerGolpeBloque();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}
	
	public void marioPequenioDeNuevo(){
		try {
			Sonido sonido = fabricaSonidos.obtenerMarioPequenioDeNuevo();
			
			File archivoSonido = new File(sonido.obtenerRutaSonido());
			
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
			
			Clip clip = AudioSystem.getClip();
			
			clip.open(audioStream);
			
			clip.start();
			
			clip.addLineListener(event -> {
				if (event.getType() ==  LineEvent.Type.STOP) {
					clip.close();
				}
			});
		} catch (UnsupportedAudioFileException e) {
			System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error al leer el archivo de audio: " + e.getMessage());
		} catch (LineUnavailableException e) {
			System.err.println("Línea de audio no disponible: " + e.getMessage());
		}
	}
	
	public void modoRecuperacion(){
		try {
			Sonido sonido = fabricaSonidos.obtenerModoRecuperacion();
			
			File archivoSonido = new File(sonido.obtenerRutaSonido());
			
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
			
			Clip clip = AudioSystem.getClip();
			
			clip.open(audioStream);
			
			clip.start();
			
			clip.addLineListener(event -> {
				if (event.getType() ==  LineEvent.Type.STOP) {
					clip.close();
				}
			});
		} catch (UnsupportedAudioFileException e) {
			System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error al leer el archivo de audio: " + e.getMessage());
		} catch (LineUnavailableException e) {
			System.err.println("Línea de audio no disponible: " + e.getMessage());
		}
	}
	
	public void modoFuego(){
		try {
			Sonido sonido = fabricaSonidos.obtenerModoFuego();
			
			File archivoSonido = new File(sonido.obtenerRutaSonido());
			
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
			
			Clip clip = AudioSystem.getClip();
			
			clip.open(audioStream);
			
			clip.start();
			
			clip.addLineListener(event -> {
				if (event.getType() ==  LineEvent.Type.STOP) {
					clip.close();
				}
			});
		} catch (UnsupportedAudioFileException e) {
			System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Error al leer el archivo de audio: " + e.getMessage());
		} catch (LineUnavailableException e) {
			System.err.println("Línea de audio no disponible: " + e.getMessage());
		}
	}

	
	public void moneda(){
		try {
		    Sonido sonido = fabricaSonidos.obtenerSonidoMoneda();

            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}

	
	public void PowerupAgarrado(){
		try {
		    Sonido sonido = fabricaSonidos.obtenerPowerUpAgarrado();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}
	
	
	public void powerUpEmerge(){
		try {
		    Sonido sonido = fabricaSonidos.obtenerPowerUpEmerge();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}
	
	
	public void recuperaVida(){
		try {
		    Sonido sonido = fabricaSonidos.obtenerRecuperarVida();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}
	
	
	public void romperLadrillo(){
		try {
		    Sonido sonido = fabricaSonidos.obtenerRomperLadrillo();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}
	
	
	public void salto(){
		try {
		    Sonido sonido = fabricaSonidos.obtenerSalto();
            
            File archivoSonido = new File(sonido.obtenerRutaSonido());
            
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
            
            Clip clip = AudioSystem.getClip();
            
            clip.open(audioStream);
            
            clip.start();
            
            clip.addLineListener(event -> {
                if (event.getType() ==  LineEvent.Type.STOP) {
                    clip.close();
                }
            });
        } catch (UnsupportedAudioFileException e) {
            System.err.println("El formato de archivo de audio no es compatible: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de audio: " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.err.println("Línea de audio no disponible: " + e.getMessage());
        }
	}
	
}
