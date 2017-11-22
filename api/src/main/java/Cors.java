import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan
public class Cors extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**/*").allowedOrigins("http://mocker.egen.io")
                .allowedMethods("PUT", "GET","DELETE","POST")
                .allowedHeaders("accepts","Origin",
                        "Access-Control-Request-Method","Access-Control-Request-Method")
                .allowCredentials(false).maxAge(3600);
    }
}
