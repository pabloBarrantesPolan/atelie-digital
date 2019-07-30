package br.com.generation.projeto.ateliedigital.swaggerready;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
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
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.generation.brazil.backend"))
                .paths(PathSelectors.any())
                .build().apiInfo(info());
    }

    private ApiInfo info() {
        return new ApiInfoBuilder().title("Projeto Back-End")
                .description("Um projeto para a primeira turma da Generation Brasil.")
                .contact(new Contact("Jorge Ferreira",
                        "www.jorgeferreira.com.br",
                        "contato@jorgeferreira.com.br"))
                .license("MIT License")
                .licenseUrl("https://opensource.org/licenses/MIT")
                .version("0.0.1")
                .build();
    }


}
