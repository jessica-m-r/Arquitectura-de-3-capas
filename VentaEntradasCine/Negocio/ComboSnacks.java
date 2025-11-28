// Ubicacion: VentaEntradasCine/Negocio/ComboSnacks.java
package VentaEntradasCine.Negocio;
public class ComboSnacks extends EntradaDecorator {
    private EntradaDecorator entrada;

    public ComboSnacks(EntradaDecorator entrada) {
        super(entrada.calcularPrecio());
        this.entrada = entrada;
    }

    @Override
    public double calcularPrecio() {
        return entrada.calcularPrecio() + 25.0; // Costo del combo
    }

    @Override
    public String obtenerDescripcion() {
        return entrada.obtenerDescripcion() + " + Combo de snacks";
    }
}