# Spyro The Dragon App

## Introducción
Esta aplicación está inspirada en el universo de *Spyro the Dragon*. Su objetivo es ofrecer a los fans una experiencia interactiva donde puedan explorar información sobre los mundos, personajes y objetos coleccionables de la saga de videojuegos.

Además, la app incluye una guía interactiva para mejorar la experiencia del usuario y varios *easter eggs* que aportan un toque de sorpresa y entretenimiento.

## Características principales
- **Exploración de contenido**: La app presenta tres secciones principales en forma de *fragments*, cada una mostrando un listado con información detallada sobre:
  - Mundos
  - Personajes
  - Objetos coleccionables
- **Interfaz atractiva y dinámica**: Uso de animaciones, sonidos y elementos gráficos.
- **Guía interactiva**: Un tutorial visual con efectos y animaciones que presenta las funcionalidades de la app.
- **Easter eggs ocultos**: Incluye eventos sorpresa, como un video especial al realizar una acción determinada.
- **Persistencia de datos**: Uso de *SharedPreferences* para gestionar la visualización del tutorial.

## Tecnologías utilizadas
La app está desarrollada para Android utilizando las siguientes tecnologías y librerías:

- **Lenguaje:** Java
- **Arquitectura:** Fragments y RecyclerView
- **UI & Animaciones:**
  - ViewBinding y DataBinding
  - ConstraintLayout
  - Material Components
  - Droidsonroids GIF Drawable (*pl.droidsonroids.gif:android-gif-drawable:1.2.24*)
- **Navegación:** Jetpack Navigation
- **Gestión de ciclo de vida:** ViewModel & LiveData
- **Tests:** JUnit y Espresso

## Instrucciones de uso
Para ejecutar la aplicación en tu entorno de desarrollo, sigue estos pasos:

1. **Descargar el código fuente:**
   - Abre Android Studio.
   - En el menú superior, selecciona *File > New > Project From Version Control...*.
   - En la ventana emergente, elige *Git* y coloca la siguiente URL del repositorio:  
     `https://github.com/lbarmar/SpyroTheDragon.git`
   - Define un directorio local donde se clonará el proyecto y haz clic en *Clone*.

2. **Compilar y ejecutar:**
   - Asegúrate de tener un emulador o un dispositivo físico conectado.
   - Compila y ejecuta el proyecto desde Android Studio.

## Conclusiones del desarrollador
El desarrollo de esta aplicación ha sido un proceso enriquecedor, permitiendo profundizar en la implementación de *RecyclerView*, *Fragments* y animaciones en Android.

Además, se han explorado conceptos como la persistencia de datos con *SharedPreferences* y el uso de librerías para mejorar la experiencia visual y funcional de la app. En futuras mejoras, se busca optimizar la estética de la guía interactiva y mejorar los efectos visuales.

## Capturas de pantalla

### Guía
![Guía](screenshots/pantalla_principal.png)

### Ester Eggs
![EsterEggs](screenshots/lista_personajes.png)


