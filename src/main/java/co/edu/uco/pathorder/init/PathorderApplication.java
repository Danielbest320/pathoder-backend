package co.edu.uco.pathorder.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.uco.pathorder"})
public class PathorderApplication {

    public static void main(String[] args) {
        SpringApplication.run(PathorderApplication.class, args);
    }

}
