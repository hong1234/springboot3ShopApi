package com.hong.demo.rest.shop.service;

import java.util.UUID;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hong.demo.rest.shop.domain.Product;
import com.hong.demo.rest.shop.domain.Category;
import com.hong.demo.rest.shop.domain.CategoryEntity;
import com.hong.demo.rest.shop.repository.CategoryRepository;

// import com.hong.demo.rest.shop.domain.*;
// import com.hong.demo.rest.shop.repository.*;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    
    public Category getCategory(String categoryId) throws ServiceException {
        CategoryEntity category = categoryRepository.findById(UUID.fromString(categoryId)).get(); 
        return new Category(
            category.getId().toString(), 
            category.getTitle(),
            category.getProducts().stream().map(
                prod -> new Product(
                    prod.getId().toString(), 
                    prod.getTitle(),
                    prod.getAutor(),
                    prod.getImage(),
                    prod.getUnitPrice()
                )
            ).toList() 
        );
    }

}
