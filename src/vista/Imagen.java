package vista;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;

import controlador.Dibujable;
import controlador.Posicionable;
import controlador.SuperficieDeDibujo;

import modelo.Jugador;

/*
 * Esta clase representa una imagen JPG abstrayendo al usuario de los detalles de Java2D
 * Simplemente requiere de una referencia al nombre del archivo JPG
 */
public class Imagen implements Dibujable{
	private static final long serialVersionUID = 1L;

	public Imagen(){
		
	}

	public void dibujar(SuperficieDeDibujo superficeDeDibujo) {
		
		switch (this.jugador.obtenerVidas()){
		case 6: this.setNombreArchivoImagen("horca0.JPG");
				break;
		case 5: this.setNombreArchivoImagen("horca1.JPG");
				break;
		case 4: this.setNombreArchivoImagen("horca2.JPG");
				break;
		case 3: this.setNombreArchivoImagen("horca3.JPG");
				break;
		case 2: this.setNombreArchivoImagen("horca4.JPG");
				break;
		case 1: this.setNombreArchivoImagen("horca5.JPG");
				break;
		case 0: this.setNombreArchivoImagen("horca6.JPG");
				break;		
		}
		Graphics grafico = ((Ventana)superficeDeDibujo).getGrafico();
		grafico.drawImage(this.imagen, this.posicionable.getX(), this.posicionable.getY(), null);
	}
	    
	public String getNombreArchivoImagen() {
		return nombreArchivoImagen;
	}

	public void setNombreArchivoImagen(String nombreArchivoImagen) {
		this.nombreArchivoImagen = nombreArchivoImagen;
		InputStream in = getClass().getResourceAsStream(this.nombreArchivoImagen);
		JPEGImageDecoder decoder = JPEGCodec.createJPEGDecoder(in);
		try{
			this.imagen = decoder.decodeAsBufferedImage();
			in.close();
		}catch(Exception ex){

		}			
	}
	
	public Posicionable getPosicionable() {
		return posicionable;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;
	}
	
	private String nombreArchivoImagen;
    private BufferedImage imagen;
    private Posicionable posicionable;
    protected Jugador jugador;

}
