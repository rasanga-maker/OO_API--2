package uk.ac.westminster.products_api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("/products")
    public class ProductController {

        @GetMapping("/{id}")
        public Product getProduct(@PathVariable Long id) {
            Product p = new Product(id, "ok", 323);
            return p;
        }
    }
