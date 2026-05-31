

// CLASE *NUEVA* TransmisionEnVivo - HEREDA DE *CLASE CONTENIDOAUDIOVISUAL*
package modelo;
public class TransmisionEnVivo extends ContenidoAudiovisual {
	
	//DEFINICION DE ATRIBUTOS
	private String plataforma;
	private String creador;
	private int espectadores;
	
	//GENERACION DE CONSTRUCTOR
	public TransmisionEnVivo (String titulo, int duracionEnMinutos, String genero, String plataforma, String creador, int espectadores) {
		super(titulo, duracionEnMinutos, genero);
	this.plataforma = plataforma;
	this.creador = creador;
	this.espectadores = espectadores;
	}

	//CREACION DE GETTERS & SETTERS
	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	public int getEspectadores() {
		return espectadores;
	}

	public void setEspectadores(int espectadores) {
		this.espectadores = espectadores;
	}
	
		// MOSTRAR DETALLES
		@Override
		public void mostrarDetalles() {
		    System.out.println("Detalles de la transmisión en vivo:");
		    System.out.println("ID: " + getId());
		    System.out.println("Título: " + getTitulo());
		    System.out.println("Duración en minutos: " + getDuracionEnMinutos());
		    System.out.println("Género: " + getGenero());
		    System.out.println("Plataforma: " + getPlataforma());
		    System.out.println("Creador: " + getCreador());
		    System.out.println("Espectadores: " + getEspectadores());
		    System.out.println();
		}
}