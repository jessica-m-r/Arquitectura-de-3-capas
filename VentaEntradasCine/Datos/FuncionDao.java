// Ubicación: VentaEntradasCine/Datos/FuncionDao.java
package VentaEntradasCine.Datos;

import VentaEntradasCine.Negocio.*;
import java.util.List;

public interface FuncionDao {
    void agregarFuncion(Funcion funcion);
    Funcion obtenerFuncion(String id);
    List<Funcion> obtenerTodasFunciones();
}
