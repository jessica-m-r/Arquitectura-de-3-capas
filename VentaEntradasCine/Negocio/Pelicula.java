// Ubicacion: VentaEntradasCine/Negocio/Pelicula.java
package VentaEntradasCine.Negocio;
import java.util.*;

public class Pelicula {
    private String id;
    private String titulo;
    private String descripcion;
    private double precio;
    private String duracion;
    private String tipoProyeccion; // "2D" o "3D"
    private String idioma; // "Doblada" o "Subtitulada"
    private List<String> horarios;

    // Constructor
    public Pelicula(String id, String titulo, String descripcion, double precio, 
                    String duracion, String tipoProyeccion, String idioma) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.duracion = duracion;
        this.tipoProyeccion = tipoProyeccion;
        this.idioma = idioma;
        this.horarios = new ArrayList<>();
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    
    public String getDuracion() { return duracion; }
    public void setDuracion(String duracion) { this.duracion = duracion; }
    
    public String getTipoProyeccion() { return tipoProyeccion; }
    public void setTipoProyeccion(String tipoProyeccion) { this.tipoProyeccion = tipoProyeccion; }
    
    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    
    public List<String> getHorarios() { return new ArrayList<>(horarios); }
    public void agregarHorario(String horario) { this.horarios.add(horario); }
    public void eliminarHorario(String horario) { this.horarios.remove(horario); }
}
