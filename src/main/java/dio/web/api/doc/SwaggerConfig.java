package dio.web.api.doc;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Title - Rest API")
                        .description("API example of using Spring Boot REST API")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Seu nome")
                                .url("http://www.seusite.com.br")
                                .email("voce@seusite.com.br"))
                        .termsOfService("Term of use: Open Source")
                        .license(new io.swagger.v3.oas.models.info.License().name("License - Your choice")
                                .url("http://www.seusite.com.br")))
                .externalDocs(new ExternalDocumentation()
                        .description("Documentação externa")
                        .url("http://www.seusite.com.br"));
    }
}
