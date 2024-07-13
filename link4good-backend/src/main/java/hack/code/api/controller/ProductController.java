package hack.code.api.controller;

import hack.code.store.ProductEntity;
import hack.code.api.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

    ProductService productService;

    @PostMapping
    public ProductEntity createProduct(@RequestBody ProductEntity product){
        return productService.createProduct(product);
    }

    @GetMapping
    public List<ProductEntity> getAllProductsList(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Optional<ProductEntity> getProductById(@PathVariable("productId") Long id){
        return productService.getProductById(id);
    }

    @PatchMapping("/{productId}")
    public ProductEntity updateProduct(@PathVariable(name = "productId") Long id,
                                       @RequestBody ProductEntity product){
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{productId}")
    public String deleteProduct(@PathVariable(name = "productId") Long id){
        return productService.deleteProduct(id);
    }
}
