# Gestor de Cursos - Aplicación Web con Jakarta EE

Este es un proyecto de aplicación web desarrollada con Jakarta EE para gestionar una base de datos de cursos. La aplicación sigue una arquitectura MVC (Modelo-Vista-Controlador), permitiendo a los usuarios ver un listado de cursos y buscarlos por nombre.

## ✨ Características

-   **Listado de Cursos**: Muestra todos los cursos disponibles en una tabla estilizada.
-   **Búsqueda de Cursos**: Permite buscar cursos por su nombre.
-   **Diseño Responsivo**: Interfaz de usuario moderna creada con Bootstrap 5.
-   **Arquitectura MVC**: Código organizado separando el modelo, la vista y el controlador.

## 🛠️ Tecnologías Utilizadas

-   **Backend**: Java 16, Jakarta EE 10 (Servlets)
-   **Frontend**: JSP, JSTL, Bootstrap 5
-   **Base de Datos**: MySQL
-   **Build Tool**: Maven

## 🚀 Cómo Empezar

Sigue estos pasos para configurar y ejecutar el proyecto en tu entorno local.

### Prerrequisitos

-   JDK 16 o superior.
-   Maven 3.x.
-   Un servidor de aplicaciones compatible con Jakarta EE 10 (ej. Apache Tomcat 10.x).
-   Una base de datos MySQL.

### Configuración

1.  **Clona el repositorio:**
    ```bash
    git clone <URL_DE_TU_REPOSITORIO>
    cd webapp-bbdd-tarea9
    ```

2.  **Configura la base de datos:**
    -   Crea una base de datos en MySQL (ej. `cursos_db`).
    -   Crea la tabla `cursos` con la siguiente estructura:
        ```sql
        CREATE TABLE cursos (
          id INT AUTO_INCREMENT PRIMARY KEY,
          nombre VARCHAR(255) NOT NULL,
          descripcion VARCHAR(255),
          instructor VARCHAR(255),
          duracion FLOAT
        );
        ```

3.  **Configura la conexión:**
    -   Ve a `src/main/resources/`.
    -   Crea una copia del archivo `config.properties.example` y renómbrala a `config.properties`.
    -   Edita `config.properties` con tus credenciales de la base de datos:
        ```properties
        db.url=jdbc:mysql://localhost:3306/cursos_db
        db.username=tu_usuario
        db.password=tu_contraseña
        ```

### Ejecución

1.  **Compila el proyecto con Maven:**
    ```bash
    mvn clean install
    ```
2.  **Despliega el archivo `.war`:**
    -   Toma el archivo `webapp-bbdd-tarea9.war` de la carpeta `target/`.
    -   Despliégalo en tu servidor Tomcat.

3.  **Accede a la aplicación:**
    Abre tu navegador y ve a `http://localhost:8080/webapp-bbdd-tarea9/`
