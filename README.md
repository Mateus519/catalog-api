#  Proyecto: Catálogo Persistente de Eventos y Venues (API con Spring Boot + JPA)

### **Módulo 6 – Semana 2 | Persistencia, Validación, Relaciones y Paginación**

Este proyecto consiste en una API REST construida con **Spring Boot 3** y **Java 17**, diseñada para gestionar un catálogo de **eventos** y **venues (lugares)** utilizando:

- Persistencia real con **H2**  
- **JPA/Hibernate**  
- **Validaciones** con Jakarta Validation  
- **Relaciones 1:N**  
- **Paginación y filtros**  
- **DTOs**  
- Manejo global de errores  
- Documentación automática en **Swagger UI**

---

# ¿Qué hace este proyecto?

Representa la estructura inicial de una **tiquetera digital real**.

Con esta API puedes:

## Venues
- Crear un venue  
- Listar venues  
- Consultar venue por ID  
- Eliminar venue  
- Validar campos (nombre, ciudad, capacidad, etc.)

## Eventos
- Crear un evento asociado a un venue  
- Listar eventos con paginación  
- Filtrar eventos por:
  - ciudad  
  - categoría  
  - fecha de inicio  
- Consultar evento por ID  
- Eliminar evento  
- Validar fechas, categoría, nombre único  

---

# Tecnologías y herramientas utilizadas

- Java 17  
- Spring Boot 3.3.x  
- Spring Data JPA (Hibernate)  
- H2 Database (en memoria)  
- Jakarta Validation  
- Swagger / Springdoc OpenAPI  
- Maven  
- Lombok  
- Arquitectura por capas  

---

# Arquitectura por capas

/controller → Endpoints y manejo HTTP
/service → Lógica de negocio
/repository → Acceso a datos con JPA
/domain/entity → Entidades del modelo
/dto → DTOs (Request/Response)
/exception → Manejo global de errores

---

#  Base de datos (H2)

Tablas generadas por JPA:

- `venues`
- `events`

Registros iniciales desde:

src/main/resources/data.sql


Acceso a consola H2:

 **http://localhost:8081/h2-console**

- JDBC URL: `jdbc:h2:mem:eventsdb`
- User: `sa`

---

# Cómo ejecutar este proyecto

## 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/events-api-hu-modulo6.git
cd events-api-hu-modulo6
```

## 2. Ejecutar 
```bash
mvn clean spring-boot:run
```
## 3. Abrir Swagger UI
http://localhost:8081/swagger-ui.html
