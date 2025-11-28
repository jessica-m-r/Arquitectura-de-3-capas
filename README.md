# Gestión de Cine - Venta de Entradas

Este proyecto permite la gestión integral de un cine, incluyendo películas, salas, funciones y venta de entradas, con aplicación de descuentos y búsqueda dinámica de películas. Está desarrollado en **Java** utilizando **Visual Studio Code** como entorno de desarrollo.

---

## Arquitectura

El sistema se organiza en **tres capas**:

**1. Capa de Presentación**
Encargada de la interacción con el usuario, mostrando información y recibiendo entradas a través de la interfaz (`CineUI`).

**2. Capa de Lógica de Negocio**
Contiene la lógica central del sistema, gestionando la creación de películas, salas y funciones, la venta de entradas con aplicación de descuentos, y la búsqueda dinámica de películas mediante patrones de diseño:

* **Factory**: Para la creación flexible de películas (`PeliculaFactory`).
* **Decorator**: Para aplicar descuentos y combos a las entradas (`EntradaDecorator`, `DescuentoTercerEdad`, `ComboSnacks`).
* **Strategy**: Para implementar diferentes estrategias de búsqueda de películas (`EstrategiaBusqueda`, `BusquedaPorTitulo`, `BusquedaPorIdioma`).

**3. Capa de Acceso a Datos**
Gestiona el almacenamiento y recuperación de información mediante interfaces y clases DAO (`PeliculaDao`, `SalaDao`, `FuncionDao`, `EntradaDao` y sus implementaciones). Se utiliza **Singleton** para mantener una única instancia de cada DAO.

---

## Funcionalidades Principales

**Gestión de Películas**

* Crear películas con precio calculado según tipo de proyección e idioma.
* Visualizar, actualizar y eliminar películas.
* Buscar películas por título o idioma usando Strategy.

**Gestión de Salas**

* Crear salas con dimensiones personalizadas.
* Visualizar disponibilidad de asientos y el mapa de la sala en tiempo real.

**Gestión de Funciones**

* Crear funciones asociando películas y salas.
* Visualizar funciones programadas.

**Venta de Entradas**

* Selección y cancelación de asientos.
* Aplicación de descuentos y combos mediante Decorator:

  * Tercera edad (30%)
  * Combo de snacks (+Bs. 25)
* Visualización de todas las ventas.

**Sistema de Búsqueda**

* Estrategias dinámicas de búsqueda de películas por título o idioma mediante Strategy.

---

## Principios SOLID Aplicados
* **SRP (Single Responsibility Principle):**  Cada clase debe tener una única responsabilidad o motivo para cambiar. (Pelicula, Sala, CineService, CineUI, DAO's)
* **OCP (Open/Closed Principle):** Las clases están abiertas a extensión pero cerradas a modificación. Decorator permite agregar funcionalidades a las entradas sin modificar la clase base.
* **LSP (Liskov Substitution Principle):** Las clases derivadas o implementaciones de una interfaz deben poder sustituir a sus padres sin afectar el comportamiento del programa. (PeliculaDaoImpl, SalaDaoImpl, Los decoradores (DescuentoTercerEdad) pueden sustituir a EntradaDecorator.
)
* **ISP (Interface Segregation Principle):** Interfaces específicas para cada funcionalidad (PeliculaDao, SalaDao, FuncionDao, EntradaDao, EstrategiaBusqueda).
* **DIP (Dependency Inversion Principle):** Clases de alto nivel dependen de interfaces y no de implementaciones concretas, inyección de dependencias mediante constructores.

---

## Tecnologías Utilizadas

* **Lenguaje:** Java
* **IDE:** Visual Studio Code
* **Patrones de Diseño:** Factory, Decorator, Strategy, Singleton, DAO
* **Arquitectura:** Tres capas (Presentación, Negocio, Datos)

---

## Estructura del Proyecto

```
VentaEntradasCine/
├── Main.java
├── Datos/
│   ├── PeliculaDao.java
│   ├── PeliculaDaoImpl.java
│   ├── SalaDao.java
│   ├── SalaDaoImpl.java
│   ├── FuncionDao.java
│   ├── FuncionDaoImpl.java
│   ├── EntradaDao.java
│   └── EntradaDaoImpl.java
├── Negocio/
│   ├── Pelicula.java
│   ├── Sala.java
│   ├── Funcion.java
│   ├── Entrada.java
│   ├── PeliculaFactory.java
│   ├── EntradaDecorator.java
│   ├── DescuentoTercerEdad.java
│   ├── ComboSnacks.java
│   ├── EstrategiaBusqueda.java
│   ├── BusquedaPorTitulo.java
│   ├── BusquedaPorIdioma.java
│   ├── CineService.java
│   └── CineServiceImpl.java
└── Presentacion/
    └── CineUI.java
```

---

