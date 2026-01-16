package com.hong.demo.rest.shop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseStatus;
// import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

// import com.hong.demo.rest.shop.domain.CategoryEntity;
// import com.hong.demo.rest.shop.domain.ProductEntity;
// import com.hong.demo.rest.shop.domain.Product;
import com.hong.demo.rest.shop.domain.*;

// import com.hong.demo.rest.shop.service.BookService;
// import com.hong.demo.rest.shop.service.ServiceException; 
import com.hong.demo.rest.shop.service.*;


@RestController
@RequestMapping("/api/v1/products")
public class ProductController { 

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> searchBooksByTitle(@RequestParam String title) throws ServiceException {  
        return productService.searchByTitle(title);
    }

    @GetMapping
    public List<Product> getAllProducts() throws ServiceException {
        return productService.getAllProducts();
    }

    @GetMapping("/{productId}")
    public Product getBook(@PathVariable String productId) throws ServiceException {
        return productService.getProduct(productId);
    }
}

