package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@RestController
    @RequestMapping("/products")
    public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id){
        return productService.getProductById(id).orElse(null);
    }
    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }
    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable long id){
        productService.deleteProduct(id);
    }

    @GetMapping("/products/search")
    public List<Product>search(@RequestParam String name){
        return productService.findByName(name);
    }
}
