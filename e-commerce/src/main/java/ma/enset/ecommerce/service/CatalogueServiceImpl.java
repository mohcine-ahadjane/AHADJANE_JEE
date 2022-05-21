package ma.enset.ecommerce.service;

import ma.enset.ecommerce.dtos.ProductDTO;
import ma.enset.ecommerce.entities.Category;
import ma.enset.ecommerce.entities.Product;
import ma.enset.ecommerce.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CatalogueServiceImpl {
    private ProductRepository productRepository;
    public ProductDTO save(ProductDTO productDTO){
        Product product=new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        Category category=new Category();
        category.setId(productDTO.getCategory().getId());
        category.setName(productDTO.getCategory().getName());
        product.setCategory(category);
        Product savedProdduct= productRepository.save(product);
        return savedProdduct;
    }
}
