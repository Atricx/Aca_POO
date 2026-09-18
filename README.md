# Proyecto ACA POO

## Información del Estudiante
* Oscar Daniel Mejia Quiñonez 
* Ingeniería de Sistemas
* Programación Orientada a Objetos (POO) 
* Java (JDK 21+) 

---

## 
Este proyecto consiste en una aplicación de consola en **Java** diseñada para gestionar el **inventario de una tienda**. El sistema permite registrar productos generales y especializados, listar la totalidad del inventario en memoria calculando su valor económico acumulado, y realizar búsquedas de productos por código mediante un menú interactivo por consola.

---

## ⚙️ Funciones Principales
1. **Registrar Producto:** Permite ingresar productos en memoria.Ofrece la opción de registrar un **Producto Perecedero** (agregando fecha de vencimiento) o un **Producto Importado** (agregando meses de garantía).
2. **Mostrar Productos:** Recorre la lista dinámica mostrando la información detallada de cada producto y calcula automáticamente el **valor total acumulado del inventario** (`precio * cantidad`).
3. **Buscar Producto por Código:** Busca un producto específico según su código único. Si el código no existe, el sistema gestiona la búsqueda mediante una excepción personalizada sin detener la ejecución del programa [4, 7, 8].
4. **Validación de Entradas:** Captura errores de formato en las entradas del usuario (ej. texto ingresado donde se esperaba un número) utilizando bloques de control de excepciones `try-catch` [7].

---

## 📁 Estructura del Proyecto y Paquetes
El proyecto está organizado en **paquetes** para mantener una arquitectura limpia y separada por responsabilidades [9, 10]:

```text
src/
├── modelo/
│   ├── Producto.java                   # Clase base (Objeto)
│   ├── ProductoPerecedero.java         # Subclase 1 (Herencia / Polimorfismo)
│   ├── ProductoImportado.java          # Subclase 2 (Herencia / Polimorfismo)
│   └── Inventario.java                 # Clase contenedora (Gestión de ArrayList)
├── excepciones/
│   └── ProductoNoEncontradoException.java # Excepción personalizada
└── Main.java                           # Menú por consola e interacción
``` [10]

---

## 🛠️ Conceptos de Programación Orientada a Objetos (POO) Aplicados

* **Clases y Objetos:** Representación del dominio mediante clases abstractas/concretas (`Producto`, `Inventario`) que instancian objetos en memoria [2, 11].
* **Encapsulamiento:** Atributos declarados como `private` en las clases, garantizando el acceso y modificación controlada mediante métodos de acceso *getters* y *setters* [11, 12].
* **Herencia:** La clase base `Producto` extiende sus atributos y comportamientos hacia sus subclases específicas (`ProductoPerecedero` y `ProductoImportado`) mediante la palabra clave `extends`, promoviendo la reutilización de código [13].
* **Polimorfismo:** Sobrescritura de métodos utilizando la anotación `@Override` en las subclases para personalizar la impresión de información de cada tipo de producto (`mostrarInformacion()`) [14].
* **Colecciones Dinámicas (`ArrayList`):** Uso de `ArrayList<Producto>` dentro de la clase contenedora `Inventario` para manejar la adición y recorrido dinámico de objetos en memoria [5].
* **Manejo de Excepciones:**
  * Uso de bloques **`try-catch`** para prevenir fallos por entradas inválidas (`NumberFormatException`) [7].
  * Creación e implementación de una **Excepción Personalizada** (`ProductoNoEncontradoException`) lanzada cuando no se localiza un producto por su código [7, 8].
* **Organización en Paquetes:** Separación de clases en módulos `modelo` y `excepciones` para un diseño estructurado y mantenible [9, 10].

---
