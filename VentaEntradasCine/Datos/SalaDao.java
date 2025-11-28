// Ubicación: VentaEntradasCine/Datos/SalaDao.java
package VentaEntradasCine.Datos;

import VentaEntradasCine.Negocio.*;
import java.util.*;

public interface SalaDao {
    void agregarSala(Sala sala);
    Sala obtenerSala(String id);
    List<Sala> obtenerTodasSalas();
}