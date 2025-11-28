// PeliculaFactory.java
// Ubicacion: VentaEntradasCine/Negocio/PeliculaFactory.java
// PATRÓN CREACIONAL - FACTORY
package VentaEntradasCine.Negocio;


public class PeliculaFactory {
    private static int contadorId = 1;

    // Factory Method para crear películas según tipo de proyección
    public static Pelicula crearPelicula(String titulo, String descripcion, 
                                         String duracion, String tipoProyeccion, 
                                         String idioma) {
        String id = "PEL" + String.format("%03d", contadorId++);
        double precioBase = calcularPrecioBase(tipoProyeccion, idioma);
        
        return new Pelicula(id, titulo, descripcion, precioBase, duracion, 
                           tipoProyeccion, idioma);
    }

    private static double calcularPrecioBase(String tipoProyeccion, String idioma) {
        double precio = 30.0; // Precio base
        
        // Ajuste por tipo de proyección
        if ("3D".equalsIgnoreCase(tipoProyeccion)) {
            precio += 15.0;
        }
        
        // Ajuste por idioma
        if ("Subtitulada".equalsIgnoreCase(idioma)) {
            precio += 5.0;
        }
        
        return precio;
    }
}

