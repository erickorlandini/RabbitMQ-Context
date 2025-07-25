package erickorlandini.btgpactual.api.repository;

import erickorlandini.btgpactual.api.controller.dto.OrderResponse;
import erickorlandini.btgpactual.api.entity.OrderEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OrderEntity, Long> {
  Page<OrderEntity> findAllByCustomerId(Long customerId, PageRequest pageRequest);
}
