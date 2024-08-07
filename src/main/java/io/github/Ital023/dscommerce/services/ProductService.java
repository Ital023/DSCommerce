package io.github.Ital023.dscommerce.services;

import io.github.Ital023.dscommerce.dto.ProductDTO;
import io.github.Ital023.dscommerce.dto.ProductMinDTO;
import io.github.Ital023.dscommerce.entities.Product;
import io.github.Ital023.dscommerce.repositories.ProductRepository;
import io.github.Ital023.dscommerce.services.exceptions.DatabaseException;
import io.github.Ital023.dscommerce.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true) // evitar o lock de escrita
    public ProductDTO findById(Long id){
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

        ProductDTO productDTO = new ProductDTO(product);

        return productDTO;
    }

    @Transactional(readOnly = true) // evitar o lock de escrita
    public Page<ProductMinDTO> findAll(String name, Pageable pageable){
        Page<Product> result = productRepository.searchByName(name, pageable);

        return result.map(x -> new ProductMinDTO(x));
    }


    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {
        Product entity = new Product();

        copyDtoToEntity(productDTO, entity);

        entity = productRepository.save(entity);

        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO update(ProductDTO productDTO, Long id) {
        try {
            Product entity = productRepository.getReferenceById(id);

            copyDtoToEntity(productDTO, entity);

            entity = productRepository.save(entity);

            return new ProductDTO(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id){
        if(!productRepository.existsById(id)){
            throw new ResourceNotFoundException("Recurso não encontrado");
        }

        try{
            productRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Falha na integridade referencial");
        }

    }

    private void copyDtoToEntity(ProductDTO productDTO, Product entity) {

        entity.setName(productDTO.getName());
        entity.setDescription(productDTO.getDescription());
        entity.setPrice(productDTO.getPrice());
        entity.setImgUrl(productDTO.getImgUrl());

    }

}
