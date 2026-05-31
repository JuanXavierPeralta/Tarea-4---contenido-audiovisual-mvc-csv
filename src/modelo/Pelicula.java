
//CLASE *PRINCIPAL* PELICULA
package modelo;
import java.util.ArrayList;

// Subclase Pelicula que extiende de ContenidoAudiovisual
public class Pelicula extends ContenidoAudiovisual {
	
	//DEFINICION DE ATRIBUTOS
    private String estudio;
    //Nuevo
    private ArrayList<Actor> actores;
    
    // GENERACION DE CONSTRUCTOR
    public Pelicula(String titulo, int duracionEnMinutos, String genero, String estudio) {
        super(titulo, duracionEnMinutos, genero);
        this.estudio = estudio;
        //Nuevo
        this.actores = new ArrayList<>();
    }
    
    public ArrayList<Actor> getActores() {
        return actores;
    }

    // CREACION DE GETTERS & SETTERS
    public String getEstudio() {
        return estudio;
    }
    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }
    
    public void agregarActor(Actor actor) {
    	actores.add(actor);
    }
    
    //MOSTRAR DETALLES
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la película:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Estudio: " + estudio);
        
        //Nuevo
        System.out.println("Actores:");
        for (Actor actor : actores) {
        	actor.mostrarInformacion();
        	System.out.println();
        }
        System.out.println();
    }
}