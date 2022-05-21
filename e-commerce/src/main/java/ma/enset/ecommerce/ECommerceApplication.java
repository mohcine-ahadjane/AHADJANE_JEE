package ma.enset.ecommerce;

import ma.enset.ecommerce.entities.Category;
import ma.enset.ecommerce.entities.Product;
import ma.enset.ecommerce.repositories.CategoryRepository;
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
    public CommandLineRunner start(ProductRepository productRepository, CategoryRepository categoryRepository){
        return args -> {
            Stream.of("Computers", "Printers", "smart Phones").forEach(name->{
                Category category=new Category();
                category.setName(name);
                categoryRepository.save(category);
            });
            categoryRepository.findAll().forEach(cat->{
                for (int i=0 ; i<=5 ; i++){
                    Product product=new Product();
                    product.setId(UUID.randomUUID().toString());
                    product.setPrice(100+Math.random()*10000);
                    product.setQuantity(1+Math.random()*50);
                    product.setName(cat.getName()+"-"+i);
                    product.setCategory(cat);
                    productRepository.save(product);
                }
            });
        };
    }

}
