package by.digitalchief.library.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(
        title = "Digital Chief Check: Library",
        version = "1.1",
        description = "Simple library CRUD REST",
        contact = @Contact(name = "Maxim Galitskiy")
))
public class OpenApiConfiguration {
}
