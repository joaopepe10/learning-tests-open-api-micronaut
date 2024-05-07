package joaopepe10.com.github;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.h2.tools.Server;

import java.sql.SQLException;


@OpenAPIDefinition(
        info = @Info(
                title = "election-micronaut-open-api",
                version = "0.0"
        )
)
public class Application {

    public static void main(String[] args) throws SQLException {
        Server.createWebServer().start().getPort();
        Micronaut.run(Application.class, args);
    }
}