package app;

import controlador.ContenidoControlador;
import vista.VistaConsola;

public class Main {
	
	public static void main(String[] args) {
        ContenidoControlador controlador = new ContenidoControlador();
        VistaConsola vista = new VistaConsola(controlador);

        vista.iniciar();
    }

}
