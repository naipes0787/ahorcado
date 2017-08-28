package controlador;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import modelo.*;

	
public class KeyboardController extends KeyAdapter{
	
	private Juego miJuego;
	
	public KeyboardController(Juego juego) {
		super();
		this.miJuego = juego;
	}

	public void keyPressed(KeyEvent e){ 
		String letra;
		if (this.miJuego.obtenerNivel().tomarLetra()){
			switch (e.getKeyCode()) {
				case (KeyEvent.VK_Q): letra = new String("q");
				break;
				
				case (KeyEvent.VK_W): letra = new String("w"); 
				break;
				
				case (KeyEvent.VK_E): letra = new String("e");
				break;
				
				case (KeyEvent.VK_R): letra = new String("r"); 
				break;
				
				case (KeyEvent.VK_T): letra = new String("t"); 
				break;
				
				case (KeyEvent.VK_Y): letra = new String("y"); 
				break;
				
				case (KeyEvent.VK_U): letra = new String("u");
				break;
				
				case (KeyEvent.VK_I): letra = new String("i"); 
				break;
				
				case (KeyEvent.VK_O): letra = new String("o");
				break;
				
				case (KeyEvent.VK_P): letra = new String("p");
				break;
				
				case (KeyEvent.VK_A): letra = new String("a");
				break;
				
				case (KeyEvent.VK_S): letra = new String("s");
				break;
				
				case (KeyEvent.VK_D): letra = new String("d");
				break;
				
				case (KeyEvent.VK_F): letra = new String("f");
				break;
				
				case (KeyEvent.VK_G): letra = new String("g");
				break;
				
				case (KeyEvent.VK_H): letra = new String("h");
				break;
				
				case (KeyEvent.VK_J): letra = new String("j");
				break;
				
				case (KeyEvent.VK_K): letra = new String("k");
				break;
				
				case (KeyEvent.VK_L): letra = new String("l");
				break;
				
				case (KeyEvent.VK_Z): letra = new String("z");
				break;
				
				case (KeyEvent.VK_X): letra = new String("x"); 
				break;
				
				case (KeyEvent.VK_C): letra = new String("c");
				break;
				
				case (KeyEvent.VK_V): letra = new String("v");
				break;
				
				case (KeyEvent.VK_B): letra = new String("b");
				break;
				
				case (KeyEvent.VK_N): letra = new String("n");
				break;
				
				case (KeyEvent.VK_M): letra = new String("m");
				break;
				
				default: return;		
			}
			this.miJuego.obtenerNivel().setLetraBuscada(letra);
		}
	}
	
}
