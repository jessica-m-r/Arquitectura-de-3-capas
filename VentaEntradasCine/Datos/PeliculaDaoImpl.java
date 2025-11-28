// PeliculaDaoImpl.java (Singleton)
// Ubicación: VentaEntradasCine/Datos/PeliculaDaoImpl.java

package VentaEntradasCine.Datos;

import VentaEntradasCine.Negocio.*;
import java.util.*;

public class PeliculaDaoImpl implements PeliculaDao {
    private static PeliculaDaoImpl instance;
    private Map<String, Pelicula> peliculas = new HashMap<>();

    private PeliculaDaoImpl() {}

    public static PeliculaDaoImpl getInstance() {
        if (instance == null) {
            instance = new PeliculaDaoImpl();
        }
        return instance;
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.put(pelicula.getId(), pelicula);
    }

    @Override
    public Pelicula obtenerPelicula(String id) {
        return peliculas.get(id);
    }

    @Override
    public List<Pelicula> obtenerTodasPeliculas() {
        return new ArrayList<>(peliculas.values());
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        peliculas.put(pelicula.getId(), pelicula);
    }

    @Override
    public void eliminarPelicula(String id) {
        peliculas.remove(id);
    }
}