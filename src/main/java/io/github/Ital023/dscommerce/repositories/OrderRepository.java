package io.github.Ital023.dscommerce.repositories;

import io.github.Ital023.dscommerce.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
