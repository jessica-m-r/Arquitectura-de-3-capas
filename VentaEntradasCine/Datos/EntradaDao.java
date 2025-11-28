// Ubicacion: VentaEntradasCine/Datos/EntradaDao.java
package VentaEntradasCine.Datos;
import VentaEntradasCine.Negocio.Entrada;
import java.util.List;

public interface EntradaDao {
    void agregarEntrada(Entrada entrada);
    Entrada obtenerEntrada(String id);
    List<Entrada> obtenerTodasEntradas();
    void eliminarEntrada(String id);
}