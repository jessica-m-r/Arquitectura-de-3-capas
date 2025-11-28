// Ubicacion: VentaEntradasCine/Negocio/Funcion.java
package VentaEntradasCine.Negocio;
public class Funcion {
    private String id;
    private Pelicula pelicula;
    private Sala sala;
    private String horario;
    private String fecha;

    public Funcion(String id, Pelicula pelicula, Sala sala, String horario, String fecha) {
        this.id = id;
        this.pelicula = pelicula;
        this.sala = sala;
        this.horario = horario;
        this.fecha = fecha;
    }

    public String getId() { return id; }
    public Pelicula getPelicula() { return pelicula; }
    public Sala getSala() { return sala; }
    public String getHorario() { return horario; }
    public String getFecha() { return fecha; }
}