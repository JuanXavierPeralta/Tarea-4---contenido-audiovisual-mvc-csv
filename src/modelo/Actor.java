
// CLASE *NUEVA* ACTOR - SE RELACIONA CON *CLASE PELICULA*
package modelo;
public class Actor {
	
	//DEFINICION DE ATRIBUTOS
	private String nombre;
	private int edad;
	private String personaje;

	//GENERACION DE CONSTRUCTOR
	public Actor(String nombre, int edad, String personaje) {
        this.nombre = nombre;
        this.edad = edad;
        this.personaje = personaje;
    }
	
	//CREACION DE GETTERS & SETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getPersonaje() {
		return personaje;
	}

	public void setPersonaje(String personaje) {
		this.personaje = personaje;
	}
	
	// METODO PARA MOSTRAR INFORMACION
	public void mostrarInformacion() {
		System.out.println("Actor: " + getNombre());
		System.out.println("Edad: " + getEdad());
		System.out.println("Personaje: " + getPersonaje());
	}
}