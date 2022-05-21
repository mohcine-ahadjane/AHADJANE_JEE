package ma.enset.ecommerce.web;

import ma.enset.ecommerce.dtos.ProductDTO;
import ma.enset.ecommerce.entities.Product;
import ma.enset.ecommerce.repositories.ProductRepository;
import ma.enset.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class productRestController {

    @Autowired
    private ProductService productService;
    @GetMapping( path = "/products")
    public List<ProductDTO> productList(){
        return productService.listProducts();
    }
    @GetMapping(path = "/products/{id}")
    public ProductDTO getProduct(@PathVariable(name = "id") String id){
        return productService.getProduit(id);
    }
    @PostMapping(path = "/products")
    public ProductDTO save(@RequestBody ProductDTO productDTO){
        return productService.save(productDTO);
    }
    @PutMapping("/products/{id}")
    public ProductDTO update(@RequestBody ProductDTO productDTO, @PathVariable String id){
        productDTO.setId(id);
        return productService.save(productDTO);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable String id){
       productService.deleteProduct(id);
    }

}
