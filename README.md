# Proyecto: Catálogo de Eventos y Venues (In-Memory API)

 **Módulo 6 - Semana 1**.  
El objetivo fue crear una **API REST** con **Spring Boot (Java 17)** para manejar un catálogo de **eventos** y **lugares (venues)**, aplicando arquitectura por capas y usando memoria temporal en lugar de base de datos.

---

## ¿De qué trata?
La idea es tener una primera versión del sistema de una tiquetera online.  
Por ahora los datos se guardan solo en memoria (mientras la app está corriendo), pero la estructura ya está lista para conectar una base de datos real más adelante.

Puedo **crear, listar, editar y eliminar** tanto eventos como lugares.  
Además, la API tiene su propia documentación visual en **Swagger UI**, lo que permite probar los endpoints sin usar Postman.

---

## Tecnologías y herramientas
- **Java 17**
- **Spring Boot 3.3.4**
- **Maven**
- **Jakarta Validation (para validar datos)**
- **Swagger / OpenAPI (documentación visual)**

---

## Cómo ejecutarlo

1. Desde la terminal: `mvn clean spring-boot:run`
2. Abres cualquier navegador y vas a la siguiente direccion: `http://localhost:8080/swagger-ui/index.html`
