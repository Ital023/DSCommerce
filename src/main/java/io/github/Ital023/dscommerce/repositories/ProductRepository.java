package io.github.Ital023.dscommerce.repositories;

import io.github.Ital023.dscommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
