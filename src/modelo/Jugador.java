package modelo;

import controlador.Posicionable;

public class Jugador implements Posicionable {

	private int score;
	private int vidas;
	
	public Jugador(){
		this.vidas = 6;
		this.score = 0;
	}
	
	public void incrementarVida(){
		if (this.vidas<=5) {
			this.vidas++;
		}
	}
	
	public int obtenerScore(){
		return this.score;
	}
	
	public int obtenerVidas(){
		return this.vidas;
	}
	
	public void perderVida(){
		this.vidas--;
	}
	
	public void sumarScore(int scoreASumar){
		this.score = this.score + scoreASumar;
	}

	public int getX() {
		return 0;
	}

	public int getY() {
		return 0;
	}
	
}
