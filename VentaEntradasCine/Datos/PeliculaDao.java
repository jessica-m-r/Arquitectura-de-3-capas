// Ubicación: VentaEntradasCine/Datos/PeliculaDao.java

package VentaEntradasCine.Datos;
import VentaEntradasCine.Negocio.*;
import java.util.*;

public interface PeliculaDao {
    void agregarPelicula(Pelicula pelicula);
    Pelicula obtenerPelicula(String id);
    List<Pelicula> obtenerTodasPeliculas();
    void actualizarPelicula(Pelicula pelicula);
    void eliminarPelicula(String id);
}