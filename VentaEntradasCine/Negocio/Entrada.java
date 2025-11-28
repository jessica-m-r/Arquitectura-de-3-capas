// Ubicacion: VentaEntradasCine/Negocio/Entrada.java
package VentaEntradasCine.Negocio;
public class Entrada {
    private String id;
    private Funcion funcion;
    private int fila;
    private int columna;
    private double precioFinal;

    public Entrada(String id, Funcion funcion, int fila, int columna, double precioFinal) {
        this.id = id;
        this.funcion = funcion;
        this.fila = fila;
        this.columna = columna;
        this.precioFinal = precioFinal;
    }

    public String getId() { return id; }
    public Funcion getFuncion() { return funcion; }
    public int getFila() { return fila; }
    public int getColumna() { return columna; }
    public double getPrecioFinal() { return precioFinal; }
}
