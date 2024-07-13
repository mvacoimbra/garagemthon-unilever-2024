package hack.code.api.service.impl;

import hack.code.store.ProductEntity;
import hack.code.api.service.ProductService;
import hack.code.store.repositury.ProductEntityRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {

    ProductEntityRepository productRepository;

    @Override
    @Transactional
    public ProductEntity createProduct(@RequestBody ProductEntity product) {

        ProductEntity newProduct = ProductEntity
                .builder()
                .name(product.getName())
                .price(product.getPrice())
                .build();

        productRepository.saveAndFlush(newProduct);
        return newProduct;
    }

    @Override
    public List<ProductEntity> getAllProducts() {

        return productRepository.findAll();
    }

    @Override
    public Optional<ProductEntity> getProductById(@PathVariable(name = "productId") Long id) {

        Optional<ProductEntity> product = productRepository.findById(id);
        return product;
    }

    @Override
    @Transactional
    public ProductEntity updateProduct(@PathVariable(name = "productId") Long id,
                                       @RequestBody ProductEntity product) {

        ProductEntity productToBeUpdated = productRepository.findById(id).orElseThrow();

        productToBeUpdated.setName(product.getName());
        productToBeUpdated.setPrice(product.getPrice());

        productRepository.saveAndFlush(productToBeUpdated);
        return productToBeUpdated;
    }

    @Override
    @Transactional
    public String deleteProduct(@PathVariable(name = "productId") Long id) {

        ProductEntity productToBeDeleted = productRepository.findById(id).orElseThrow();

        productRepository.deleteById(id);

        return "Product was deleted";
    }
}
