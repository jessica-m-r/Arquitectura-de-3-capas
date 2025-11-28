// Ubicación: VentaEntradasCine/Datos/SalaDaoImpl.java
package VentaEntradasCine.Datos;

import VentaEntradasCine.Negocio.*;
import java.util.*;

public class SalaDaoImpl implements SalaDao {
    private static SalaDaoImpl instance;
    private Map<String, Sala> salas = new HashMap<>();

    private SalaDaoImpl() {}

    public static SalaDaoImpl getInstance() {
        if (instance == null) {
            instance = new SalaDaoImpl();
        }
        return instance;
    }

    @Override
    public void agregarSala(Sala sala) {
        salas.put(sala.getId(), sala);
    }

    @Override
    public Sala obtenerSala(String id) {
        return salas.get(id);
    }

    @Override
    public List<Sala> obtenerTodasSalas() {
        return new ArrayList<>(salas.values());
    }
}
