package modelo;

import controlador.Posicionable;

public class ImagenLea implements Posicionable {

	private Mesa mesa;

	
	public int getX() {
		return 0;
	}

	public int getY() {
		return 0;
	}
	
	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

}
