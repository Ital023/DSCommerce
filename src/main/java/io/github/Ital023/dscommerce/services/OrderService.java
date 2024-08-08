package io.github.Ital023.dscommerce.services;

import io.github.Ital023.dscommerce.dto.OrderDTO;
import io.github.Ital023.dscommerce.dto.OrderItemDTO;
import io.github.Ital023.dscommerce.dto.ProductDTO;
import io.github.Ital023.dscommerce.entities.*;
import io.github.Ital023.dscommerce.repositories.OrderItemRepository;
import io.github.Ital023.dscommerce.repositories.OrderRepository;
import io.github.Ital023.dscommerce.repositories.ProductRepository;
import io.github.Ital023.dscommerce.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Recurso não encontrado"));

        return new OrderDTO(order);
    }


    @Transactional
    public OrderDTO insert(OrderDTO dto) {

        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);

        User user = userService.authenticated();
        order.setClient(user);

        for(OrderItemDTO itemDto : dto.getItems()){
            Product product = productRepository.getReferenceById(itemDto.getProductId());
            OrderItem orderItem = new OrderItem(order, product, itemDto.getQuantity(), product.getPrice());
            order.getItems().add(orderItem);
        }

        orderRepository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return new OrderDTO(order);
    }


}
