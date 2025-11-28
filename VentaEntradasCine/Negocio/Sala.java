// Ubicacion: VentaEntradasCine/Negocio/Sala.java
package VentaEntradasCine.Negocio;
public class Sala {
    private String id;
    private String nombre;
    private int filas;
    private int columnas;
    private boolean[][] asientosOcupados;

    public Sala(String id, String nombre, int filas, int columnas) {
        this.id = id;
        this.nombre = nombre;
        this.filas = filas;
        this.columnas = columnas;
        this.asientosOcupados = new boolean[filas][columnas];
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public int getFilas() { return filas; }
    public int getColumnas() { return columnas; }
    
    public boolean estaOcupado(int fila, int columna) {
        return asientosOcupados[fila][columna];
    }
    
    public void ocuparAsiento(int fila, int columna) {
        asientosOcupados[fila][columna] = true;
    }
    
    public void liberarAsiento(int fila, int columna) {
        asientosOcupados[fila][columna] = false;
    }
    
    public int contarAsientosDisponibles() {
        int disponibles = 0;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (!asientosOcupados[i][j]) {
                    disponibles++;
                }
            }
        }
        return disponibles;
    }
}