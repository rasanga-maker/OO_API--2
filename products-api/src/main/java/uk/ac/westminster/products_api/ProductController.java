package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/summaries")
    public List<String> getAllSummaries() {
        return productService.getAllSummaries();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    @PostMapping
    public Product addProduct(@RequestBody DigitalProduct product) {
        // Temporarily accept DigitalProduct because Product is abstract.
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String name) {
        return productService.findByName(name);
    }
}