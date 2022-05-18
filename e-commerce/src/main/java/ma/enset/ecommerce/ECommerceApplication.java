package ma.enset.ecommerce;

import ma.enset.ecommerce.entities.Product;
import ma.enset.ecommerce.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class ECommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ECommerceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            Stream.of("Computer", "Printer", "smartPhone").forEach(name->{
                productRepository.save(new Product(UUID.randomUUID().toString(), name, Math.random()*10000, Math.random()*100)
                );
            });
        };
    }

}
