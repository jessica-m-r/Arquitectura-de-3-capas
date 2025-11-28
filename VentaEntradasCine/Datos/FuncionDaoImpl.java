// Ubicación: VentaEntradasCine/Datos/FuncionDaoImpl.java
package VentaEntradasCine.Datos;

import VentaEntradasCine.Negocio.*;
import java.util.*;

public class FuncionDaoImpl implements FuncionDao {
    private static FuncionDaoImpl instance;
    private Map<String, Funcion> funciones = new HashMap<>();

    private FuncionDaoImpl() {}

    public static FuncionDaoImpl getInstance() {
        if (instance == null) {
            instance = new FuncionDaoImpl();
        }
        return instance;
    }

    @Override
    public void agregarFuncion(Funcion funcion) {
        funciones.put(funcion.getId(), funcion);
    }

    @Override
    public Funcion obtenerFuncion(String id) {
        return funciones.get(id);
    }

    @Override
    public List<Funcion> obtenerTodasFunciones() {
        return new ArrayList<>(funciones.values());
    }
}
