package repositorio;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Actor;
import modelo.ContenidoAudiovisual;
import modelo.Documental;
import modelo.Investigador;
import modelo.Pelicula;
import modelo.PeliculaStreaming;
import modelo.SerieDeTV;
import modelo.Temporada;
import modelo.TransmisionEnVivo;


public class ArchivoContenidoRepositorio implements ContenidoRepositorio {
	
	//RUTA BASE DE LOS ARCHIVOS CSV
	private static final String RUTA_BASE = "datos/";
    private static final String ARCHIVO_CONTENIDOS = RUTA_BASE + "contenidos.csv";
    private static final String ARCHIVO_ACTORES = RUTA_BASE + "actores.csv";
    private static final String ARCHIVO_TEMPORADAS = RUTA_BASE + "temporadas.csv";
    private static final String ARCHIVO_INVESTIGADORES = RUTA_BASE + "investigadores.csv";

    //CARGA CONTENIDOS Y RELACIONES DESDE LOS ARCHIVOS CSV
    @Override
    public ArrayList<ContenidoAudiovisual> cargar() {
        ArrayList<ContenidoAudiovisual> contenidos = cargarContenidosPrincipales();

        cargarActores(contenidos);
        cargarTemporadas(contenidos);
        cargarInvestigadores(contenidos);
        return contenidos;
    }
    
    //GUARDA CONTENIDOS Y RELACIONES EN LOS ARCHIVOS CSV
    @Override
    public void guardar(ArrayList<ContenidoAudiovisual> contenidos) {
        guardarContenidosPrincipales(contenidos);
        guardarActores(contenidos);
        guardarTemporadas(contenidos);
        guardarInvestigadores(contenidos);
        System.out.println("Datos guardados correctamente en archivos CSV.");
    }

    private ArrayList<ContenidoAudiovisual> cargarContenidosPrincipales() {
        ArrayList<ContenidoAudiovisual> contenidos = new ArrayList<>();

        try (BufferedReader reader = crearLector(ARCHIVO_CONTENIDOS)) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = reader.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                ContenidoAudiovisual contenido = convertirLineaAContenido(linea);

                if (contenido != null) {
                    contenidos.add(contenido);
                }
            }

