package vista;

import java.util.ArrayList;
import modelo.ContenidoAudiovisual;
import repositorio.ContenidoRepositorio;
import java.util.Scanner;
import controlador.ContenidoControlador;
import modelo.Actor;
import modelo.Documental;
import modelo.Investigador;
import modelo.Pelicula;
import modelo.PeliculaStreaming;
import modelo.SerieDeTV;
import modelo.TransmisionEnVivo;

public class VistaConsola {

    private Scanner scanner;
    private ContenidoControlador controlador;
    private ContenidoRepositorio repositorio;
    
    //OPCIONES DEL MENU PRINCIPAL
    private static final int OPCION_AGREGAR_PELICULA = 1;
    private static final int OPCION_AGREGAR_SERIE = 2;
    private static final int OPCION_AGREGAR_DOCUMENTAL = 3;
    private static final int OPCION_AGREGAR_PELICULA_STREAMING = 4;
    private static final int OPCION_AGREGAR_TRANSMISION = 5;
    private static final int OPCION_MOSTRAR_CONTENIDOS = 6;
    private static final int OPCION_CARGAR_CSV = 7;
    private static final int OPCION_GUARDAR_CSV = 8;
    private static final int OPCION_SALIR = 9;     
    
    public VistaConsola(ContenidoControlador controlador, ContenidoRepositorio repositorio) {
        this.scanner = new Scanner(System.in);
        this.controlador = controlador;
        this.repositorio = repositorio;
    }

