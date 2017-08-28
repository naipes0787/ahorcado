package vista;

import java.awt.*;
import modelo.Juego;
import controlador.Dibujable;
import controlador.Posicionable;
import controlador.SuperficieDeDibujo;

public class VistaInformacion implements Dibujable{

	private Juego miJuego;
    private Posicionable posicionable;


	public VistaInformacion(Juego unNivel){
		this.miJuego = unNivel;
	}
	
	public void dibujar(SuperficieDeDibujo superfice) {
			Graphics grafico = ((Ventana)superfice).getGrafico();
			Graphics grafico2 = ((Ventana)superfice).getGrafico();
			Graphics grafico3 = ((Ventana)superfice).getGrafico();
			Graphics grafico4 = ((Ventana)superfice).getGrafico();
			grafico.setColor(Color.WHITE);
			grafico2.setColor(Color.cyan);
			grafico3.setColor(Color.RED);
			grafico4.setColor(Color.BLUE);
			grafico2.setFont(new Font("fuente",  Font.PLAIN, 16));
			grafico4.setFont(new Font("fuente",  Font.PLAIN, 16));
			grafico.setFont(new Font("fuente",  Font.BOLD, 16));
			grafico3.setFont(new Font("fuente",  Font.BOLD, 14));
			grafico2.drawString("HIGHSCORE: "+ this.miJuego.obtenerHighScore(), 248, 30);
			grafico.drawString("PUNTAJE: "+ this.miJuego.obtenerPuntajeJugador(), 248, 70);
			grafico.drawString("NIVEL: "+ this.miJuego.obtenerNumeroNivel(), 248, 93);
			grafico.drawString("Palabra: "+ this.miJuego.obtenerNivel().obtenerPalabraAdivinada(), 2, 195);
			grafico.drawString("Letras Erradas: "+ this.miJuego.obtenerNivel().obtenerLetrasErradas(), 2, 210);
			grafico3.drawString("Qué letra está en la palabra? ", 2, 240);
			if (this.miJuego.obtenerVidasJugador() == 1){
				grafico4.drawString(this.miJuego.obtenerNivel().darPista(), 2, 270);
			}
			if(this.miJuego.obtenerVidasJugador()==0) {
				grafico2.setFont(new Font("fuente",  Font.BOLD, 25));
				grafico2.drawString("Sos GIL,no adivinaste", 90, 290);
			}
			else if(this.miJuego.seGanoJuego()){
					grafico2.setFont(new Font("fuente",  Font.BOLD, 25));
					grafico2.drawString("BIEN SALAME!", 140, 290);
			}
	}

	public Posicionable getPosicionable() {
		return this.posicionable;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;
	}

}
