package com.example.hexagonalusers.infraestructura.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiInfo() {
        return new OpenAPI()
                .info(new Info()
                        .title("Hexagonal Users API")
                        .description("Ejemplo de arquitectura hexagonal con Spring Boot, PostgreSQL y Swagger")
                        .version("v1.0.0"))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentación interna")
                        .url("https://example.com/docs"));
    }
}
