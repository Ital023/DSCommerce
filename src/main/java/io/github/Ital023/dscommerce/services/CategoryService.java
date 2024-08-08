package io.github.Ital023.dscommerce.services;


import io.github.Ital023.dscommerce.dto.CategoryDTO;
import io.github.Ital023.dscommerce.dto.ProductMinDTO;
import io.github.Ital023.dscommerce.entities.Category;
import io.github.Ital023.dscommerce.entities.Product;
import io.github.Ital023.dscommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll(){
        List<Category> result = categoryRepository.findAll();

        return result.stream().map(x -> new CategoryDTO(x)).toList();
    }




}
