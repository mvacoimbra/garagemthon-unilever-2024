package hack.code.api.service;

import hack.code.store.ProductEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {

    ProductEntity createProduct(@RequestBody ProductEntity product);

    List<ProductEntity> getAllProducts();

    Optional<ProductEntity> getProductById(@PathVariable(name = "productId") Long id);

    ProductEntity updateProduct(@PathVariable(name = "productId") Long id,
                                @RequestBody ProductEntity product);

    String deleteProduct(@PathVariable(name = "productId") Long id);
}