# 🎨 Bocu - Bogotá Cultural 🇨🇴🏙️

**Aplicación Android para visibilizar artistas emergentes y eventos culturales en Bogotá.**

> “La Atenas de Sudamérica merece ser redescubierta.”

---

## 📚 Tabla de Contenidos

1. [Descripción del Proyecto](#-descripción-del-proyecto)
2. [Objetivos](#-objetivos)
3. [Tipos de Usuario](#-tipos-de-usuario)
4. [Funcionalidades](#-funcionalidades-principales)
5. [Tecnologías Utilizadas](#-tecnologías-utilizadas)
6. [Implementación Técnica](#-implementación-técnica)
7. [Pruebas de Rendimiento](#-pruebas-de-rendimiento)
8. [Capturas y Prototipos](#-capturas-y-prototipos)
9. [Equipo de Desarrollo](#-equipo-de-desarrollo)
10. [Lecciones Aprendidas](#-lecciones-aprendidas)

---

## 📱 Descripción del Proyecto

**Bocu** (Bogotá Cultural) es una aplicación móvil desarrollada como iniciativa académica que busca resolver una problemática real: la invisibilidad de los artistas emergentes frente a la saturación del contenido en internet. En una ciudad tan culturalmente rica como Bogotá, muchos creadores no cuentan con los recursos para publicitarse.

La app permite a usuarios buscar, guardar y filtrar eventos culturales según sus preferencias, y brinda a los artistas una herramienta para difundir sus actividades, conectarse con el público y contribuir a la reactivación del panorama artístico de la ciudad.

---

## 🎯 Objetivos

- **Visibilizar artistas emergentes** que no tienen acceso a canales de difusión tradicionales.
- **Centralizar la oferta cultural** de Bogotá, promoviendo el acceso democrático al arte.
- **Personalizar la experiencia cultural** para cada usuario según sus intereses.
- **Incentivar la participación ciudadana** en actividades culturales locales.

---

## 👥 Tipos de Usuario

| Tipo de Usuario | Descripción |
|-----------------|-------------|
| **Invitado** | Navega por la app, explora eventos y accede a funciones básicas. |
| **Usuario Registrado** | Personaliza su perfil, guarda eventos favoritos, aplica filtros y ve sugerencias según sus intereses. |
| **Expositor / Artista** | Crea, edita y publica eventos; administra su portafolio de actividades en la ciudad. |

---

## 🔧 Funcionalidades Principales

- 🔐 **Inicio de sesión y registro de usuarios** (individuales y artistas).
- 🧭 **Navegación personalizada** en la página principal.
- 📌 **Filtrado y ordenamiento de eventos** (por fecha, tipo, costo, etc.).
- ⭐ **Favoritos:** Guarda eventos relevantes para el usuario.
- ➕ **Creación de eventos** por parte de los artistas.
- 🔄 **Actualización de datos de usuario y eventos.**
- 🧠 **Sugerencias y personalización de contenido** según intereses.
- 📲 **Experiencia intuitiva y adaptable** en dispositivos Android.

---

## 🛠️ Tecnologías Utilizadas

| Herramienta / Lenguaje | Justificación |
|------------------------|----------------|
| **Android Studio**     | IDE especializado para desarrollo móvil Android, permite pruebas en emuladores y dispositivos reales. |
| **Java**               | Lenguaje de programación base, elegido por su robustez, flexibilidad y dominio por parte del equipo. |
| **Git y GitHub**       | Control de versiones colaborativo, gestión eficiente del código y seguimiento del historial de cambios. |
| **Estructuras de Datos Personalizadas** | Implementadas para prácticas de rendimiento y optimización de operaciones como búsquedas, filtrado y almacenamiento. |

> La selección tecnológica se basó tanto en la idoneidad de las herramientas para los objetivos del proyecto como en el dominio técnico del equipo.

---

## 🧠 Implementación Técnica

El proyecto fue desarrollado con un enfoque en eficiencia algorítmica y estructuración clara de roles. Se implementaron las siguientes estructuras de datos:

- **Listas enlazadas:** Para evitar duplicados y manejar usuarios.
- **Listas desordenadas dinámicas:** Para mostrar eventos en tiempo real.
- **Pilas:** Historial de eventos vistos.
- **Montículos (MaxHeap/MinHeap):** Para ordenar eventos según criterios seleccionados.
- **Árboles AVL y BST:** Para búsquedas eficientes en bases de datos locales.
- **Conjuntos disjuntos:** Para organización de relaciones y agrupaciones lógicas.

Cada componente fue probado y analizado en términos de complejidad asintótica y escalabilidad.

---

## 📊 Pruebas de Rendimiento

Se ejecutaron pruebas con datasets de hasta 100 millones de registros. El análisis incluyó:

- Comparación entre estructuras como BST vs AVL (mejor rendimiento: AVL recursivo).
- Evaluación de montículos binarios, ternarios y cuaternarios.
- Uso de estructuras con compresión de ruta y unión por rango en conjuntos disjuntos.
- Medición de eficiencia práctica y teórica (tiempos en nanosegundos, errores de memoria, etc.).

Estas pruebas validaron el diseño estructural y permitieron optimizar el código para dispositivos móviles de gama media.

---

## 📷 Capturas y Prototipos

- 📁 [Entrega 1 - Prototipo Inicial](https://drive.google.com/drive/folders/15_-eG5SVKDk34VKrz7Br3tsFfCbIOmfQ?usp=sharing)
- 📁 [Entrega 2 - Versión Avanzada](https://drive.google.com/drive/folders/1YPkt88uwSq5_T8D8qechMXyEMlKmHK3V?usp=sharing)

---

## 👨‍💻 Equipo de Desarrollo

| Nombre | Rol | GitHub | Correo Institucional |
|--------|-----|--------|----------------------|
| Cristofer Ordoñez | Líder / Experto | [@cristoferOrdonez](https://github.com/cristoferOrdonez) | cristofer.ordonez@correo.udistrital.edu.co |
| Farid Ardila | Coordinador / Observador | [@faridardila](https://github.com/faridardila) | farid.ardila@correo.udistrital.edu.co |
| Diego Arévalo | Técnico / Investigador | - | diego.arevalo@correo.udistrital.edu.co |
| Ángel Beltrán | Animador / Secretario | - | angel.beltran@correo.udistrital.edu.co |

---

## 🎓 Lecciones Aprendidas

Durante el desarrollo del proyecto, el equipo enfrentó múltiples retos técnicos y de coordinación, que generaron aprendizajes significativos:

- **Colaboración efectiva:** GitHub fue fundamental para la sincronización de tareas, control de versiones y trabajo simultáneo, incluso en situaciones de tiempo limitado.
- **Valor del análisis algorítmico:** Evaluar la eficiencia de las estructuras de datos fue clave para evitar cuellos de botella y optimizar el rendimiento en dispositivos móviles, evidenciando la importancia de los fundamentos teóricos en aplicaciones reales.
- **Organización por roles:** La división clara de funciones (líder, técnico, investigador, etc.) permitió enfocar esfuerzos, reducir redundancias y aumentar la productividad.
- **Pruebas como proceso iterativo:** Se aprendió que testear no es un paso final, sino un componente esencial y continuo del desarrollo, especialmente cuando se manejan grandes volúmenes de datos.
- **Empatía hacia el usuario final:** Comprender la problemática cultural de Bogotá y traducirla en funcionalidades prácticas fortaleció nuestra visión de ingeniería centrada en el ser humano.

> Este proyecto no solo fortaleció nuestras habilidades técnicas, sino también nuestras capacidades de gestión, análisis crítico y sensibilidad social frente a problemáticas reales.

---
