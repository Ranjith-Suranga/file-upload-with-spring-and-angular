package lk.ijse.absd.main;

import lk.ijse.absd.util.CustomMutlipartResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.io.IOException;

@ComponentScan("lk.ijse.absd")
@EnableWebMvc
@Configuration
public class WebAppConfig {

    /*
     * First and foremost we need to configure MultipartResolver
     * This time around we are going to use Apache Common File Upload Library
     */
    @Bean
    public MultipartResolver multipartResolver(){
        return new CustomMutlipartResolver();
    }
}
