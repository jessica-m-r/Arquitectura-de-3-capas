// Ubicacion: VentaEntradasCine/Negocio/CineService.java
package VentaEntradasCine.Negocio;
import java.util.*;

public interface CineService {
    // Gestión de películas
    void agregarPelicula(Pelicula pelicula);
    Pelicula obtenerPelicula(String id);
    List<Pelicula> obtenerTodasPeliculas();
    List<Pelicula> buscarPeliculas(String tipoBusqueda, String criterio);
    void actualizarPelicula(Pelicula pelicula);
    void eliminarPelicula(String id);
    
    // Gestión de salas
    void agregarSala(Sala sala);
    Sala obtenerSala(String id);
    List<Sala> obtenerTodasSalas();
    
    // Gestión de funciones
    void agregarFuncion(Funcion funcion);
    Funcion obtenerFuncion(String id);
    List<Funcion> obtenerTodasFunciones();
    
    // Gestión de entradas
    Entrada venderEntrada(String funcionId, int fila, int columna, String tipoDescuento);
    List<Entrada> obtenerTodasEntradas();
    boolean verificarDisponibilidadAsiento(String funcionId, int fila, int columna);
    void cancelarEntrada(String id);
}