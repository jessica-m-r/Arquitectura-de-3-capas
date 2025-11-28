// Ubicacion: VentaEntradasCine/Negocio/CineServiceImpl.java
package VentaEntradasCine.Negocio;
import VentaEntradasCine.Datos.*;
import java.util.List;

public class CineServiceImpl implements CineService {
    private PeliculaDao peliculaDao;
    private SalaDao salaDao;
    private FuncionDao funcionDao;
    private EntradaDao entradaDao;
    private BuscadorPeliculas buscador;
    private int contadorEntradas = 1;

    public CineServiceImpl(PeliculaDao peliculaDao, SalaDao salaDao, 
                          FuncionDao funcionDao, EntradaDao entradaDao) {
        this.peliculaDao = peliculaDao;
        this.salaDao = salaDao;
        this.funcionDao = funcionDao;
        this.entradaDao = entradaDao;
        this.buscador = new BuscadorPeliculas();
    }

    // Implementación de métodos de películas
    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculaDao.agregarPelicula(pelicula);
    }

    @Override
    public Pelicula obtenerPelicula(String id) {
        return peliculaDao.obtenerPelicula(id);
    }

    @Override
    public List<Pelicula> obtenerTodasPeliculas() {
        return peliculaDao.obtenerTodasPeliculas();
    }

    @Override
    public List<Pelicula> buscarPeliculas(String tipoBusqueda, String criterio) {
        EstrategiaBusqueda estrategia;

        if (tipoBusqueda != null && tipoBusqueda.equalsIgnoreCase("titulo")) {
            estrategia = new BusquedaPorTitulo();
        } else if (tipoBusqueda != null && tipoBusqueda.equalsIgnoreCase("idioma")) {
            estrategia = new BusquedaPorIdioma();
        } else {
            estrategia = new BusquedaPorTitulo();
        }


        buscador.setEstrategia(estrategia);
        return buscador.ejecutarBusqueda(obtenerTodasPeliculas(), criterio);
    }

    @Override
    public void actualizarPelicula(Pelicula pelicula) {
        peliculaDao.actualizarPelicula(pelicula);
    }

    @Override
    public void eliminarPelicula(String id) {
        peliculaDao.eliminarPelicula(id);
    }

    // Implementación de métodos de salas
    @Override
    public void agregarSala(Sala sala) {
        salaDao.agregarSala(sala);
    }

    @Override
    public Sala obtenerSala(String id) {
        return salaDao.obtenerSala(id);
    }

    @Override
    public List<Sala> obtenerTodasSalas() {
        return salaDao.obtenerTodasSalas();
    }

    // Implementación de métodos de funciones
    @Override
    public void agregarFuncion(Funcion funcion) {
        funcionDao.agregarFuncion(funcion);
    }

    @Override
    public Funcion obtenerFuncion(String id) {
        return funcionDao.obtenerFuncion(id);
    }

    @Override
    public List<Funcion> obtenerTodasFunciones() {
        return funcionDao.obtenerTodasFunciones();
    }

    // Implementación de métodos de entradas
    @Override
    public Entrada venderEntrada(String funcionId, int fila, int columna, String tipoDescuento) {
        Funcion funcion = funcionDao.obtenerFuncion(funcionId);
        
        if (funcion == null) {
            throw new IllegalArgumentException("Función no encontrada");
        }

        Sala sala = funcion.getSala();
        
        if (sala.estaOcupado(fila, columna)) {
            throw new IllegalStateException("El asiento ya está ocupado");
        }

        // Usar patrón Decorator para calcular precio
        EntradaDecorator entrada = new EntradaBasica(funcion.getPelicula().getPrecio());
        
        if (tipoDescuento != null) {
            String tipo = tipoDescuento.toLowerCase();
            if (tipo.equals("tercera edad")) {
                entrada = new DescuentoTercerEdad(entrada);
            } else if (tipo.equals("combo")) {
                entrada = new ComboSnacks(entrada);
            }
        }

        double precioFinal = entrada.calcularPrecio();
        
        // Ocupar el asiento
        sala.ocuparAsiento(fila, columna);
        
        // Crear entrada
        String idEntrada = "ENT" + String.format("%03d", contadorEntradas++);
        Entrada nuevaEntrada = new Entrada(idEntrada, funcion, fila, columna, precioFinal);
        
        entradaDao.agregarEntrada(nuevaEntrada);
        
        return nuevaEntrada;
    }

    @Override
    public List<Entrada> obtenerTodasEntradas() {
        return entradaDao.obtenerTodasEntradas();
    }

    @Override
    public boolean verificarDisponibilidadAsiento(String funcionId, int fila, int columna) {
        Funcion funcion = funcionDao.obtenerFuncion(funcionId);
        if (funcion == null) return false;
        return !funcion.getSala().estaOcupado(fila, columna);
    }

    @Override
    public void cancelarEntrada(String id) {
        Entrada entrada = entradaDao.obtenerEntrada(id);
        if (entrada != null) {
            Sala sala = entrada.getFuncion().getSala();
            sala.liberarAsiento(entrada.getFila(), entrada.getColumna());
            entradaDao.eliminarEntrada(id);
        }
    }
}