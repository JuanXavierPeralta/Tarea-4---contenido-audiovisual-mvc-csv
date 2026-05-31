package repositorio;

import java.util.ArrayList;
import modelo.ContenidoAudiovisual;

public interface ContenidoRepositorio {

    ArrayList<ContenidoAudiovisual> cargar();

    void guardar(ArrayList<ContenidoAudiovisual> contenidos);
}