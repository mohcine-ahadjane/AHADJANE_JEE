package ma.enset.ecommerce.web;

import ma.enset.ecommerce.entities.Product;
import ma.enset.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class productRestController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping( path = "/products")
    public List<Product> productList(){
        return productRepository.findAll();
    }
    @GetMapping(path = "/products/{id}")
    public Product getProduct(@PathVariable(name = "id") String id){
        return productRepository.findById(id).get();
    }
    @PostMapping(path = "/products")
    public Product save(@RequestBody Product product){
        product.setId(UUID.randomUUID().toString());
        return productRepository.save(product);
    }
    @PutMapping("/products/{id}")
    public Product update(@RequestBody Product product, @PathVariable String id){
        product.setId(id);
        return productRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable String id){
       productRepository.deleteById(id);
    }

}
