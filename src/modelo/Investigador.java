

// CLASE *NUEVA* INVESTIGADOR - SE RELACIONA CON *CLASE DOCUMENTAL*
package modelo;
public class Investigador {
	
	//DEFINICION DE ATRIBUTOS
	private String nombre;
	private String area;
	private String universidad;

	//GENERACION DE CONSTRUCTOR
	public Investigador(String nombre, String area, String universidad) {
	     this.nombre = nombre;
	     this.area = area;
	     this.universidad = universidad;
	}

	//CREACION DE GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getUniversidad() {
		return universidad;
	}

	public void setUniversidad(String universidad) {
		this.universidad = universidad;
	}
	
	// METODO PARA MOSTRAR INFORMACION
	public void mostrarInformacion() {
		System.out.println("Investigador: " + getNombre());
		System.out.println("Área: " + getArea());
		System.out.println("Universidad: " + getUniversidad());
	}
}