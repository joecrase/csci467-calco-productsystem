package csci467.calfco.productsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories("base.package")
//@EntityScan("base.package")
public class ProductsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsystemApplication.class, args);
    }

}
