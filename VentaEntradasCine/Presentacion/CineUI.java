// ============================================
// CAPA DE PRESENTACIÓN (UI)
// ============================================

// CineUI.java
// Ubicacion: VentaEntradasCine/Presentacion/CineUI.java
package VentaEntradasCine.Presentacion;
import VentaEntradasCine.Negocio.*;
import java.util.*;

public class CineUI {
    private CineService cineService;
    private Scanner scanner = new Scanner(System.in);

    public CineUI(CineService cineService) {
        this.cineService = cineService;
    }

    public void mostrarMenuPrincipal() {
        while (true) {
            System.out.println("\n========== SISTEMA DE CINE ==========");
            System.out.println("1. Gestión de Películas");
            System.out.println("2. Gestión de Salas");
            System.out.println("3. Gestión de Funciones");
            System.out.println("4. Vender Entrada");
            System.out.println("5. Ver Todas las Entradas");
            System.out.println("6. Cancelar Entrada");
            System.out.println("7. Buscar Películas");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir newline
            
            switch (opcion) {
                case 1:
                    menuPeliculas();
                    break;
                case 2:
                    menuSalas();
                    break;
                case 3:
                    menuFunciones();
                    break;
                case 4:
                    venderEntrada();
                    break;
                case 5:
                    verTodasEntradas();
                    break;
                case 6:
                    cancelarEntrada();
                    break;
                case 7:
                    buscarPeliculas();
                    break;
                case 8:
                    System.out.println("¡Gracias por usar el sistema!");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida");
            }
        }
    }

