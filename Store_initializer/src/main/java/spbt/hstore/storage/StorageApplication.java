package spbt.hstore.storage;

import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.freemarker.SpringTemplateLoader;

@SpringBootApplication
public class StorageApplication {

    @Bean
    public Configuration freemarkerConfiguration(){
       Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
       configuration.setDefaultEncoding("UTF-8");
       configuration.setTemplateExceptionHandler(TemplateExceptionHandler.DEBUG_HANDLER);
       configuration.setTemplateLoader(
               new SpringTemplateLoader(
                       new ClassRelativeResourceLoader(this.getClass()),"/"));
       return configuration;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(StorageApplication.class, args);
    }

}
