package controlador;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import modelo.Juego;
import modelo.JuegoGanadoException;
import modelo.JuegoPerdidoException;



public class ControladorJuego {
	
	public ControladorJuego(Juego juego){
		this.objetosVivos = new ArrayList();
		this.dibujables = new ArrayList();
		this.miJuego = juego;
	}
	
	public void comenzar(){
		estaEnEjecucion = true;
		try{
			while(estaEnEjecucion){
				simular();
				dibujar();
					try{ 
						try {
							miJuego.jugar();
						} catch (JuegoPerdidoException e) {
							this.miJuego.setHighScore(miJuego.obtenerPuntajeJugador());
							dibujar();
							this.miJuego.guardarJuego("files/partida.dat");
							break;
						}
					}catch (JuegoGanadoException e){
						this.miJuego.setHighScore(miJuego.obtenerPuntajeJugador());
						this.miJuego.juegoGanado();
						dibujar();
						this.miJuego.guardarJuego("AhorcandoAGuybrush/files/partida.dat");
						break;
					}
					Thread.sleep(intervaloSimulacion);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void detener(){
		this.estaEnEjecucion = false;
	}
	
	public void agregarObjetoVivo(ObjetoVivo objetoVivo){
		objetosVivos.add(objetoVivo);
	}
	
	public void removerSimulador(ObjetoVivo objetoVivo){
		objetosVivos.remove(objetoVivo);
	}

	public void agregarDibujable(Dibujable unDibujable){
		dibujables.add(unDibujable);
	}
	
	public void removerDibujable(Dibujable unDibujable){
		dibujables.remove(unDibujable);
	}
	
	public long getIntervaloSimulacion() {
		return intervaloSimulacion;
	}

	public void setIntervaloSimulacion(long intervaloSimulacion) {
		this.intervaloSimulacion = intervaloSimulacion;
	}


	private void dibujar() {
		
		Iterator iterador = dibujables.iterator();
		while(iterador.hasNext()){
			Dibujable dib = (Dibujable)iterador.next();
			dib.dibujar(this.superficieDeDibujo);
		}		
		this.superficieDeDibujo.actualizar();
	}
	
	private void simular() {
		this.superficieDeDibujo.limpiar();
		Iterator iterador = objetosVivos.iterator();
		while(iterador.hasNext()){
			((ObjetoVivo)iterador.next()).vivir();
		}
	}

	public SuperficieDeDibujo getSuperficieDeDibujo() {
		return superficieDeDibujo;
	}

	public void setSuperficieDeDibujo(SuperficieDeDibujo superficieDeDibujo) {
		this.superficieDeDibujo = superficieDeDibujo;
	}
	
	private long intervaloSimulacion;
	private boolean estaEnEjecucion;
	private List objetosVivos;
	private List dibujables;
	private SuperficieDeDibujo superficieDeDibujo;	
	private Juego miJuego;
}
