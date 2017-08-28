package vista;

import vista.Imagen;
import modelo.Juego;


public class VistaImagen extends Imagen{

	public VistaImagen(Juego unJuego){
		super();
		this.jugador = unJuego.obtenerJugador();
	}
	
}
