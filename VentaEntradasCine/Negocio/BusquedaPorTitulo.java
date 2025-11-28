// Ubicacion: VentaEntradasCine/Negocio/BusquedaPorTitulo.java
package VentaEntradasCine.Negocio;
import java.util.*;

public class BusquedaPorTitulo implements EstrategiaBusqueda {
    @Override
    public List<Pelicula> buscar(List<Pelicula> peliculas, String criterio) {
        List<Pelicula> resultados = new ArrayList<>();
        for (Pelicula pelicula : peliculas) {
            if (pelicula.getTitulo().toLowerCase().contains(criterio.toLowerCase())) {
                resultados.add(pelicula);
            }
        }
        return resultados;
    }
}