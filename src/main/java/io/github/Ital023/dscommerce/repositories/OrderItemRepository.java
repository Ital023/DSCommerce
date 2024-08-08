package io.github.Ital023.dscommerce.repositories;

import io.github.Ital023.dscommerce.entities.Order;
import io.github.Ital023.dscommerce.entities.OrderItem;
import io.github.Ital023.dscommerce.entities.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {
}
