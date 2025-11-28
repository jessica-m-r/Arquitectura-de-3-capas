// Ubicacion: VentaEntradasCine/Negocio/DescuentoTercerEdad.java
package VentaEntradasCine.Negocio;
public class DescuentoTercerEdad extends EntradaDecorator {
    private EntradaDecorator entrada;

    public DescuentoTercerEdad(EntradaDecorator entrada) {
        super(entrada.calcularPrecio());
        this.entrada = entrada;
    }

    @Override
    public double calcularPrecio() {
        return entrada.calcularPrecio() * 0.7; // 30% descuento
    }

    @Override
    public String obtenerDescripcion() {
        return entrada.obtenerDescripcion() + " + Descuento Tercera Edad (30%)";
    }
}