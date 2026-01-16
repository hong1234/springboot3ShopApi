package com.hong.demo.rest.shop.service;

import java.util.UUID;
import java.util.List;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.hong.demo.rest.shop.domain.Product;
import com.hong.demo.rest.shop.domain.ProductEntity;
import com.hong.demo.rest.shop.repository.ProductRepository;

// import jakarta.persistence.PersistenceContext;
// import jakarta.persistence.EntityManager;
// import org.springframework.transaction.annotation.Transactional;
// import org.springframework.beans.factory.annotation.Autowired;


@RequiredArgsConstructor
// @Transactional
@Service
public class ProductService {

    private final ProductRepository productRepository;

    // public ProductService(ProductRepository productRepository) {
    //     this.productRepository = productRepository;
    // }

    // @Override
    // public Book createBook(Book book) throws ServiceException {
    //     return bookRepository.save(book);
    // }

    public List<Product> searchByTitle(String title) throws ServiceException {
        return productRepository.searchByTitle(title)
            .stream().map(
                prod -> new Product(
                    prod.getId().toString(), 
                    prod.getTitle(),
                    prod.getAutor(),  
                    prod.getImage(),
                    prod.getUnitPrice()
                )
            )
            .toList();
    }

    public List<Product> getAllProducts() throws ServiceException {
        return productRepository.findAll()
            .stream().map(
                prod -> new Product(
                    prod.getId().toString(), 
                    prod.getTitle(),
                    prod.getAutor(),  
                    prod.getImage(),
                    prod.getUnitPrice()
                )
            )
            .toList();
    }

    // @Override
    public Product getProduct(String productId) throws ServiceException {
        ProductEntity prod = getProductById(productId); 
        return new Product(
            prod.getId().toString(), 
            prod.getTitle(),
            prod.getAutor(),
            prod.getImage(),
            prod.getUnitPrice()
        );
    }

    public ProductEntity getProductById(String productId) {
        ProductEntity prod = productRepository.findById(UUID.fromString(productId)).get();
        return prod;
    }

}
