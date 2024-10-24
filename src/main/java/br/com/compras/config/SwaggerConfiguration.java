package br.com.compras.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API de Compras", version = "v1"))
public class SwaggerConfiguration {

    @Bean
    public GroupedOpenApi grupoCliente() {
        return GroupedOpenApi.builder()
                .group("clientes")
                .displayName("Clientes")
                .pathsToMatch("/api/srv-compras/v1/cliente/**")
                .build();
    }

    @Bean
    public GroupedOpenApi grupoProduto() {
        return GroupedOpenApi.builder()
                .group("produtos")
                .displayName("Produtos")
                .pathsToMatch("/api/srv-compras/v1/produto/**")
                .build();
    }

    @Bean
    public GroupedOpenApi grupoCompra() {
        return GroupedOpenApi.builder()
                .group("compras")
                .displayName("Compras")
                .pathsToMatch("/api/srv-compras/v1/compra/**")
                .build();
    }
}
