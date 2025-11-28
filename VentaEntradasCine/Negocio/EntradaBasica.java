// Ubicacion: VentaEntradasCine/Negocio/EntradaBasica.java
package VentaEntradasCine.Negocio;
public class EntradaBasica extends EntradaDecorator {
    public EntradaBasica(double precioBase) {
        super(precioBase);
    }

    @Override
    public double calcularPrecio() {
        return precio;
    }

    @Override
    public String obtenerDescripcion() {
        return "Entrada básica";
    }
}