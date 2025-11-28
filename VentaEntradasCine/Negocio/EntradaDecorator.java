
// Ubicacion: VentaEntradasCine/Negocio/EntradaDecorator.java
// PATRÓN ESTRUCTURAL - DECORATOR
package VentaEntradasCine.Negocio;


public abstract class EntradaDecorator {
    protected double precio;

    public EntradaDecorator(double precioBase) {
        this.precio = precioBase;
    }

    public abstract double calcularPrecio();
    public abstract String obtenerDescripcion();
}
