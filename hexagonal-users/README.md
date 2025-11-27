# 🛠️ Proyecto: Hexagonal Users API – Arquitectura Hexagonal con Spring Boot

![Java](https://img.shields.io/badge/Java-17-007396?logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.x-6DB33F?logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?logo=apachemaven&logoColor=white)
![Architecture](https://img.shields.io/badge/Architecture-Hexagonal-blueviolet)
![Status](https://img.shields.io/badge/Status-Funcional-brightgreen)
![License](https://img.shields.io/badge/License-Free-blue)

---

## 📌 Semana 3 – Implementación de Arquitectura Hexagonal  
Este proyecto implementa **Arquitectura Hexagonal (Ports & Adapters)** utilizando **Spring Boot 3**, **Java 17**, **JPA/Hibernate**, **MapStruct**, **H2**, validaciones y estructura modular para garantizar un diseño limpio, desacoplado y altamente mantenible.

El objetivo fue **migrar una API clásica por capas** a una arquitectura hexagonal totalmente alineada con buenas prácticas de desarrollo de software.

---

# 🎯 ¿Qué hace este proyecto?

Es una API REST que gestiona **usuarios**, siguiendo los principios de la Arquitectura Hexagonal:

- Dominio totalmente independiente del framework
- Casos de uso claros y reutilizables
- Adaptadores de entrada (REST) desacoplados
- Adaptadores de salida (JPA) intercambiables
- MapStruct para conversión limpia entre entidades/DOM/DTOs
- Validaciones robustas
- Manejo global de errores
- Base de datos H2 para pruebas rápidas
- Listo para escalar a MySQL, PostgreSQL u otro 

---

# 🧱 Arquitectura Hexagonal

La arquitectura está dividida en **3 grandes anillos**:

            ┌───────────────────────────┐
            │    ADAPTERS (IN / OUT)    │
            │   REST, JPA, MAPPERS      │
            └─────────────┬─────────────┘
                          │
                ┌─────────▼─────────┐
                │   APPLICATION      │
                │  (USE CASES)       │
                └─────────┬─────────┘
                          │
                ┌─────────▼─────────┐
                │      DOMAIN        │
                │ ENTIDADES • PORTS  │
                └────────────────────┘

---

# 🗂️ Estructura del proyecto

hexagonal-users/
├── domain/
│ ├── model/ → Entidades del dominio (Usuario)
│ └── ports/
│ ├── in/ → Puertos de entrada (interfaces de casos de uso)
│ └── out/ → Puertos de salida (repositorios abstractos)
│
├── application/
│ ├── usecases/ → Lógica de negocio (casos de uso)
│
├── infrastructure/
│ ├── adapters/
│ │ ├── in/ rest/ → Controladores REST
│ │ └── out/ jpa/ → Adaptador JPA (implementa puertos)
│ ├── config/ → Beans, mappers, settings
│
├── mappers/ → MapStruct DTO ↔ Entidad
├── dto/ → Request & Response objects
├── exception/ → Manejo global de errores
├── resources/
│ ├── application.yml
│ └── data.sql
└── pom.xml

---

# 🧩 Componentes clave

## 🧠 **Dominio**
- Contiene la **entidad Usuario**
- Totalmente libre de frameworks
- Define puertos:
  - `UsuarioRepositoryPort`
  - `UsuarioUseCase`

## 🚀 **Aplicación (Use Cases)**
- Orquesta la lógica de negocio
- No depende de controladores ni infraestructura
- Ejemplo:  
  - `CreateUserUseCase`
  - `GetUserByIdUseCase`
  - `ListUsersUseCase`

## 🌐 **Adaptadores de Entrada (IN)**
- Controladores REST
- Validaciones de request
- Transformación a dominio vía MapStruct

## 🗄️ **Adaptadores de Salida (OUT)**
- Implementación JPA del puerto `UsuarioRepositoryPort`
- Entidad persistente `UsuarioEntity`
- Repositorio con Spring Data JPA

---

# 🔧 Tecnologías utilizadas

- **Java 17**
- **Spring Boot 3**
- **Arquitectura Hexagonal**
- **JPA / Hibernate**
- **MapStruct**
- **H2 Database**
- **Maven**
- **Swagger/OpenAPI**
- **Lombok**
- **Validación con Jakarta Validation**

---

# 🚀 Cómo ejecutar el proyecto

## 1. Clonar el repositorio

```bash
git clone https://github.com/tu-usuario/hexagonal-users.git
cd hexagonal-users
```

## 2. Ejecutar con Maven
```bash
mvn clean spring-boot:run
```
## 3. Abrir Swagger

  **http://localhost:8080/swagger-ui.html**

## 4. H2 Console

  **http://localhost:8080/h2-console**