    private void menuPeliculas() {
        System.out.println("\n--- Gestión de Películas ---");
        System.out.println("1. Agregar Película");
        System.out.println("2. Ver Todas las Películas");
        System.out.println("3. Actualizar Película");
        System.out.println("4. Eliminar Película");
        System.out.println("5. Volver");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                agregarPelicula();
                break;
            case 2:
                verTodasPeliculas();
                break;
            case 3:
                actualizarPelicula();
                break;
            case 4:
                eliminarPelicula();
                break;
            case 5:
                return;
        }
    }

    private void agregarPelicula() {
        System.out.println("\n--- Agregar Nueva Película ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        
        System.out.print("Duración (ej: 120 min): ");
        String duracion = scanner.nextLine();
        
        System.out.print("Tipo de proyección (2D/3D): ");
        String tipo = scanner.nextLine();
        
        System.out.print("Idioma (Doblada/Subtitulada): ");
        String idioma = scanner.nextLine();
        
        // Usar Factory para crear la película
        Pelicula pelicula = PeliculaFactory.crearPelicula(titulo, descripcion, duracion, tipo, idioma);
        
        System.out.print("¿Cuántos horarios desea agregar?: ");
        int numHorarios = scanner.nextInt();
        scanner.nextLine();
        
        for (int i = 0; i < numHorarios; i++) {
            System.out.print("Horario " + (i + 1) + ": ");
            String horario = scanner.nextLine();
            pelicula.agregarHorario(horario);
        }
        
        cineService.agregarPelicula(pelicula);
        System.out.println("\n✓ Película agregada exitosamente con ID: " + pelicula.getId());
        System.out.println("Precio calculado: Bs. " + pelicula.getPrecio());
    }

    private void verTodasPeliculas() {
        System.out.println("\n--- Lista de Películas ---");
        List<Pelicula> peliculas = cineService.obtenerTodasPeliculas();
        
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas registradas.");
            return;
        }
        
        for (Pelicula p : peliculas) {
            System.out.println("\n==================================================");
            System.out.println("ID: " + p.getId());
            System.out.println("Título: " + p.getTitulo());
            System.out.println("Descripción: " + p.getDescripcion());
            System.out.println("Duración: " + p.getDuracion());
            System.out.println("Tipo: " + p.getTipoProyeccion());
            System.out.println("Idioma: " + p.getIdioma());
            System.out.println("Precio: Bs. " + p.getPrecio());
            System.out.println("Horarios: " + p.getHorarios());
        }
    }

    private void actualizarPelicula() {
        System.out.println("\n--- Actualizar Película ---");
        
        // Mostrar películas disponibles
        List<Pelicula> peliculas = cineService.obtenerTodasPeliculas();
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas registradas.");
            return;
        }
        
        System.out.println("Películas disponibles:");
        for (Pelicula p : peliculas) {
            System.out.println("  " + p.getId() + " - " + p.getTitulo());
        }
        
        System.out.print("\nIngrese el ID de la película a actualizar: ");
        String id = scanner.nextLine();
        
        Pelicula pelicula = cineService.obtenerPelicula(id);
        if (pelicula == null) {
            System.out.println("Película no encontrada.");
            return;
        }
        
        System.out.println("\nDatos actuales:");
        System.out.println("Título: " + pelicula.getTitulo());
        System.out.println("Descripción: " + pelicula.getDescripcion());
        System.out.println("Duración: " + pelicula.getDuracion());
        System.out.println("Tipo: " + pelicula.getTipoProyeccion());
        System.out.println("Idioma: " + pelicula.getIdioma());
        System.out.println("Precio: Bs. " + pelicula.getPrecio());
        
        System.out.println("\n¿Qué desea actualizar?");
        System.out.println("1. Título");
        System.out.println("2. Descripción");
        System.out.println("3. Duración");
        System.out.println("4. Precio");
        System.out.println("5. Agregar Horario");
        System.out.println("6. Eliminar Horario");
        System.out.println("7. Cancelar");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                System.out.print("Nuevo título: ");
                String nuevoTitulo = scanner.nextLine();
                pelicula.setTitulo(nuevoTitulo);
                break;
            case 2:
                System.out.print("Nueva descripción: ");
                String nuevaDescripcion = scanner.nextLine();
                pelicula.setDescripcion(nuevaDescripcion);
                break;
            case 3:
                System.out.print("Nueva duración (ej: 120 min): ");
                String nuevaDuracion = scanner.nextLine();
                pelicula.setDuracion(nuevaDuracion);
                break;
            case 4:
                System.out.print("Nuevo precio: ");
                double nuevoPrecio = scanner.nextDouble();
                scanner.nextLine();
                pelicula.setPrecio(nuevoPrecio);
                break;
            case 5:
                System.out.print("Nuevo horario: ");
                String nuevoHorario = scanner.nextLine();
                pelicula.agregarHorario(nuevoHorario);
                break;
            case 6:
                System.out.println("Horarios actuales: " + pelicula.getHorarios());
                System.out.print("Horario a eliminar: ");
                String horarioEliminar = scanner.nextLine();
                pelicula.eliminarHorario(horarioEliminar);
                break;
            case 7:
                System.out.println("Operación cancelada.");
                return;
            default:
                System.out.println("Opción inválida.");
                return;
        }
        
        cineService.actualizarPelicula(pelicula);
        System.out.println("\n✓ Película actualizada exitosamente");
    }

    private void eliminarPelicula() {
        System.out.println("\n--- Eliminar Película ---");
        
        // Mostrar películas disponibles
        List<Pelicula> peliculas = cineService.obtenerTodasPeliculas();
        if (peliculas.isEmpty()) {
            System.out.println("No hay películas registradas.");
            return;
        }
        
        System.out.println("Películas disponibles:");
        for (Pelicula p : peliculas) {
            System.out.println("  " + p.getId() + " - " + p.getTitulo());
        }
        
        System.out.print("\nIngrese el ID de la película a eliminar: ");
        String id = scanner.nextLine();
        
        Pelicula pelicula = cineService.obtenerPelicula(id);
        if (pelicula == null) {
            System.out.println("Película no encontrada.");
            return;
        }
        
        System.out.print("¿Está seguro de eliminar '" + pelicula.getTitulo() + "'? (S/N): ");
        String confirmacion = scanner.nextLine();
        
        if (confirmacion.equalsIgnoreCase("S")) {
            cineService.eliminarPelicula(id);
            System.out.println("\n✓ Película eliminada exitosamente");
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    private void menuSalas() {
        System.out.println("\n--- Gestión de Salas ---");
        System.out.println("1. Agregar Sala");
        System.out.println("2. Ver Todas las Salas");
        System.out.println("3. Volver");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                agregarSala();
                break;
            case 2:
                verTodasSalas();
                break;
            case 3:
                return;
        }
    }

    private void agregarSala() {
        System.out.println("\n--- Agregar Nueva Sala ---");
        System.out.print("ID de la sala: ");
        String id = scanner.nextLine();
        
        System.out.print("Nombre de la sala: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Número de filas: ");
        int filas = scanner.nextInt();
        
        System.out.print("Número de columnas: ");
        int columnas = scanner.nextInt();
        scanner.nextLine();
        
        Sala sala = new Sala(id, nombre, filas, columnas);
        cineService.agregarSala(sala);
        
        System.out.println("\n✓ Sala agregada exitosamente");
        System.out.println("Capacidad total: " + (filas * columnas) + " asientos");
    }

    private void verTodasSalas() {
        System.out.println("\n--- Lista de Salas ---");
        List<Sala> salas = cineService.obtenerTodasSalas();
        
        if (salas.isEmpty()) {
            System.out.println("No hay salas registradas.");
            return;
        }
        
        for (Sala s : salas) {
            System.out.println("\n==================================================");
            System.out.println("ID: " + s.getId());
            System.out.println("Nombre: " + s.getNombre());
            System.out.println("Dimensiones: " + s.getFilas() + "x" + s.getColumnas());
            System.out.println("Asientos disponibles: " + s.contarAsientosDisponibles() + 
                            "/" + (s.getFilas() * s.getColumnas()));
        }
    }

    private void menuFunciones() {
        System.out.println("\n--- Gestión de Funciones ---");
        System.out.println("1. Crear Función");
        System.out.println("2. Ver Todas las Funciones");
        System.out.println("3. Volver");
        System.out.print("Seleccione una opción: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcion) {
            case 1:
                crearFuncion();
                break;
            case 2:
                verTodasFunciones();
                break;
            case 3:
                return;
        }
    }

    private void crearFuncion() {
        System.out.println("\n--- Crear Nueva Función ---");
        
        // Mostrar películas disponibles
        System.out.println("Películas disponibles:");
        List<Pelicula> peliculas = cineService.obtenerTodasPeliculas();
        for (Pelicula p : peliculas) {
            System.out.println("  " + p.getId() + " - " + p.getTitulo());
        }
        
        System.out.print("ID de la película: ");
        String peliculaId = scanner.nextLine();
        Pelicula pelicula = cineService.obtenerPelicula(peliculaId);
        
        if (pelicula == null) {
            System.out.println("Película no encontrada.");
            return;
        }
        
        // Mostrar salas disponibles
        System.out.println("\nSalas disponibles:");
        List<Sala> salas = cineService.obtenerTodasSalas();
        for (Sala s : salas) {
            System.out.println("  " + s.getId() + " - " + s.getNombre());
        }
        
        System.out.print("ID de la sala: ");
        String salaId = scanner.nextLine();
        Sala sala = cineService.obtenerSala(salaId);
        
        if (sala == null) {
            System.out.println("Sala no encontrada.");
            return;
        }
        
        System.out.print("ID de la función: ");
        String funcionId = scanner.nextLine();
        
        System.out.print("Horario (ej: 18:00): ");
        String horario = scanner.nextLine();
        
        System.out.print("Fecha (ej: 2024-12-01): ");
        String fecha = scanner.nextLine();
        
        Funcion funcion = new Funcion(funcionId, pelicula, sala, horario, fecha);
        cineService.agregarFuncion(funcion);
        
        System.out.println("\n✓ Función creada exitosamente");
    }

    private void verTodasFunciones() {
        System.out.println("\n--- Lista de Funciones ---");
        List<Funcion> funciones = cineService.obtenerTodasFunciones();
        
        if (funciones.isEmpty()) {
            System.out.println("No hay funciones registradas.");
            return;
        }
        
        for (Funcion f : funciones) {
            System.out.println("\n==================================================");
            System.out.println("ID Función: " + f.getId());
            System.out.println("Película: " + f.getPelicula().getTitulo());
            System.out.println("Sala: " + f.getSala().getNombre());
            System.out.println("Horario: " + f.getHorario());
            System.out.println("Fecha: " + f.getFecha());
            System.out.println("Asientos disponibles: " + f.getSala().contarAsientosDisponibles());
        }
    }

    private void venderEntrada() {
        System.out.println("\n--- Vender Entrada ---");
        
        // Mostrar funciones disponibles
        System.out.println("Funciones disponibles:");
        List<Funcion> funciones = cineService.obtenerTodasFunciones();
        
        if (funciones.isEmpty()) {
            System.out.println("No hay funciones disponibles.");
            return;
        }
        
        for (Funcion f : funciones) {
            System.out.println("  " + f.getId() + " - " + f.getPelicula().getTitulo() + 
                             " (" + f.getHorario() + " - " + f.getFecha() + ")");
        }
        
        System.out.print("\nID de la función: ");
        String funcionId = scanner.nextLine();
        
        Funcion funcion = cineService.obtenerFuncion(funcionId);
        if (funcion == null) {
            System.out.println("Función no encontrada.");
            return;
        }
        
        // Mostrar mapa de asientos
        mostrarMapaAsientos(funcion.getSala());
        
        System.out.print("\nFila del asiento (0-" + (funcion.getSala().getFilas() - 1) + "): ");
        int fila = scanner.nextInt();
        
        System.out.print("Columna del asiento (0-" + (funcion.getSala().getColumnas() - 1) + "): ");
        int columna = scanner.nextInt();
        scanner.nextLine();
        
        // Verificar disponibilidad
        if (!cineService.verificarDisponibilidadAsiento(funcionId, fila, columna)) {
            System.out.println("El asiento ya está ocupado o no es válido.");
            return;
        }
        
        // Preguntar por descuentos
        System.out.println("\nTipos de descuento disponibles:");
        System.out.println("1. Sin descuento");
        System.out.println("2. Tercera edad (30% descuento)");
        System.out.println("3. Combo snacks (+Bs. 25)");
        System.out.print("Seleccione una opción: ");
        
        int opcionDescuento = scanner.nextInt();
        scanner.nextLine();

        String tipoDescuento = null;

        if (opcionDescuento == 2) {
            tipoDescuento = "tercera edad";
        } else {
            tipoDescuento = "combo";
        }
        
        try {
            Entrada entrada = cineService.venderEntrada(funcionId, fila, columna, tipoDescuento);
            
            System.out.println("\n==================================================");
            System.out.println("✓ ENTRADA VENDIDA EXITOSAMENTE");
            System.out.println("==================================================");
            System.out.println("ID Entrada: " + entrada.getId());
            System.out.println("Película: " + entrada.getFuncion().getPelicula().getTitulo());
            System.out.println("Sala: " + entrada.getFuncion().getSala().getNombre());
            System.out.println("Horario: " + entrada.getFuncion().getHorario());
            System.out.println("Fecha: " + entrada.getFuncion().getFecha());
            System.out.println("Asiento: Fila " + entrada.getFila() + ", Columna " + entrada.getColumna());
            System.out.println("Precio Final: Bs. " + entrada.getPrecioFinal());
            System.out.println("==================================================");
            
        } catch (Exception e) {
            System.out.println("Error al vender entrada: " + e.getMessage());
        }
    }

    private void mostrarMapaAsientos(Sala sala) {
        System.out.println("\nMapa de Asientos:");
        System.out.println("O = Disponible | X = Ocupado\n");
        
        System.out.print("    ");
        for (int j = 0; j < sala.getColumnas(); j++) {
            System.out.print(j + " ");
        }
        System.out.println();
        
        for (int i = 0; i < sala.getFilas(); i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < sala.getColumnas(); j++) {
                if (sala.estaOcupado(i, j)) {
                    System.out.print("X ");
                } else {
                    System.out.print("O ");
                }
            }
            System.out.println();
        }
    }

    private void verTodasEntradas() {
        System.out.println("\n--- Lista de Entradas Vendidas ---");
        List<Entrada> entradas = cineService.obtenerTodasEntradas();
        
        if (entradas.isEmpty()) {
            System.out.println("No hay entradas vendidas.");
            return;
        }
        
        double totalVentas = 0;
        for (Entrada e : entradas) {
            System.out.println("\n==================================================");
            System.out.println("ID Entrada: " + e.getId());
            System.out.println("Película: " + e.getFuncion().getPelicula().getTitulo());
            System.out.println("Sala: " + e.getFuncion().getSala().getNombre());
            System.out.println("Horario: " + e.getFuncion().getHorario());
            System.out.println("Asiento: Fila " + e.getFila() + ", Columna " + e.getColumna());
            System.out.println("Precio: Bs. " + e.getPrecioFinal());
            totalVentas += e.getPrecioFinal();
        }
        
        System.out.println("\n==================================================");
        System.out.println("TOTAL VENTAS: Bs. " + totalVentas);
        System.out.println("==================================================");
    }

    private void cancelarEntrada() {
        System.out.println("\n--- Cancelar Entrada ---");
        
        // Mostrar entradas disponibles
        List<Entrada> entradas = cineService.obtenerTodasEntradas();
        if (entradas.isEmpty()) {
            System.out.println("No hay entradas vendidas.");
            return;
        }
        
        System.out.println("Entradas vendidas:");
        for (Entrada e : entradas) {
            System.out.println("  " + e.getId() + " - " + e.getFuncion().getPelicula().getTitulo() + 
                             " (Fila: " + e.getFila() + ", Col: " + e.getColumna() + ")");
        }
        
        System.out.print("\nIngrese el ID de la entrada a cancelar: ");
        String id = scanner.nextLine();
        
        Entrada entrada = cineService.obtenerTodasEntradas().stream()
            .filter(e -> e.getId().equals(id))
            .findFirst()
            .orElse(null);
        
        if (entrada == null) {
            System.out.println("Entrada no encontrada.");
            return;
        }
        
        System.out.print("¿Está seguro de cancelar esta entrada? (S/N): ");
        String confirmacion = scanner.nextLine();
        
        if (confirmacion.equalsIgnoreCase("S")) {
            cineService.cancelarEntrada(id);
            System.out.println("\n✓ Entrada cancelada exitosamente");
            System.out.println("El asiento ha sido liberado.");
        } else {
            System.out.println("Operación cancelada.");
        }
    }

    private void buscarPeliculas() {
        System.out.println("\n--- Buscar Películas ---");
        System.out.println("1. Buscar por título");
        System.out.println("2. Buscar por idioma");
        System.out.print("Seleccione tipo de búsqueda: ");
        
        int opcion = scanner.nextInt();
        scanner.nextLine();
        
        String tipoBusqueda = "";
        String criterio = "";
        
        if (opcion == 1) {
            tipoBusqueda = "titulo";
            System.out.print("Ingrese el título a buscar: ");
            criterio = scanner.nextLine();
        } else if (opcion == 2) {
            tipoBusqueda = "idioma";
            System.out.print("Ingrese el idioma (Doblada/Subtitulada): ");
            criterio = scanner.nextLine();
        } else {
            System.out.println("Opción inválida");
            return;
        }
        
        List<Pelicula> resultados = cineService.buscarPeliculas(tipoBusqueda, criterio);
        
        System.out.println("\n--- Resultados de la Búsqueda ---");
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron películas.");
            return;
        }
        
        for (Pelicula p : resultados) {
            System.out.println("\n==================================================");
            System.out.println("ID: " + p.getId());
            System.out.println("Título: " + p.getTitulo());
            System.out.println("Tipo: " + p.getTipoProyeccion());
            System.out.println("Idioma: " + p.getIdioma());
            System.out.println("Precio: Bs. " + p.getPrecio());
        }
    }
}