package com.Tech.quiz.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerUiConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new
                        Info().title("LALGY API").version("1.0.0").description("LALGY"))
                .addSecurityItem(new SecurityRequirement().addList("authentication"))
                .components(new Components().addSecuritySchemes("authentication",
                        new SecurityScheme().name("authentication")
                                .type(SecurityScheme.Type.HTTP).scheme("bearer")));

    }

}
