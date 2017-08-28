package modelo;
import java.util.Vector;

public class Nivel {

	private Vector<String> palabrasAAdivinar;
	private String palabraAAdivinar;
	private Juego unJuego;
	private String palabraAdivinada;
	private String letraBuscada;
	private String letrasErradas;
	private int azar;
	
	public String obtenerLetrasErradas() {
		return letrasErradas;
	}

	private boolean tomarLetra;
	
	
	public Nivel (Juego elJuego){
		this.palabrasAAdivinar = new Vector<String>();
		this.palabrasAAdivinar.add("hipopotamo");
		this.palabrasAAdivinar.add("otorrinolaringologia");
		this.palabrasAAdivinar.add("correspondencia");
		this.palabrasAAdivinar.add("electroencefalograma");
		this.palabrasAAdivinar.add("tractor");
		this.palabrasAAdivinar.add("temporalmente");
		this.palabrasAAdivinar.add("avioneta");
		this.palabrasAAdivinar.add("reliquias");
		this.palabrasAAdivinar.add("consumidor");
		this.palabrasAAdivinar.add("murcielago");
		this.palabrasAAdivinar.add("acotado");
		this.palabrasAAdivinar.add("infinitesimal");
		this.palabrasAAdivinar.add("cornisa");
		this.palabrasAAdivinar.add("anonadada");
		this.palabrasAAdivinar.add("redoblante");	
		this.palabrasAAdivinar.add("disyuntor");		
		this.palabrasAAdivinar.add("carabelas");		
		this.palabrasAAdivinar.add("calaveras");		
		this.palabrasAAdivinar.add("racionalizar");		
		this.palabrasAAdivinar.add("seguridad");		
		this.azar=(int)(Math.random()*20);
		this.palabraAAdivinar = this.palabrasAAdivinar.get(azar);
		this.tomarLetra = false;
		this.palabraAdivinada = new String ();
		this.unJuego = elJuego;
		this.letraBuscada = new String("");
		this.letrasErradas = new String("");
		
		int caracteres = palabraAAdivinar.length();
		while(caracteres > 0){
			this.palabraAdivinada = this.palabraAdivinada + "*";
			caracteres--;
		}
	}

	public void preguntarLetra() throws NivelGanadoException {
		this.letraBuscada = "---";
		this.tomarLetra = true;
		while (this.letraBuscada.equals("---")){

		}
		this.tomarLetra = false;
		int pos = this.palabraAAdivinar.indexOf(this.letraBuscada);
		if ((pos < 0) ) {
			this.letraNoEncontrada();
		}else{
			letraEncontrada(pos);
		}
		pos = this.palabraAdivinada.indexOf("*");
		if (pos<0){
			throw new NivelGanadoException();
		}
		
	}
	
	public void letraNoEncontrada(){
		this.unJuego.jugadorPierdeVida();
		this.letrasErradas = this.letrasErradas + this.letraBuscada+ ", " ;
	}
	
	public void letraEncontrada(int pos){
		while (pos >= 0) {
			this.unJuego.sumarPuntajeAlJugador(50);
			this.palabraAdivinada = this.palabraAdivinada.substring(0, pos) + this.palabraAAdivinar.substring(pos, pos+1) + this.palabraAdivinada.substring(pos+1, this.palabraAdivinada.length());
			this.palabraAAdivinar = this.borrarLetra(this.palabraAAdivinar, pos);
			pos = this.palabraAAdivinar.indexOf(this.letraBuscada);
		}
	}
	
	public String borrarLetra(String aModificar, int posicionLetra) {
		aModificar = aModificar.substring(0, posicionLetra) + " " + aModificar.substring(posicionLetra+1, aModificar.length());
		return aModificar;
	}
	
	
	/*ESTA ERA UNA VERSION ANTERIOR PARA LA LECTURA POR TECLADO,
	 * PERO NO FUNCIONABA BIEN.
	 * 
	 * private void leerTecladoBIS() {
		try{
			char letra = (char)System.in.read();
			this.letraBuscada = String.valueOf(letra);
			this.letraBuscada = this.letraBuscada.toLowerCase();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public String leerTeclado() {
		String cad = "";
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		try {
		return teclado.readLine();
		}catch (IOException e) {
			System.out.println(" Se ha producido el siguiente error: ");
			System.out.println(e.getMessage());
		}
		return cad;
	}*/
	
