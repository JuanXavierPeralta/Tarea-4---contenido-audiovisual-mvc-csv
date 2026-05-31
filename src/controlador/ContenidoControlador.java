package controlador;

import java.util.ArrayList;
import modelo.ContenidoAudiovisual;

public class ContenidoControlador {
	
	private ArrayList<ContenidoAudiovisual> contenidos;
	
	public ContenidoControlador() {
		this.contenidos = new ArrayList<>();
	}
	
	public void agregarContenido(ContenidoAudiovisual contenido) {
        contenidos.add(contenido);
    }

    public ArrayList<ContenidoAudiovisual> obtenerContenidos() {
        return contenidos;
    }

    public boolean hayContenidos() {
        return !contenidos.isEmpty();
    }
    
    public void cargarContenidos(ArrayList<ContenidoAudiovisual> nuevosContenidos) {
        contenidos.clear();
        contenidos.addAll(nuevosContenidos);
    }

}