            System.out.println("Contenidos principales cargados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al leer contenidos.csv: " + e.getMessage());
        }

        return contenidos;
    }
    
    //CONVIERTE UNA LINEA CSV EN UN OBJETO DEL MODELO
    private ContenidoAudiovisual convertirLineaAContenido(String linea) {
        String[] datos = linea.split(",", -1);

        if (datos.length < 7) {
            return null;
        }

        String tipo = datos[0].trim();

        switch (tipo) {
            case "Pelicula":
                return crearPelicula(datos);

            case "SerieDeTV":
                return crearSerie(datos);

            case "Documental":
                return crearDocumental(datos);

            case "PeliculaStreaming":
                return crearPeliculaStreaming(datos);

            case "TransmisionEnVivo":
                return crearTransmisionEnVivo(datos);

            default:
                return null;
        }
    }
    
    private Pelicula crearPelicula(String[] datos) {
        String titulo = datos[1].trim();
        int duracion = Integer.parseInt(datos[2].trim());
        String genero = datos[3].trim();
        String estudio = datos[4].trim();
        return new Pelicula(titulo, duracion, genero, estudio);
    }

    private SerieDeTV crearSerie(String[] datos) {
        String titulo = datos[1].trim();
        int duracion = Integer.parseInt(datos[2].trim());
        String genero = datos[3].trim();
        int temporadas = Integer.parseInt(datos[4].trim());
        return new SerieDeTV(titulo, duracion, genero, temporadas);
    }

    private Documental crearDocumental(String[] datos) {
        String titulo = datos[1].trim();
        int duracion = Integer.parseInt(datos[2].trim());
        String genero = datos[3].trim();
        String tema = datos[4].trim();
        return new Documental(titulo, duracion, genero, tema);
    }

    private PeliculaStreaming crearPeliculaStreaming(String[] datos) {
        String titulo = datos[1].trim();
        int duracion = Integer.parseInt(datos[2].trim());
        String genero = datos[3].trim();
        String plataforma = datos[4].trim();
        String calidad = datos[5].trim();
        boolean disponibilidadOffline = Boolean.parseBoolean(datos[6].trim());
        return new PeliculaStreaming(
                titulo,
                duracion,
                genero,
                plataforma,
                calidad,
                disponibilidadOffline
        );
    }

    private TransmisionEnVivo crearTransmisionEnVivo(String[] datos) {
        String titulo = datos[1].trim();
        int duracion = Integer.parseInt(datos[2].trim());
        String genero = datos[3].trim();
        String plataforma = datos[4].trim();
        String creador = datos[5].trim();
        int espectadores = Integer.parseInt(datos[6].trim());
        return new TransmisionEnVivo(
                titulo,
                duracion,
                genero,
                plataforma,
                creador,
                espectadores
        );
    }

    private void cargarActores(ArrayList<ContenidoAudiovisual> contenidos) {
    	try (BufferedReader reader = crearLector(ARCHIVO_ACTORES)) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = reader.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] datos = linea.split(",", -1);

                if (datos.length < 4) {
                    continue;
                }

                String tituloPelicula = datos[0].trim();
                String nombre = datos[1].trim();
                int edad = Integer.parseInt(datos[2].trim());
                String personaje = datos[3].trim();

                Pelicula pelicula = buscarPeliculaPorTitulo(contenidos, tituloPelicula);

                if (pelicula != null) {
                    pelicula.agregarActor(new Actor(nombre, edad, personaje));
                }
            }

            System.out.println("Actores cargados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al leer actores.csv: " + e.getMessage());
        }
    }

    private void cargarTemporadas(ArrayList<ContenidoAudiovisual> contenidos) {
    	try (BufferedReader reader = crearLector(ARCHIVO_TEMPORADAS)) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = reader.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] datos = linea.split(",", -1);

                if (datos.length < 4) {
                    continue;
                }

                String tituloSerie = datos[0].trim();
                int numero = Integer.parseInt(datos[1].trim());
                int numeroEpisodios = Integer.parseInt(datos[2].trim());
                String fechaEstreno = datos[3].trim();

                SerieDeTV serie = buscarSeriePorTitulo(contenidos, tituloSerie);

                if (serie != null) {
                    serie.agregarTemporada(numero, numeroEpisodios, fechaEstreno);
                }
            }

            System.out.println("Temporadas cargadas correctamente.");

        } catch (IOException e) {
            System.out.println("Error al leer temporadas.csv: " + e.getMessage());
        }
    }

    private void cargarInvestigadores(ArrayList<ContenidoAudiovisual> contenidos) {
    	try (BufferedReader reader = crearLector(ARCHIVO_INVESTIGADORES)) {
            String linea;
            boolean primeraLinea = true;

            while ((linea = reader.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }

                String[] datos = linea.split(",", -1);

                if (datos.length < 4) {
                    continue;
                }

                String tituloDocumental = datos[0].trim();
                String nombre = datos[1].trim();
                String area = datos[2].trim();
                String universidad = datos[3].trim();

                Documental documental = buscarDocumentalPorTitulo(contenidos, tituloDocumental);

                if (documental != null) {
                    documental.agregarInvestigador(new Investigador(nombre, area, universidad));
                }
            }

            System.out.println("Investigadores cargados correctamente.");

        } catch (IOException e) {
            System.out.println("Error al leer investigadores.csv: " + e.getMessage());
        }
    }

    private Pelicula buscarPeliculaPorTitulo(ArrayList<ContenidoAudiovisual> contenidos, String titulo) {
        for (ContenidoAudiovisual contenido : contenidos) {
            if (contenido instanceof Pelicula && contenido.getTitulo().equalsIgnoreCase(titulo)) {
                return (Pelicula) contenido;
            }
        }

        return null;
    }

    private SerieDeTV buscarSeriePorTitulo(ArrayList<ContenidoAudiovisual> contenidos, String titulo) {
        for (ContenidoAudiovisual contenido : contenidos) {
            if (contenido instanceof SerieDeTV && contenido.getTitulo().equalsIgnoreCase(titulo)) {
                return (SerieDeTV) contenido;
            }
        }

        return null;
    }

    private Documental buscarDocumentalPorTitulo(ArrayList<ContenidoAudiovisual> contenidos, String titulo) {
        for (ContenidoAudiovisual contenido : contenidos) {
            if (contenido instanceof Documental && contenido.getTitulo().equalsIgnoreCase(titulo)) {
                return (Documental) contenido;
            }
        }

        return null;
    }
    
    private void guardarContenidosPrincipales(ArrayList<ContenidoAudiovisual> contenidos) {
    	try (BufferedWriter writer = crearEscritor(ARCHIVO_CONTENIDOS)) {
            writer.write("tipo,titulo,duracion,genero,dato1,dato2,dato3");
            writer.newLine();

            for (ContenidoAudiovisual contenido : contenidos) {
                writer.write(convertirContenidoACsv(contenido));
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error al guardar contenidos.csv: " + e.getMessage());
        }
    }

    private String convertirContenidoACsv(ContenidoAudiovisual contenido) {
        if (contenido instanceof Pelicula) {
            Pelicula pelicula = (Pelicula) contenido;
            return "Pelicula,"
                    + pelicula.getTitulo() + ","
                    + pelicula.getDuracionEnMinutos() + ","
                    + pelicula.getGenero() + ","
                    + pelicula.getEstudio() + ",,";
        }

        if (contenido instanceof SerieDeTV) {
            SerieDeTV serie = (SerieDeTV) contenido;
            return "SerieDeTV,"
                    + serie.getTitulo() + ","
                    + serie.getDuracionEnMinutos() + ","
                    + serie.getGenero() + ","
                    + serie.getTemporadas() + ",,";
        }

        if (contenido instanceof Documental) {
            Documental documental = (Documental) contenido;
            return "Documental,"
                    + documental.getTitulo() + ","
                    + documental.getDuracionEnMinutos() + ","
                    + documental.getGenero() + ","
                    + documental.getTema() + ",,";
        }

        if (contenido instanceof PeliculaStreaming) {
            PeliculaStreaming peliculaStreaming = (PeliculaStreaming) contenido;
            return "PeliculaStreaming,"
                    + peliculaStreaming.getTitulo() + ","
                    + peliculaStreaming.getDuracionEnMinutos() + ","
                    + peliculaStreaming.getGenero() + ","
                    + peliculaStreaming.getPlataforma() + ","
                    + peliculaStreaming.getCalidad() + ","
                    + peliculaStreaming.isDisponibilidadOffline();
        }

        if (contenido instanceof TransmisionEnVivo) {
            TransmisionEnVivo transmision = (TransmisionEnVivo) contenido;
            return "TransmisionEnVivo,"
                    + transmision.getTitulo() + ","
                    + transmision.getDuracionEnMinutos() + ","
                    + transmision.getGenero() + ","
                    + transmision.getPlataforma() + ","
                    + transmision.getCreador() + ","
                    + transmision.getEspectadores();
        }

        return "";
    }
    
    
    private void guardarActores(ArrayList<ContenidoAudiovisual> contenidos) {
    	try (BufferedWriter writer = crearEscritor(ARCHIVO_ACTORES)) {
            writer.write("tituloPelicula,nombre,edad,personaje");
            writer.newLine();

            for (ContenidoAudiovisual contenido : contenidos) {
                if (contenido instanceof Pelicula) {
                    Pelicula pelicula = (Pelicula) contenido;

                    for (Actor actor : pelicula.getActores()) {
                        writer.write(pelicula.getTitulo() + ","
                                + actor.getNombre() + ","
                                + actor.getEdad() + ","
                                + actor.getPersonaje());
                        writer.newLine();
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error al guardar actores.csv: " + e.getMessage());
        }
    }

    private void guardarTemporadas(ArrayList<ContenidoAudiovisual> contenidos) {
    	try (BufferedWriter writer = crearEscritor(ARCHIVO_TEMPORADAS)) {
            writer.write("tituloSerie,numero,numeroEpisodios,fechaEstreno");
            writer.newLine();

            for (ContenidoAudiovisual contenido : contenidos) {
                if (contenido instanceof SerieDeTV) {
                    SerieDeTV serie = (SerieDeTV) contenido;

                    for (Temporada temporada : serie.getListaTemporadas()) {
                        writer.write(serie.getTitulo() + ","
                                + temporada.getNumero() + ","
                                + temporada.getNumeroEpisodios() + ","
                                + temporada.getFechaEstreno());
                        writer.newLine();
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error al guardar temporadas.csv: " + e.getMessage());
        }
    }

    private void guardarInvestigadores(ArrayList<ContenidoAudiovisual> contenidos) {
    	try (BufferedWriter writer = crearEscritor(ARCHIVO_INVESTIGADORES)) {
            writer.write("tituloDocumental,nombre,area,universidad");
            writer.newLine();

            for (ContenidoAudiovisual contenido : contenidos) {
                if (contenido instanceof Documental) {
                    Documental documental = (Documental) contenido;

                    for (Investigador investigador : documental.getInvestigadores()) {
                        writer.write(documental.getTitulo() + ","
                                + investigador.getNombre() + ","
                                + investigador.getArea() + ","
                                + investigador.getUniversidad());
                        writer.newLine();
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error al guardar investigadores.csv: " + e.getMessage());
        }
    }
    
    //CREA UN LECTOR PARA LOS ARCHIVOS CSV
    private BufferedReader crearLector(String rutaArchivo) throws IOException {
        return new BufferedReader(new FileReader(rutaArchivo));
    }
   //CREA UN ESCRITOR PARA LOS ARCHIVOS CSV
    private BufferedWriter crearEscritor(String rutaArchivo) throws IOException {
        return new BufferedWriter(new FileWriter(rutaArchivo));
    }
}