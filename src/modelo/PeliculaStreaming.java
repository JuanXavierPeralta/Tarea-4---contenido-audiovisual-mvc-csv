

// CLASE *NUEVA* PELICULASTREAMING - HEREDA DE *CLASE CONTENIDOAUDIOVISUAL*
package modelo;
public class PeliculaStreaming extends ContenidoAudiovisual {

	//DEFINICION DE ATRIBUTOS
	private String plataforma;
	private String calidad;
	private boolean disponibilidadOffline;
	
	//GENERACION DE CONSTRUCTOR
	public PeliculaStreaming (String titulo, int duracionEnMinutos, String genero, String plataforma, String calidad, boolean disponibilidadOffline ) {
		super(titulo, duracionEnMinutos, genero);
	this.plataforma = plataforma;
	this.calidad = calidad;
	this.disponibilidadOffline = disponibilidadOffline;
	}

	//CREACION DE GETTERS & SETTERS
	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public String getCalidad() {
		return calidad;
	}

	public void setCalidad(String calidad) {
		this.calidad = calidad;
	}

	public boolean isDisponibilidadOffline() {
		return disponibilidadOffline;
	}

	public void setDisponibilidadOffline(boolean disponibilidadOffline) {
		this.disponibilidadOffline = disponibilidadOffline;
	}
	
	// MOSTRAR DETALLES
	@Override
	public void mostrarDetalles() {
	    System.out.println("Detalles de la película en streaming:");
	    System.out.println("ID: " + getId());
	    System.out.println("Título: " + getTitulo());
	    System.out.println("Duración en minutos: " + getDuracionEnMinutos());
	    System.out.println("Género: " + getGenero());
	    System.out.println("Plataforma: " + getPlataforma());
	    System.out.println("Calidad: " + getCalidad());
	    System.out.println("Disponibilidad Offline: " + (isDisponibilidadOffline() ? "Sí" : "No"));
	    System.out.println();   
	}
}