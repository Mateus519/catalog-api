# EventManager API – Semana 4 (Arquitectura Hexagonal + Docker + Postgres + Flyway + Spring Boot)

Este proyecto corresponde a la **Semana 4 del Módulo 6**, donde se implementa una API profesional utilizando:

- **Java 17**
- **Spring Boot 3**
- **Arquitectura Hexagonal (Ports & Adapters)**
- **Persistencia real con Postgres**
- **Opción de ejecutar con H2 para desarrollo rápido**
- **Docker Compose (App + Postgres)**
- **Flyway para migraciones**
- **Relación 1:N entre Venues y Events**
- **JPA + Hibernate**
- **MapStruct para mapeos**
- **Filtros por fecha y venue (Specifications)**

## 📁 Estructura del Proyecto (Hexagonal)

```
src/main/java/com/events/eventManager/
│
├── application/
│   └── usecases/         
│       └── events/
│
├── domain/
│   ├── model/
│   └── ports/
│       └── out/
│
├── infrastructure/
│   ├── adapters/
│   ├── entities/
│   ├── mappers/
│   ├── persistence/
│   └── web/
│
└── EventManagerApplication.java
```

## 🛠 Tecnologías Utilizadas

| Capa | Tecnología |
|------|------------|
| Framework | Spring Boot 3 |
| Dominio | Arquitectura Hexagonal |
| Persistencia | JPA / Hibernate |
| BD | PostgreSQL 15 vía Docker |
| Migraciones | Flyway |
| Contenedores | Docker Compose |
| Mapeos | MapStruct |

## 🚀 Ejecución del Proyecto

### 🔥 1. Ejecutar con Docker Compose

### `.env` necesario:

```env
SPRING_PROFILES_ACTIVE=dev
SERVER_PORT=8080

APP_NAME=eventManager

DB_HOST=postgres
DB_PORT=5432
DB_NAME=event_manager
DB_USER=postgres
DB_PASSWORD=tu_password

SPRING_JPA_HIBERNATE_DDL_AUTO=none
SPRING_JPA_SHOW_SQL=true
SPRING_JPA_PROPERTIES_HIBERNATE_FORMAT_SQL=true
```

### Levantar contenedores:

```bash
docker compose up -d --build
```

### 🧪 2. Ejecutar localmente

```bash
mvn spring-boot:run
```

### 🧰 H2 (modo rápido)

```
jdbc:h2:mem:event_manager_db
```

## 📚 Endpoints

### Venues
```
GET /api/v1/venue
POST /api/v1/venue
```

### Events
```
GET /api/v1/event
POST /api/v1/event
GET /api/v1/event/search?venueId=1
GET /api/v1/event/search?startDate=...&endDate=...
```

## 🧬 Migraciones Flyway

- `V1__init_schema.sql`  
- `V2__relations_and_indexes.sql`  
- `V3__constraints_unique.sql`  

## 🧩 Arquitectura Hexagonal

- Puertos → domain/ports  
- Adaptadores → infrastructure/adapters  
- Casos de uso → application/usecases  
- Entidades → domain/model  

## 🧼 Comandos Docker útiles

```bash
docker ps
docker stop eventManager postgres-db
docker rm -f eventManager postgres-db
docker logs eventManager -f
```

## 📝 Autor

Proyecto desarrollado por **Mateo** – Módulo 6 Semana 4.
