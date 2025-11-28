// ============================================
// CLASE MAIN QUE EJECUTA EL PROGRAMA
// ============================================

// Main.java
// Ubicacion: VentaEntradasCine/Main.java
package VentaEntradasCine;

import VentaEntradasCine.Datos.*;
import VentaEntradasCine.Negocio.*;
import VentaEntradasCine.Presentacion.CineUI;

public class Main {
    public static void main(String[] args) {
        // Inicializar DAOs (Singleton)
        PeliculaDao peliculaDao = PeliculaDaoImpl.getInstance();
        SalaDao salaDao = SalaDaoImpl.getInstance();
        FuncionDao funcionDao = FuncionDaoImpl.getInstance();
        EntradaDao entradaDao = EntradaDaoImpl.getInstance();
        
        // Inicializar Service
        CineService cineService = new CineServiceImpl(peliculaDao, salaDao, funcionDao, entradaDao);
        
        // ============================================
        // CARGAR DATOS DE PRUEBA
        // ============================================
        cargarDatosPrueba(cineService);
        
        // Inicializar UI
        CineUI cineUI = new CineUI(cineService);
        
        // Mostrar menú principal
        cineUI.mostrarMenuPrincipal();
    }
    
    private static void cargarDatosPrueba(CineService cineService) {
        System.out.println("Cargando datos de prueba...");
        
        // ===== CREAR PELÍCULAS =====
        
        // Película 1: Avengers (3D, Subtitulada)
        Pelicula pelicula1 = PeliculaFactory.crearPelicula(
            "Avengers: Endgame",
            "Los Vengadores se enfrentan a Thanos en una batalla épica por el destino del universo.",
            "181 min",
            "3D",
            "Subtitulada"
        );
        pelicula1.agregarHorario("14:00");
        pelicula1.agregarHorario("17:30");
        pelicula1.agregarHorario("21:00");
        cineService.agregarPelicula(pelicula1);
        
        // Película 2: Toy Story (2D, Doblada)
        Pelicula pelicula2 = PeliculaFactory.crearPelicula(
            "Toy Story 4",
            "Woody y sus amigos juguetes emprenden una nueva aventura con Forky.",
            "100 min",
            "2D",
            "Doblada"
        );
        pelicula2.agregarHorario("15:00");
        pelicula2.agregarHorario("18:00");
        pelicula2.agregarHorario("20:30");
        cineService.agregarPelicula(pelicula2);
        
        // Película 3: Spider-Man (3D, Doblada)
        Pelicula pelicula3 = PeliculaFactory.crearPelicula(
            "Spider-Man: No Way Home",
            "Peter Parker busca ayuda del Doctor Strange cuando su identidad es revelada.",
            "148 min",
            "3D",
            "Doblada"
        );
        pelicula3.agregarHorario("16:00");
        pelicula3.agregarHorario("19:30");
        pelicula3.agregarHorario("22:00");
        cineService.agregarPelicula(pelicula3);
        
        // ===== CREAR SALAS =====
        
        // Sala 1: Sala Premium (pequeña)
        Sala sala1 = new Sala("SALA01", "Sala Premium", 5, 8);
        cineService.agregarSala(sala1);
        
        // Sala 2: Sala Estándar (mediana)
        Sala sala2 = new Sala("SALA02", "Sala Estándar", 8, 10);
        cineService.agregarSala(sala2);
        
        // Sala 3: Sala IMAX (grande)
        Sala sala3 = new Sala("SALA03", "Sala IMAX", 10, 12);
        cineService.agregarSala(sala3);
        
        // ===== CREAR FUNCIONES =====
        
        // Función 1: Avengers en Sala IMAX a las 17:30
        Funcion funcion1 = new Funcion(
            "FUN001",
            pelicula1,
            sala3,
            "17:30",
            "2024-12-15"
        );
        cineService.agregarFuncion(funcion1);
        
        // Función 2: Avengers en Sala Premium a las 21:00
        Funcion funcion2 = new Funcion(
            "FUN002",
            pelicula1,
            sala1,
            "21:00",
            "2024-12-15"
        );
        cineService.agregarFuncion(funcion2);
        
        // Función 3: Toy Story en Sala Estándar a las 15:00
        Funcion funcion3 = new Funcion(
            "FUN003",
            pelicula2,
            sala2,
            "15:00",
            "2024-12-15"
        );
        cineService.agregarFuncion(funcion3);
        
        // Función 4: Toy Story en Sala Estándar a las 18:00
        Funcion funcion4 = new Funcion(
            "FUN004",
            pelicula2,
            sala2,
            "18:00",
            "2024-12-15"
        );
        cineService.agregarFuncion(funcion4);
        
        // Función 5: Spider-Man en Sala IMAX a las 19:30
        Funcion funcion5 = new Funcion(
            "FUN005",
            pelicula3,
            sala3,
            "19:30",
            "2024-12-16"
        );
        cineService.agregarFuncion(funcion5);
        
        // Función 6: Spider-Man en Sala Premium a las 22:00
        Funcion funcion6 = new Funcion(
            "FUN006",
            pelicula3,
            sala1,
            "22:00",
            "2024-12-16"
        );
        cineService.agregarFuncion(funcion6);
        
        System.out.println("Datos de prueba cargados exitosamente!");
        System.out.println("  - 3 Películas");
        System.out.println("  - 3 Salas");
        System.out.println("  - 6 Funciones");
        System.out.println();
    }
}