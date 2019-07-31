package br.com.generation.projeto.ateliedigital.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.generation.projeto.ateliedigital"))
                .paths(PathSelectors.any())
                .build().apiInfo(info());
    }

    private ApiInfo info() {
        return new ApiInfoBuilder().title("API ateliê digital")
                .description("Projeto integrador.")
                .contact(new Contact("Vanusa Saravalle",
                        "www.jorgeferreira.com.br",
                        "vanusa.sousasaravalle@gmail.com"))
                .license("MIT License")
                .licenseUrl("https://opensource.org/licenses/MIT")
                .version("0.0.1")
                .build();
    }

}
