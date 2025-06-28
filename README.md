# 🎨 Bocu - Bogotá Cultural :colombia:🏙️

**Repositorio oficial del proyecto Bocu, una plataforma móvil que visibiliza eventos culturales y artistas emergentes en Bogotá.**

> “La Atenas de Sudamérica merece ser redescubierta.”

---

## 📱 Descripción del Proyecto

Bocu (Bogotá Cultural) es una aplicación móvil desarrollada en Android Studio con Java, que tiene como propósito brindar visibilidad a artistas jóvenes y emergentes mediante la difusión de eventos culturales en la ciudad de Bogotá. La aplicación permite a usuarios navegar, filtrar, crear y guardar eventos, así como personalizar su experiencia según sus intereses artísticos.

---

## 🎯 Objetivos

- Fomentar la participación cultural en Bogotá.
- Brindar a artistas sin respaldo económico un canal de difusión.
- Centralizar la información cultural de la ciudad para los ciudadanos.

---

## 👥 Tipos de Usuario

- **Invitado:** Puede navegar, consultar y filtrar eventos sin necesidad de registrarse.
- **Usuario Registrado:** Tiene un perfil personalizado, puede guardar favoritos, aplicar filtros y ordenar eventos.
- **Expositor (Artista):** Además de las funcionalidades anteriores, puede crear, editar y eliminar sus propios eventos.

---

## 🔧 Funcionalidades Principales

| Funcionalidad              | Descripción |
|---------------------------|-------------|
| 🔐 Inicio de sesión       | Acceso seguro con validación de datos. |
| 📝 Registro de cuenta     | Registro como usuario común o artista. |
| 👤 Perfil de usuario       | Vista editable con información personal. |
| 📅 Página principal       | Visualización de eventos más próximos. |
| 🗂️ Categorías de eventos | Filtrado por tipo de evento. |
| 🧠 Sistema de filtros      | Por nombre, costo, fecha, etc. |
| ⭐ Favoritos              | Guarda eventos preferidos. |
| ➕ Crear evento (artista) | Formulario para publicar actividades. |
| 🔄 Ordenamiento           | A-Z, costo y fecha. |

---

## 🧠 Implementación Técnica

El desarrollo contempla una arquitectura modular con uso extensivo de estructuras de datos personalizadas para eficiencia y escalabilidad:

### 🔗 Estructuras de Datos

- **Listas enlazadas** para administración de usuarios.
- **Pilas y colas** para historial de navegación y eventos.
- **Montículos** (heap) para ordenar eventos según criterios.
- **Árboles BST / AVL** para búsquedas eficientes.
- **Conjuntos disjuntos** para agrupar datos relacionados.
- **Arreglos dinámicos y estáticos** según uso y rendimiento.

---

## 📊 Pruebas de Rendimiento

Se realizaron pruebas con hasta 100 millones de datos para evaluar eficiencia asintótica de las estructuras lineales y no lineales implementadas. Los análisis comparativos revelan:

- AVL (recursivo) supera al BST en inserción, búsqueda y eliminación.
- Unión por rango + compresión de ruta es la mejor estrategia para conjuntos disjuntos.
- Montículos ternarios y cuaternarios presentan mejor rendimiento práctico que binarios en inserción y eliminación.

---

## 📷 Capturas y Prototipos

🔗 [Entrega 1 - Prototipo Inicial](https://drive.google.com/drive/folders/15_-eG5SVKDk34VKrz7Br3tsFfCbIOmfQ?usp=sharing)

🔗 [Entrega 2 - Versión Avanzada](https://drive.google.com/drive/folders/1YPkt88uwSq5_T8D8qechMXyEMlKmHK3V?usp=sharing)

---

## 💻 Entorno de Desarrollo

- **IDE:** Android Studio
- **Lenguaje:** Java
- **Sistema operativo objetivo:** Android
- **Dispositivos de prueba:** Huawei Y9 Prime 2019, Samsung Galaxy A52 y A51
- **Control de versiones:** GitHub

---

## 👨‍💻 Equipo de Desarrollo

| Nombre | Rol | Aportes |
|--------|-----|---------|
| Cristofer Ordoñez | Líder / Experto | Dirección del proyecto, planteamiento del problema, diseño del prototipo inicial |
| Farid Ardila | Coordinador / Observador | Requerimientos funcionales, entorno de desarrollo |
| Diego Arévalo | Técnico / Investigador | Interfaz gráfica, usuarios |
| Ángel Beltrán | Animador / Secretario | Implementación de estructuras de datos, pruebas |

---

## 📚 Lecciones Aprendidas

- La distribución de roles fue clave para el desarrollo exitoso.
- El análisis de complejidad permitió optimizar estructuras y algoritmos.
- La colaboración continua en GitHub mejoró el flujo de trabajo.
- Android Studio y Java ofrecieron estabilidad y flexibilidad.

---

## 📌 Repositorio

[🔗 GitHub - Bocu: Bogotá Cultural](https://github.com/cristoferOrdonez/Bocu-Bogota-Cultural)

---

## 📜 Licencia

Este proyecto se encuentra bajo la Licencia MIT. Consulta el archivo [LICENSE](./LICENSE) para más detalles.

---

