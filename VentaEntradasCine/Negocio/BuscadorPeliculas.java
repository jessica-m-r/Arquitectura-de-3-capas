// Ubicacion: VentaEntradasCine/Negocio/BuscadorPeliculas.java
// BuscadorPeliculas.java (Contexto del Strategy)
package VentaEntradasCine.Negocio;
import java.util.*;

public class BuscadorPeliculas {
    private EstrategiaBusqueda estrategia;

    public void setEstrategia(EstrategiaBusqueda estrategia) {
        this.estrategia = estrategia;
    }

    public List<Pelicula> ejecutarBusqueda(List<Pelicula> peliculas, String criterio) {
        if (estrategia == null) {
            throw new IllegalStateException("No se ha establecido una estrategia de búsqueda");
        }
        return estrategia.buscar(peliculas, criterio);
    }
}