	public String obtenerPalabraAdivinada(){
		return this.palabraAdivinada;
	}

	public boolean tomarLetra() {
		return this.tomarLetra;
	}
	
	public String obtenerLetraBuscada() {
		return letraBuscada;
	}

	public void setLetraBuscada(String letraBuscada) {
		this.letraBuscada = letraBuscada;
	}
	
	
	public String darPista(){
		String pista = new String ();
		if (this.palabrasAAdivinar.get(azar).equals("hipopotamo")){
			pista = "PISTA:'Animal de patas cortas y cuerpo voluminoso'";
		}else
			if (this.palabrasAAdivinar.get(azar).equals("otorrinolaringologia")){
				pista = "PISTA:'Parte de la medicina'";
			}else
				if (this.palabrasAAdivinar.get(azar).equals("correspondencia")){
					pista = "PISTA:'Conjunto de cartas'";
				}else
					if (this.palabrasAAdivinar.get(azar).equals("electroencefalograma")){
						pista = "PISTA:'Examen de ondas cerebrales'";
					}else
						if (this.palabrasAAdivinar.get(azar).equals("tractor")){
							pista = "PISTA:'Vehículo para tareas agrarias'";
						}else
							if (this.palabrasAAdivinar.get(azar).equals("temporalmente")){
								pista = "PISTA:''Por algún tiempo''";
							}else
								if (this.palabrasAAdivinar.get(azar).equals("avioneta")){
									pista = "PISTA:'Vehículo aereo,de poca potencia'";
								}else
									if (this.palabrasAAdivinar.get(azar).equals("reliquias")){
										pista = "PISTA:'Cosa muy vieja y valiosa'";
									}else
										if (this.palabrasAAdivinar.get(azar).equals("consumidor")){
											pista = "PISTA:'Tiene su midor (?)'";
										}else
											if (this.palabrasAAdivinar.get(azar).equals("murcielago")){
												pista = "PISTA:'Mamífero volador'";
											}else
												if (this.palabrasAAdivinar.get(azar).equals("acotado")){
													pista = "PISTA:'Que tiene un límite finito'";
												}else
													if (this.palabrasAAdivinar.get(azar).equals("infinitesimal")){
														pista = "PISTA:'Cantidad infinitamente pequeña'";
													}else
														if (this.palabrasAAdivinar.get(azar).equals("cornisa")){
															pista = "PISTA:'Faja horizontal al borde de un precipicio'";
														}else
															if (this.palabrasAAdivinar.get(azar).equals("anonadada")){
																pista = "PISTA:'Sorprendido'";
															}else
																if (this.palabrasAAdivinar.get(azar).equals("redoblante")){
																	pista = "PISTA:'Tambor de caja alta'";
																}else
																	if (this.palabrasAAdivinar.get(azar).equals("disyuntor")){
																		pista = "PISTA:'Interruptor automático'";
																	}else
																		if (this.palabrasAAdivinar.get(azar).equals("carabelas")){
																			pista = "PISTA:'Antigua embarcación ligera'";
																		}else
																			if (this.palabrasAAdivinar.get(azar).equals("calaveras")){
																				pista = "PISTA:'Parte del esqueleto'";
																			}else
																				if (this.palabrasAAdivinar.get(azar).equals("racionalizar")){
																					pista = "PISTA:'Reducción de algo a normas'";
																				}else
																					if (this.palabrasAAdivinar.get(azar).equals("seguridad")){
																						pista = "PISTA:'Certeza'";
																					}																					
		return pista;	
		}
}
