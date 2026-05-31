

// CLASE *NUEVA* TEMPORADA - SE RELACIONA (COMPOSICION) CON *CLASE SERIA DE TV*
package modelo;
public class Temporada {
	
	//DEFINICION DE ATRIBUTOS
	private int numero;
	private int numeroEpisodios;
	private String fechaEstreno;
	
	//GENERACION DE CONSTRUCTOR
	public Temporada(int numero, int numeroEpisodios, String fechaEstreno) {
	     this.numero = numero;	
	     this.numeroEpisodios = numeroEpisodios;
	     this.fechaEstreno = fechaEstreno;
	}

	//CREACION DE GETTERS & SETTERS
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNumeroEpisodios() {
		return numeroEpisodios;
	}

	public void setNumeroEpisodios(int numeroEpisodios) {
		this.numeroEpisodios = numeroEpisodios;
	}

	public String getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(String fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	// METODO PARA MOSTRAR INFORMACION
	public void mostrarInformacion() {
		System.out.println("Temporada: " + getNumero());
		System.out.println("Número de Episodios: " + getNumeroEpisodios());
		System.out.println("Fecha de Estreno: " + getFechaEstreno());
	}
}