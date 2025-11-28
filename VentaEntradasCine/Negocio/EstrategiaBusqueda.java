// EstrategiaBusqueda.java (Interface)
// Ubicacion: VentaEntradasCine/Negocio/EstrategiaBusqueda.java
// PATRÓN DE COMPORTAMIENTO - STRATEGY
package VentaEntradasCine.Negocio;
import java.util.*;

public interface EstrategiaBusqueda {
    List<Pelicula> buscar(List<Pelicula> peliculas, String criterio);
}