    //INICIA EL CICLO PRINCIPAL DEL MENU
    public void iniciar() {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");
            procesarOpcion(opcion);
        } while (opcion != OPCION_SALIR);
    }

    //MENU PARA USUARIO
    private void mostrarMenu() {
        System.out.println("==================================");
        System.out.println(" SISTEMA DE CONTENIDO AUDIOVISUAL ");
        System.out.println("==================================");
        System.out.println("1. Agregar película");
        System.out.println("2. Agregar serie de TV");
        System.out.println("3. Agregar documental");
        System.out.println("4. Agregar película streaming");
        System.out.println("5. Agregar transmisión en vivo");
        System.out.println("6. Mostrar contenidos");
        System.out.println("7. Cargar contenidos desde CSV");
        System.out.println("8. Guardar contenidos en CSV");
        System.out.println("9. Salir");
        System.out.println("==================================");
    }

    //PROCESA LA OPCION SELECCIONADA POR EL USUARIO
    private void procesarOpcion(int opcion) {
        switch (opcion) {
        case OPCION_AGREGAR_PELICULA:
            agregarPelicula();
            break;
        case OPCION_AGREGAR_SERIE:
            agregarSerie();
            break;
        case OPCION_AGREGAR_DOCUMENTAL:
            agregarDocumental();
            break;
        case OPCION_AGREGAR_PELICULA_STREAMING:
            agregarPeliculaStreaming();
            break;
        case OPCION_AGREGAR_TRANSMISION:
            agregarTransmisionEnVivo();
            break;
        case OPCION_MOSTRAR_CONTENIDOS:
            mostrarContenidos();
            break;
        case OPCION_CARGAR_CSV:
            cargarContenidosDesdeCsv();
            break;
        case OPCION_GUARDAR_CSV:
            guardarContenidosEnCsv();
            break;
        case OPCION_SALIR:
            System.out.println("Saliendo del sistema...");
            break;
        default:
            System.out.println("Opción no válida.");
        }
    }

    private void agregarPelicula() {
        System.out.println("\n--- Agregar película ---");

        String titulo = leerTexto("Título: ");
        int duracion = leerEntero("Duración en minutos: ");
        String genero = leerTexto("Género: ");
        String estudio = leerTexto("Estudio: ");

        Pelicula pelicula = new Pelicula(titulo, duracion, genero, estudio);

        String nombreActor = leerTexto("Nombre del actor: ");
        int edadActor = leerEntero("Edad del actor: ");
        String personaje = leerTexto("Personaje: ");

        pelicula.agregarActor(new Actor(nombreActor, edadActor, personaje));
        controlador.agregarContenido(pelicula);

        System.out.println("Película agregada correctamente.\n");
    }

    private void agregarSerie() {
        System.out.println("\n--- Agregar serie de TV ---");

        String titulo = leerTexto("Título: ");
        int duracion = leerEntero("Duración por episodio en minutos: ");
        String genero = leerTexto("Género: ");
        int temporadas = leerEntero("Número de temporadas: ");

        SerieDeTV serie = new SerieDeTV(titulo, duracion, genero, temporadas);

        int numeroTemporada = leerEntero("Número de temporada: ");
        int episodios = leerEntero("Número de episodios: ");
        String fechaEstreno = leerTexto("Fecha de estreno: ");

        serie.agregarTemporada(numeroTemporada, episodios, fechaEstreno);
        controlador.agregarContenido(serie);

        System.out.println("Serie agregada correctamente.\n");
    }

    private void agregarDocumental() {
        System.out.println("\n--- Agregar documental ---");

        String titulo = leerTexto("Título: ");
        int duracion = leerEntero("Duración en minutos: ");
        String genero = leerTexto("Género: ");
        String tema = leerTexto("Tema: ");

        Documental documental = new Documental(titulo, duracion, genero, tema);

        String nombreInvestigador = leerTexto("Nombre del investigador: ");
        String area = leerTexto("Área de investigación: ");
        String universidad = leerTexto("Universidad o institución: ");

        documental.agregarInvestigador(new Investigador(nombreInvestigador, area, universidad));
        controlador.agregarContenido(documental);

        System.out.println("Documental agregado correctamente.\n");
    }

    private void agregarPeliculaStreaming() {
        System.out.println("\n--- Agregar película streaming ---");

        String titulo = leerTexto("Título: ");
        int duracion = leerEntero("Duración en minutos: ");
        String genero = leerTexto("Género: ");
        String plataforma = leerTexto("Plataforma: ");
        String calidad = leerTexto("Calidad: ");
        boolean disponibleOffline = leerBooleano("¿Disponible offline? (s/n): ");

        PeliculaStreaming peliculaStreaming = new PeliculaStreaming(
                titulo,
                duracion,
                genero,
                plataforma,
                calidad,
                disponibleOffline
        );

        controlador.agregarContenido(peliculaStreaming);

        System.out.println("Película streaming agregada correctamente.\n");
    }

    private void agregarTransmisionEnVivo() {
        System.out.println("\n--- Agregar transmisión en vivo ---");

        String titulo = leerTexto("Título: ");
        int duracion = leerEntero("Duración en minutos: ");
        String genero = leerTexto("Género: ");
        String plataforma = leerTexto("Plataforma: ");
        String creador = leerTexto("Creador: ");
        int espectadores = leerEntero("Número de espectadores: ");

        TransmisionEnVivo transmision = new TransmisionEnVivo(
                titulo,
                duracion,
                genero,
                plataforma,
                creador,
                espectadores
        );

        controlador.agregarContenido(transmision);

        System.out.println("Transmisión en vivo agregada correctamente.\n");
    }

    private void mostrarContenidos() {
        System.out.println("\n--- Lista de contenidos ---");

        if (!controlador.hayContenidos()) {
            System.out.println("No existen contenidos registrados.\n");
            return;
        }

        for (var contenido : controlador.obtenerContenidos()) {
            contenido.mostrarDetalles();
        }
    }

    private String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                int valor = Integer.parseInt(scanner.nextLine());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        }
    }

    private boolean leerBooleano(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String respuesta = scanner.nextLine().trim().toLowerCase();

            if (respuesta.equals("s")) {
                return true;
            }

            if (respuesta.equals("n")) {
                return false;
            }

            System.out.println("Ingrese 's' para sí o 'n' para no.");
        }
    }
    
    private void cargarContenidosDesdeCsv() {
        ArrayList<ContenidoAudiovisual> contenidosCargados = repositorio.cargar();
        controlador.cargarContenidos(contenidosCargados);
        System.out.println("Total de contenidos cargados: " + contenidosCargados.size());
    }
    
    private void guardarContenidosEnCsv() {
        repositorio.guardar(controlador.obtenerContenidos());
    }
}