package br.com.compras.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
