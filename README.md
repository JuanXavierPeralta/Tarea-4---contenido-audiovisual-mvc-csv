# Sistema de Contenido Audiovisual con MVC, CSV, Clean Code, SOLID y JUnit

## Descripción

Este proyecto corresponde a un sistema de gestión de contenidos audiovisuales desarrollado en Java. Permite registrar, mostrar, cargar y guardar información relacionada con películas, series de televisión, documentales, actores, temporadas, investigadores, películas en streaming y transmisiones en vivo.

El sistema aplica el patrón Modelo-Vista-Controlador (MVC), manejo de archivos CSV, refactorización, principios de Clean Code, principios SOLID y pruebas unitarias con JUnit 5.

## Objetivo

Implementar una versión mejorada del sistema de contenidos audiovisuales, incorporando persistencia de datos mediante archivos CSV, separación de responsabilidades mediante MVC, mejoras de mantenibilidad mediante refactorización y validación de funcionalidades principales mediante pruebas unitarias.

## Tecnologías utilizadas

- Java 21
- Eclipse IDE
- JUnit 5
- Git y GitHub
- Archivos CSV

## Estructura del proyecto

```text
ContenidoAudiovisual/
├── src/
│   ├── app/
│   │   └── Main.java
│   ├── controlador/
│   │   └── ContenidoControlador.java
│   ├── modelo/
│   │   ├── Actor.java
│   │   ├── ContenidoAudiovisual.java
│   │   ├── Documental.java
│   │   ├── Investigador.java
│   │   ├── Pelicula.java
│   │   ├── PeliculaStreaming.java
│   │   ├── SerieDeTV.java
│   │   ├── Temporada.java
│   │   └── TransmisionEnVivo.java
│   ├── repositorio/
│   │   ├── ArchivoContenidoRepositorio.java
│   │   └── ContenidoRepositorio.java
│   └── vista/
│       └── VistaConsola.java
├── test/
│   ├── controlador/
│   │   └── ContenidoControladorTest.java
│   ├── modelo/
│   │   ├── DocumentalTest.java
│   │   ├── PeliculaTest.java
│   │   └── SerieDeTVTest.java
│   └── repositorio/
│       └── ArchivoContenidoRepositorioTest.java
├── datos/
    ├── actores.csv
    ├── contenidos.csv
    ├── investigadores.csv
    └── temporadas.csv
```

## Organización del sistema

| Paquete | Función |
|---|---|
| `app` | Contiene la clase principal `Main`. |
| `modelo` | Contiene las clases del dominio audiovisual. |
| `vista` | Contiene la interfaz de usuario por consola. |
| `controlador` | Administra la lista de contenidos en memoria. |
| `repositorio` | Gestiona la lectura y escritura de archivos CSV. |
| `datos` | Contiene los archivos CSV del sistema. |
| `test` | Contiene las pruebas unitarias con JUnit. |

## Funcionalidades principales

- Agregar películas.
- Agregar series de televisión.
- Agregar documentales.
- Agregar películas en streaming.
- Agregar transmisiones en vivo.
- Mostrar contenidos registrados.
- Cargar contenidos desde archivos CSV.
- Guardar contenidos en archivos CSV.
- Asociar actores a películas.
- Asociar temporadas a series.
- Asociar investigadores a documentales.
- Ejecutar pruebas unitarias con JUnit.

## Manejo de archivos CSV

Los archivos CSV se encuentran en la carpeta `datos/`:

```text
contenidos.csv
actores.csv
temporadas.csv
investigadores.csv
```

La clase `ArchivoContenidoRepositorio` realiza la lectura y escritura de estos archivos. Primero se cargan los contenidos principales y luego se agregan sus relaciones, como actores, temporadas e investigadores.

## Refactorización y Clean Code

Se aplicaron mejoras para aumentar la legibilidad y mantenibilidad del código:

- Se redujo código duplicado mediante los métodos `crearLector()` y `crearEscritor()`.
- Se dividió la conversión de líneas CSV en métodos específicos como `crearPelicula()`, `crearSerie()` y `crearDocumental()`.
- Se reemplazaron valores numéricos directos del menú por constantes descriptivas.
- Se agregaron comentarios breves solo en partes importantes del código.

## Principios SOLID aplicados

- **SRP:** separación de responsabilidades entre modelo, vista, controlador y repositorio.
- **OCP:** posibilidad de agregar nuevos tipos de contenido mediante herencia de `ContenidoAudiovisual`.
- **LSP:** las subclases pueden tratarse como objetos de tipo `ContenidoAudiovisual`.
- **ISP:** la interfaz `ContenidoRepositorio` contiene solo las operaciones necesarias.
- **DIP:** `VistaConsola` depende de la interfaz `ContenidoRepositorio` y no de una implementación concreta.

## Pruebas unitarias

Se implementaron pruebas unitarias con JUnit 5.

| Clase de prueba | Funcionalidad evaluada |
|---|---|
| `PeliculaTest` | Agregación de actores en películas. |
| `SerieDeTVTest` | Agregación de temporadas en series. |
| `DocumentalTest` | Agregación de investigadores en documentales. |
| `ContenidoControladorTest` | Gestión de contenidos en memoria. |
| `ArchivoContenidoRepositorioTest` | Carga de datos desde archivos CSV. |

## Cómo clonar el proyecto

```bash
git clone https://github.com/USUARIO/NOMBRE-DEL-REPOSITORIO.git
```

Luego se debe abrir el proyecto en Eclipse.

## Cómo ejecutar el sistema

1. Abrir Eclipse.
2. Importar el proyecto como proyecto Java.
3. Verificar que la carpeta `datos/` esté dentro del proyecto.
4. Ejecutar la clase:

```text
src/app/Main.java
```

5. Usar el menú de consola para agregar, mostrar, cargar o guardar contenidos.

## Cómo ejecutar las pruebas

1. Verificar que JUnit 5 esté agregado al proyecto.
2. Abrir la carpeta `test/`.
3. Clic derecho sobre la carpeta `test` o sobre una clase de prueba.
4. Seleccionar:

```text
Run As → JUnit Test
```

Si las pruebas se ejecutan correctamente, Eclipse mostrará la barra verde de JUnit.

## Autor

Juan Xavier Peralta León

## Asignatura

Programación Orientada a Objetos

## Unidad

Unidad 4 - Programación Limpia
