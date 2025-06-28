# 🎨 Bocu - Bogotá Cultural 🇨🇴🏙️

**Aplicación Android para visibilizar artistas emergentes y eventos culturales en Bogotá.**

> “La Atenas de Sudamérica merece ser redescubierta.”

---

## 📚 Tabla de Contenidos

1. [Descripción del Proyecto](#-descripción-del-proyecto)
2. [Objetivos](#-objetivos)
3. [Tipos de Usuario](#-tipos-de-usuario)
4. [Funcionalidades](#-funcionalidades-principales)
5. [Tecnologías Utilizadas](#%EF%B8%8F-tecnologías-utilizadas)
6. [Implementación Técnica](#-implementación-técnica)
7. [Pruebas de Rendimiento](#-pruebas-de-rendimiento)
8. [Capturas y Prototipos](#-capturas-y-prototipos)
9. [Equipo de Desarrollo](#-equipo-de-desarrollo)
10. [Lecciones Aprendidas](#-lecciones-aprendidas)

---

## 📱 Descripción del Proyecto

**Bocu** (Bogotá Cultural) es una aplicación móvil desarrollada como producto académico con impacto social, cuyo objetivo principal es combatir la invisibilidad de los artistas emergentes en un entorno digital sobresaturado. A través de una interfaz amigable y funcionalidades centradas en la experiencia cultural, Bocu permite a los usuarios descubrir, guardar y asistir a eventos culturales en Bogotá de forma personalizada y accesible.

La aplicación responde a un contexto urbano en el que, a pesar del potencial artístico de la ciudad, las oportunidades de difusión están profundamente condicionadas por la capacidad económica. En ese sentido, Bocu representa una herramienta democratizadora del arte y una plataforma para la reactivación cultural desde las bases sociales.

---

## 🎯 Objetivos

El desarrollo de **Bocu** persiguió múltiples objetivos estructurados desde lo técnico, lo cultural y lo social:

- **Visibilizar artistas emergentes** que no cuentan con los medios para promocionarse en canales digitales tradicionales, dándoles voz y espacio dentro de la ciudad.
- **Centralizar y organizar la oferta cultural** dispersa en Bogotá, facilitando su acceso a todos los ciudadanos sin importar su edad, nivel educativo o ubicación.
- **Ofrecer una experiencia personalizada y significativa**, donde los usuarios puedan descubrir contenido ajustado a sus intereses, maximizando así la participación.
- **Incentivar la ciudadanía cultural**, promoviendo la asistencia a eventos locales y el fortalecimiento del tejido artístico comunitario desde la tecnología.

---

## 👥 Tipos de Usuario

Bocu incorpora una lógica de usuario segmentada, reconociendo que no todos los participantes tienen los mismos intereses o capacidades:

| Tipo de Usuario     | Descripción |
|---------------------|-------------|
| **Invitado**        | Puede navegar libremente por los eventos, ver información general, explorar actividades por categorías, y acceder sin registrarse. Su experiencia es más superficial pero inmediata. |
| **Usuario Registrado** | Obtiene una experiencia más profunda y personalizada. Puede configurar sus intereses, guardar favoritos, recibir sugerencias y ordenar o filtrar eventos. Es el usuario con perfil cultural definido. |
| **Expositor / Artista** | Además de tener acceso a lo anterior, puede **crear, modificar y eliminar** eventos propios, dando a conocer su trabajo y gestionando un portafolio artístico digital. Es el protagonista cultural de la aplicación. |

Este modelo fomenta una relación escalable con la plataforma, permitiendo que un usuario casual se convierta en colaborador activo de la escena cultural local.

---

## 🔧 Funcionalidades Principales

Cada funcionalidad fue pensada para resolver necesidades concretas, tanto del usuario común como del artista independiente:

- 🔐 **Inicio de sesión y registro** con validaciones rigurosas, asegurando autenticidad y usabilidad.
- 🧭 **Página principal dinámica**, adaptada a los intereses del usuario y actualizada constantemente.
- 📌 **Sistema de filtros y ordenamiento avanzado**, con criterios como categoría, precio, cercanía temporal y más.
- ⭐ **Favoritos** como herramienta de organización personal del usuario, almacenada localmente para rapidez.
- ➕ **Creación y administración de eventos**, pensada para artistas con formularios adaptativos y validaciones.
- 🔄 **Edición de perfil y eventos en tiempo real**, reforzando la autonomía del usuario y facilitando iteraciones.
- 🧠 **Sistema de recomendaciones**, basado en los datos de interacción e intereses declarados.
- 📲 **Interfaz intuitiva y responsiva**, enfocada en accesibilidad desde múltiples dispositivos Android.

Cada una de estas funcionalidades se diseñó alineada con las buenas prácticas de diseño centrado en el usuario, priorizando claridad, eficiencia y relevancia cultural.

---

## 🛠️ Tecnologías Utilizadas

La selección tecnológica no fue arbitraria, sino fundamentada en la necesidad de crear un producto funcional, portable y mantenible dentro de las capacidades del equipo:

| Herramienta / Lenguaje | Justificación |
|------------------------|----------------|
| **Android Studio**     | Proporciona herramientas integradas para desarrollar, probar y depurar apps móviles Android. Es robusto y ampliamente adoptado. |
| **Java**               | Lenguaje robusto, orientado a objetos, con gran comunidad y documentación, ideal para control detallado de estructuras de datos. |
| **Git y GitHub**       | Control de versiones distribuido y colaboración en tiempo real. Fundamental para el trabajo en equipo y manejo de versiones. |
| **Dispositivos de prueba físicos** | Se usaron modelos reales de gama media para asegurar compatibilidad, eficiencia y realismo en el rendimiento. |
| **Estructuras de datos personalizadas** | Implementaciones propias de listas, árboles, montículos, grafos, etc., optimizaron el manejo de grandes volúmenes de datos. |

Se priorizó el uso de tecnologías dominadas por el equipo y adaptables a las limitaciones típicas de hardware de usuarios reales en Bogotá.

---

## 🧠 Implementación Técnica

El corazón de Bocu radica en su diseño estructural eficiente. El uso de estructuras de datos no fue solo académico, sino estratégico:

- **Listas enlazadas**: evitan duplicados en usuarios y permiten inserciones/borrados eficientes.
- **Listas desordenadas dinámicas**: facilitan la visualización flexible y sin bloqueos de los eventos.
- **Pilas**: implementan un historial de navegación cultural útil para el usuario curioso o indeciso.
- **Montículos (MaxHeap / MinHeap)**: ordenan eventos por criterios (fecha, popularidad, precio) con máxima eficiencia.
- **Árboles AVL y BST**: permiten búsquedas rápidas, incluso con volúmenes masivos.
- **Conjuntos disjuntos**: usados para relaciones internas y segmentación inteligente de datos.
- **Tablas hash**: vitales para autenticación y gestión rápida de favoritos.
- **Grafos**: exploración y relaciones entre eventos, categorías, artistas y localidades.

Este enfoque permitió alcanzar tiempos óptimos de respuesta, reduciendo el uso de memoria y mejorando la experiencia del usuario final.

---

## 📊 Pruebas de Rendimiento

Las pruebas realizadas no solo validaron el funcionamiento, sino también la **eficiencia teórica y práctica** del software:

- Se emplearon datasets crecientes (hasta **100 millones de datos**) para medir tiempo promedio por operación.
- Comparativas: BST vs AVL (ganó AVL recursivo por su balanceo), montículos binarios vs cuaternarios (mejor profundidad).
- HashTables: se evaluaron distintos factores de carga y funciones hash (mejor: 0.75 + bitwise).
- Grafos: se midió rendimiento de búsquedas (BFS y DFS) en grafos dispersos y densos.
- Se consideraron métricas como **colisiones, errores de memoria, escalabilidad, y robustez de los algoritmos**.

Estas pruebas confirmaron que la aplicación puede mantenerse eficiente incluso bajo condiciones exigentes, cumpliendo con estándares académicos y de la industria.

---

## 📷 Capturas y Prototipos

- 📁 [Entrega 1 - Prototipo Inicial](https://drive.google.com/drive/folders/15_-eG5SVKDk34VKrz7Br3tsFfCbIOmfQ?usp=sharing)
- 📁 [Entrega 2 - Versión Avanzada](https://drive.google.com/drive/folders/1YPkt88uwSq5_T8D8qechMXyEMlKmHK3V?usp=sharing)
- 📁 [Entrega 3 - Prototipo Final](https://drive.google.com/file/d/1CXrcB_N0LZRrZZLpJhz1Lfy7FmmObFVN/view?usp=sharing)

Estos enlaces permiten explorar la evolución visual y funcional de la app a lo largo del desarrollo.

---

## 👨‍💻 Equipo de Desarrollo

| Nombre | Rol | GitHub | Correo Institucional |
|--------|-----|--------|----------------------|
| **Cristofer Ordoñez** | Líder / Experto técnico | [@cristoferOrdonez](https://github.com/cristoferOrdonez) | crordonezo@unal.edu.co |
| **Farid Ardila** | Coordinador / Observador de calidad | [@faridardila](https://github.com/faridardila) | deardilah@unal.edu.co |
| **Diego Arévalo** | Técnico / Investigador de interfaz | [@DiegoArevaloArias](https://github.com/DiegoArevaloArias) | darevaloa@unal.edu.co |
| **Ángel Beltrán** | Animador / Documentador | [@anbeld12](https://github.com/anbeld12) | anbeltrang@unal.edu.co |

Cada rol fue definido desde el inicio del proyecto para garantizar división clara del trabajo, retroalimentación constante y compromiso individual.

---

## 🎓 Lecciones Aprendidas

El desarrollo de Bocu fue más que técnico; representó una **experiencia integral de ingeniería, gestión y sensibilidad social**:

- 🛠️ **El análisis asintótico sí importa**: aplicar teoría de estructuras de datos en un entorno real nos permitió optimizar con fundamentos sólidos.
- 🤝 **GitHub como pilar de trabajo colaborativo**: su uso constante permitió evitar conflictos, mantener versiones limpias y fomentar trabajo en paralelo.
- 🔍 **Las pruebas no son un cierre, son una brújula**: iterar sobre errores y tiempos nos dio claridad y dirección.
- 👥 **Roles definidos = productividad real**: evitamos duplicidad y desorganización, mejorando la eficiencia del grupo.
- 💡 **Tecnología con empatía**: traducir un problema cultural en una solución digital nos permitió hacer ingeniería centrada en las personas.

> Este proyecto nos permitió crecer como desarrolladores, como pensadores críticos y como ciudadanos comprometidos con el arte y la cultura.

---

¡Gracias por tu interés en Bocu, un puente entre la tecnología y la riqueza cultural de Bogotá! 🌆✨
