package io.dkargo.mongobanjum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@EnableAspectJAutoProxy
//@EnableConfigurationProperties(ApiLogProperties.class)

@SpringBootApplication(scanBasePackages = "io.dkargo.mongobanjum")
public class MongobanjumApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongobanjumApplication.class, args);
    }

}
