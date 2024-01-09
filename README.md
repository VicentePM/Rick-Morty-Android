# Rick & Morty App - Explorador de Personajes y Episodios

Rick & Morty App es una aplicación Android desarrollada en Kotlin utilizando la arquitectura MVVM y la librería Retrofit para obtener datos de la API de Rick & Morty. La aplicación incluye funcionalidades como la visualización de personajes, búsqueda por nombre, paginación, y un listado de episodios para cada personaje en la pantalla de detalles.

## Configuración del Proyecto

1. **Clonar el Repositorio:**
   ```bash
   git clone https://github.com/VicentePM/Rick-Morty-Android.git
   ```

2. **Configurar API Key:**
   - No se requiere una clave API para la API de Rick & Morty.

3. **Ejecutar la Aplicación:**
   - Abrir el proyecto en Android Studio.
   - Conectar un dispositivo Android o utilizar un emulador.
   - Ejecutar la aplicación.

## Funcionalidades de la Aplicación

### Pantalla Principal - Lista de Personajes

- **Obtener Lista de Personajes:**
  - Realiza una solicitud GET al endpoint "character" de la API.
  - Muestra un listado de personajes con información detallada.
  
- **Buscar Personajes por Nombre:**
  - Incorpora la funcionalidad de búsqueda por nombre de personaje.

- **Paginación:**
  - Implementa un paginador para acceder a la siguiente página de personajes.
  - El botón anterior desaparece o lleva a la última página cuando estamos en la primera página.

### Pantalla Detalle de Personaje

- **Visualizar Información de Personaje:**
  - Muestra información detallada sobre un personaje seleccionado.
  
- **Listado de Episodios:**
  - Implementa un listado de episodios en la pantalla de detalles de cada personaje.

## Dependencias Principales

- [Retrofit](https://square.github.io/retrofit/) - Cliente HTTP para realizar solicitudes a la API.
- [MVVM Architecture](https://developer.android.com/jetpack/guide) - Modelo de diseño arquitectónico para una separación clara de responsabilidades.
- [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview) - Para mostrar listas de elementos de manera eficiente.

## Contribuciones

¡Contribuciones son bienvenidas! Si encuentras algún problema o tienes sugerencias, por favor, abre un issue o envía un pull request.
