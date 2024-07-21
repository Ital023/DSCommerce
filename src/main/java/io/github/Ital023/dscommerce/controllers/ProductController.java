package io.github.Ital023.dscommerce.controllers;

import io.github.Ital023.dscommerce.dto.ProductDTO;
import io.github.Ital023.dscommerce.entities.Product;
import io.github.Ital023.dscommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/{id}")
    public ProductDTO findById(@PathVariable Long id) {
       ProductDTO productDTO = productService.findById(id);
       return productDTO;
    }

    @GetMapping
    public Page<ProductDTO> findAll(Pageable pageable) {
        return productService.findAll(pageable);
    }



}
