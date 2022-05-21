package ma.enset.ecommerce.mappers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import ma.enset.ecommerce.dtos.CategoryDTO;
import ma.enset.ecommerce.dtos.ProductDTO;
import ma.enset.ecommerce.entities.Product;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CatalogLogMappers {
    public ProductDTO fromProduct(Product product){
        ProductDTO productDTO=new ProductDTO();
        BeanUtils.copyProperties(product, productDTO){;
    }
    public CategoryDTO
}
