package br.com.generation.projeto.ateliedigital.swaggerready;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig  {

    @Bean
    public Docket AteliedigitalApplication() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.generation.projeto.ateliedigital"))
                .paths(regex("/api/v1/.*"))
                .build()
                .apiInfo(metaData());
    }
    private ApiInfo metaData() {
        ApiInfo apiInfo = new ApiInfo(
                "Spring Boot REST API",
                "API para o app fictício Gfood, criada durante o curso de programação web full stack em Java do programa Generation Brasil. Desenvolvida por: Rodrigo Gregoldo (github.com/rdrggrgld).",
                "1.0",
                "Terms of service",
                new Contact("Rodrigo Gregoldo", "https://github.com/rdrggrgld", "rodrigogregoldo@gmail.com").toString(),
                "Apache License Version 2.0",
                "https://www.apache.org/licenses/LICENSE-2.0");
        return apiInfo;
    }


}
