package controlador;

import controlador.ControladorJuego;
import modelo.ImagenLea;
import modelo.Mesa;
import vista.VentanaPrincipal;
import vista.VistaImagen;
import vista.VistaMesa;
import vista.VistaInformacion;
import vista.Ventana;
import modelo.Juego;

public class Principal {

	public static void main(String[] args) {
		
		
		ImagenLea unaImagen = new ImagenLea();
		Mesa unaMesa = new Mesa(200, 200);
		unaImagen.setMesa(unaMesa);
		Ventana ventana = new VentanaPrincipal();
		ventana.setVisible(true);
		VistaMesa vistaMesa = new VistaMesa();
		vistaMesa.setPosicionable(unaMesa);
		
		int valor;
		boolean enJuego = true;
		while (enJuego){
			Juego miJuego = new Juego();
			miJuego = miJuego.recuperarJuego("files/partida.dat");
			ControladorJuego controlador = new ControladorJuego(miJuego);
			VistaImagen vistaImagen = new VistaImagen(miJuego);
			controlador.setSuperficieDeDibujo(ventana);
			vistaImagen.setPosicionable(unaImagen);
			VistaInformacion informacion = new VistaInformacion(miJuego);
			informacion.setPosicionable(unaMesa);
			KeyboardController teclado= new KeyboardController(miJuego);
			ventana.addKeyboard(teclado);
			controlador.agregarDibujable(vistaMesa);
			controlador.agregarDibujable(vistaImagen);
			controlador.agregarDibujable(informacion);
			controlador.setIntervaloSimulacion(20);
			controlador.comenzar();
			valor = ventana.nuevaPartida();
			if (valor == 1){
				enJuego = false;
			}
		}
		ventana.dispose();
	}

}
