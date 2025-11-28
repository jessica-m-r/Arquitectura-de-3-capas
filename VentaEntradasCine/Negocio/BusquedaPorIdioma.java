// Ubicacion: VentaEntradasCine/Negocio/BusquedaPorIdioma.java
package VentaEntradasCine.Negocio;
import java.util.*;

public class BusquedaPorIdioma implements EstrategiaBusqueda {
    @Override
    public List<Pelicula> buscar(List<Pelicula> peliculas, String criterio) {
        List<Pelicula> resultados = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getIdioma().equalsIgnoreCase(criterio)) {
                resultados.add(pelicula);
            }
        }
        return resultados;
    }
}