package modelo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class Juego {

	private Jugador unJugador;
	private int highScore;
	private Nivel nivel;
	private int numeroNivel;
	private boolean juegoGanado;
	
	public Juego (){
		this.unJugador = new Jugador();
		this.nivel = new Nivel (this);
		this.juegoGanado = false;
		this.numeroNivel = 1;
		this.highScore = 0;
	}
	
	public Juego(int highScore){
		this.unJugador = new Jugador();
		this.nivel = new Nivel (this);
		this.juegoGanado = false;
		this.numeroNivel = 1;
		this.highScore = highScore;
	}
	
	public void nuevoJuego (){
		this.unJugador = new Jugador();
	}
	
	public void jugadorPierdeVida(){
		this.unJugador.perderVida();		
	}
	
	public void juegoGanado(){
		this.juegoGanado = true;
	}
	
	public boolean seGanoJuego(){
		return this.juegoGanado;
	}
	
	public void jugar() throws JuegoGanadoException, JuegoPerdidoException{
		int auxiliar=0;
		try{
			this.nivel.preguntarLetra();
			if (this.unJugador.obtenerVidas()==0){
				throw new JuegoPerdidoException();
			}			
		}catch (NivelGanadoException e){
			this.ganarUnaVida();
			auxiliar = this.numeroNivel+1;
			this.nivel = new Nivel(this);
		}
		if (auxiliar == 7){
			throw new JuegoGanadoException();
		}
		if (auxiliar > this.numeroNivel){
			this.numeroNivel = auxiliar;
		}
	}
	
	public void sumarPuntajeAlJugador(int puntaje) {
		this.unJugador.sumarScore(puntaje);
	}
	
	public int obtenerVidasJugador (){
		return (this.unJugador.obtenerVidas());
	}
	
	public int obtenerPuntajeJugador (){
		return (this.unJugador.obtenerScore());
	}

	public Jugador obtenerJugador() {
		return this.unJugador;
	}
	
	public Nivel obtenerNivel(){
		return this.nivel;
	}

	public int obtenerNumeroNivel() {
		return (this.numeroNivel);
	}
	
	public void guardarJuego(String nombreArchivo){
		try {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.newDocument();
            Element raiz = doc.createElement("Juego");
    		raiz.setAttribute("highScore",""+this.highScore);
            doc.appendChild(raiz);
            File archivo = new File(nombreArchivo);
            XMLSerializer serializer = new XMLSerializer();
            OutputFormat outFormat = new OutputFormat();
            outFormat.setVersion("1.0");
            outFormat.setIndenting(true);
            outFormat.setIndent(4);
            serializer.setOutputFormat(outFormat);
            serializer.setOutputCharStream(new FileWriter(archivo));
			serializer.serialize(doc);
		}
		catch (ParserConfigurationException e) {}
        catch (IOException e) {
        	e.printStackTrace();
        }
   	}
	
	public static Juego recuperarJuego(String nombreArchivo){
		Juego juego = null;
		File archivo = new File(nombreArchivo);
		DocumentBuilder builder;
		try {
			builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document;
			document = builder.parse(archivo);
			Element raiz = document.getDocumentElement();
			int highScore= Integer.parseInt(raiz.getAttribute("highScore"));
			juego=new Juego(highScore);
		}
		catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		catch (SAXException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return juego;
	}

	public int obtenerHighScore() {
		return this.highScore;
	}
	
	public void setHighScore(int puntaje){
		if (puntaje > this.highScore){
			this.highScore = puntaje;
		}
	}
	
	public void ganarUnaVida(){
		this.unJugador.incrementarVida();
	}
	
}
