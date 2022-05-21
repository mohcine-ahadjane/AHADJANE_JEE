package ma.enset.ecommerce.service;

import ma.enset.ecommerce.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO save(ProductDTO productDTO);

    List<ProductDTO> listProducts();
    ProductDTO getProduit(String id);
    ProductDTO updateProduct(ProductDTO productDTO);
    void deleteProduct(String id);
}
