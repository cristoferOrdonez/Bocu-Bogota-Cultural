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

**Bocu** (Bogotá Cultural) es una aplicación móvil Android que busca visibilizar a artistas emergentes en Bogotá mediante la difusión de sus eventos. Fue desarrollada como proyecto académico con énfasis en estructuras de datos eficientes.

En una ciudad con una historia cultural vibrante, muchos creadores enfrentan barreras para hacerse notar. Bocu funciona como un puente entre estos artistas y el público, incentivando la participación ciudadana y el renacimiento artístico local.

---

## 🎯 Objetivos

- Visibilizar artistas emergentes y sus eventos.
- Centralizar la oferta cultural de Bogotá.
- Personalizar la experiencia del usuario.
- Incentivar la participación en actividades culturales locales.

---

## 👥 Tipos de Usuario

| Tipo de Usuario     | Descripción |
|---------------------|-------------|
| **Invitado**        | Puede explorar eventos y navegar libremente, con funciones limitadas. |
| **Usuario Registrado** | Personaliza su perfil, guarda favoritos, accede a contenido según sus intereses. |
| **Expositor / Artista** | Publica y gestiona eventos culturales, edita y elimina su contenido. |

---

## 🔧 Funcionalidades Principales

- 🔐 Inicio de sesión, registro y autenticación.
- 🧭 Página principal con eventos destacados.
- 🔍 Filtrado y ordenamiento por fecha, costo, tipo.
- ⭐ Sección de favoritos personalizada.
- ➕ Creación, edición y eliminación de eventos (solo artistas).
- 🧠 Recomendaciones basadas en intereses.
- 📂 Historial de eventos vistos.
- 📱 Diseño adaptable y navegación fluida en Android.

---

## 🛠️ Tecnologías Utilizadas

| Tecnología / Herramienta | Uso |
|--------------------------|-----|
| **Android Studio**       | IDE principal para el desarrollo de la app. |
| **Java**                 | Lenguaje principal por su robustez y familiaridad. |
| **Git + GitHub**         | Control de versiones y colaboración. |
| **Dispositivos de prueba** | Huawei Y9 Prime, Samsung A51 y A52. |
| **Estructuras de datos personalizadas** | Eficiencia en búsquedas, almacenamiento y filtrado. |

---

## 🧠 Implementación Técnica

Se emplearon múltiples estructuras para optimizar rendimiento:

- **Listas enlazadas**: gestión de usuarios sin duplicados.
- **Listas desordenadas**: visualización dinámica de eventos.
- **Pilas**: historial de navegación del usuario.
- **Montículos (MaxHeap/MinHeap)**: ordenamiento eficiente de eventos.
- **Árboles BST y AVL**: búsquedas rápidas en bases locales.
- **Conjuntos disjuntos**: relación de elementos y eficiencia en grupos.
- **Tablas Hash**: login eficiente y gestión de favoritos.
- **Grafos**: análisis y conectividad de eventos/artistas.

---

## 📊 Pruebas de Rendimiento

Pruebas aplicadas a datasets de hasta 100 millones de datos para medir:

- Tiempo promedio de búsqueda, inserción y eliminación.
- Comparativas entre implementaciones: AVL vs BST, montículos binarios vs ternarios vs cuaternarios.
- Eficiencia de tablas hash según factor de carga y función hash.
- Costos computacionales en operaciones DFS y BFS en grafos.
- Detección de cuellos de botella y consumo de memoria.

---

## 📷 Capturas y Prototipos

- 📁 [Entrega 1 - Prototipo Inicial](https://drive.google.com/drive/folders/15_-eG5SVKDk34VKrz7Br3tsFfCbIOmfQ?usp=sharing)
- 📁 [Entrega 2 - Versión Avanzada](https://drive.google.com/drive/folders/1YPkt88uwSq5_T8D8qechMXyEMlKmHK3V?usp=sharing)
- 📁 [Entrega 3 - Prototipo Final](https://drive.google.com/file/d/1CXrcB_N0LZRrZZLpJhz1Lfy7FmmObFVN/view?usp=sharing)

---

## 👨‍💻 Equipo de Desarrollo

| Nombre | Rol | GitHub | Correo Institucional |
|--------|-----|--------|----------------------|
| Cristofer Ordoñez | Líder / Experto | [@cristoferOrdonez](https://github.com/cristoferOrdonez) | crordonezo@unal.edu.co |
| Farid Ardila | Coordinador / Observador | [@faridardila](https://github.com/faridardila) | deardilah@unal.edu.co |
| Diego Arévalo | Técnico / Investigador | [@DiegoArevaloArias](https://github.com/DiegoArevaloArias) | darevaloa@unal.edu.co |
| Ángel Beltrán | Animador / Secretario | [@anbeld12](https://github.com/anbeld12) | anbeltrang@unal.edu.co |

---

## 🎓 Lecciones Aprendidas

- 🔁 **Iteración como filosofía**: las pruebas y refactorización fueron continuas, no finales.
- 🧮 **Algoritmos y estructuras importan**: entender complejidades nos permitió adaptarnos a dispositivos limitados.
- 🤝 **Trabajo en equipo distribuido**: roles claros evitaron redundancias y mejoraron la gestión del tiempo.
- 🧠 **Análisis crítico**: cada implementación fue medida, probada y justificada.
- 👥 **Empatía con el usuario final**: el diseño funcional siempre estuvo alineado con la experiencia cultural del ciudadano bogotano.

---

¡Gracias por explorar este proyecto que mezcla tecnología, cultura y comunidad! 🌆✨
