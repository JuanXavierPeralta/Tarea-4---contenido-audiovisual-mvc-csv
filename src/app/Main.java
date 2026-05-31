package app;

import controlador.ContenidoControlador;
import repositorio.ArchivoContenidoRepositorio;
import repositorio.ContenidoRepositorio;
import vista.VistaConsola;

public class Main {
    
    public static void main(String[] args) {
        ContenidoControlador controlador = new ContenidoControlador();
        ContenidoRepositorio repositorio = new ArchivoContenidoRepositorio();
        VistaConsola vista = new VistaConsola(controlador, repositorio);

        vista.iniciar();
    }
}