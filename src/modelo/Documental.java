
//CLASE *PRINCIPAL* DOCUMENTAL
package modelo;
import java.util.ArrayList;

// Subclase Documental que extiende de ContenidoAudiovisual
public class Documental extends ContenidoAudiovisual {
	
	
	//DEFINICION DE ATRIBUTOS
    private String tema;
    private ArrayList<Investigador> investigadores;

    //GENERACION DE CONSTRUCTOR
    public Documental(String titulo, int duracionEnMinutos, String genero, String tema) {
        super(titulo, duracionEnMinutos, genero);
        this.tema = tema;
      //Nuevo
        this.investigadores = new ArrayList<>();
    }

    // CREACION DE GETTERS & SETTERS
    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    
    public void agregarInvestigador(Investigador investigador) {
    	investigadores.add(investigador);
    }
    public ArrayList<Investigador> getInvestigadores() {
        return investigadores;
    }
    
    //MOSTRAR DETALLES
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles del documental:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Tema: " + this.tema);
        System.out.println();
        
      //Nuevo
        System.out.println("Investigadores:");
        for (Investigador investigador : investigadores) {
        	investigador.mostrarInformacion();
        	System.out.println();
        }
        System.out.println();
    }
    
}