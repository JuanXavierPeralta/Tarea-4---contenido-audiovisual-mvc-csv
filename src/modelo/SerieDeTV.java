

//CLASE *PRINCIPAL* SERIE DE TV
package modelo;
import java.util.ArrayList;

// Subclase SerieDeTV que extiende de ContenidoAudiovisual
public class SerieDeTV extends ContenidoAudiovisual {
	
	//DEFINICION DE ATRIBUTOS
    private int temporadas;
    //Nuevo
    private ArrayList<Temporada> listaTemporadas;

    //GENERACION DE CONSTRUCTOR
    public SerieDeTV(String titulo, int duracionEnMinutos, String genero, int temporadas) {
        super(titulo, duracionEnMinutos, genero);
        this.temporadas = temporadas;
        //Nuevo
        this.listaTemporadas = new ArrayList<>();
        
    }
    public ArrayList<Temporada> getListaTemporadas() {
        return listaTemporadas;
    }

    //CREACION DE SETTERS & GETTERS
    public int getTemporadas() {
        return temporadas;
    }
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }
    
    //METODO PARA AGREGAR TEMPORADAS
    public void agregarTemporada(int numero, int numeroEpisodios, String fechaEstreno) {
        Temporada temporada = new Temporada(numero, numeroEpisodios, fechaEstreno);
        listaTemporadas.add(temporada);
    }
    
    //MOSTRAR DE DETALLES
    @Override
    public void mostrarDetalles() {
        System.out.println("Detalles de la serie:");
        System.out.println("ID: " + getId());
        System.out.println("Título: " + getTitulo());
        System.out.println("Duración en minutos: " + getDuracionEnMinutos());
        System.out.println("Género: " + getGenero());
        System.out.println("Temporadas: " + this.temporadas);
        System.out.println();
        
        //Nuevo
        System.out.println("Detalle de temporadas:");
        for (Temporada temporada : listaTemporadas) {
            temporada.mostrarInformacion();
            System.out.println();
        }
        System.out.println();
    }
}