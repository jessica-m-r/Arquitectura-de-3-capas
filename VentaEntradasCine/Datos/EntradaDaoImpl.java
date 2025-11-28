// Ubicación: VentaEntradasCine/Datos/EntradaDaoImpl.java
package VentaEntradasCine.Datos;

import VentaEntradasCine.Negocio.*;
import java.util.*;

public class EntradaDaoImpl implements EntradaDao {
    private static EntradaDaoImpl instance;
    private Map<String, Entrada> entradas = new HashMap<>();

    private EntradaDaoImpl() {}

    public static EntradaDaoImpl getInstance() {
        if (instance == null) {
            instance = new EntradaDaoImpl();
        }
        return instance;
    }

    @Override
    public void agregarEntrada(Entrada entrada) {
        entradas.put(entrada.getId(), entrada);
    }

    @Override
    public Entrada obtenerEntrada(String id) {
        return entradas.get(id);
    }

    @Override
    public List<Entrada> obtenerTodasEntradas() {
        return new ArrayList<>(entradas.values());
    }
    @Override
    public void eliminarEntrada(String id) {
        entradas.remove(id);
    }
}