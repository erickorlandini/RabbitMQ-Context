package erickorlandini.btgpactual.api.listener;

import erickorlandini.btgpactual.api.listener.dto.OrderCreatedEvent;
import erickorlandini.btgpactual.api.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static erickorlandini.btgpactual.api.config.RabbitMqConfig.ORDER_CREATED_QUEUE;

@Component
public class OrderCreatedListener {

  private final Logger logger = LoggerFactory.getLogger(OrderCreatedListener.class);

  private final OrderService orderService;

  public OrderCreatedListener(OrderService orderService) {
    this.orderService = orderService;
  }

  @RabbitListener(queues = ORDER_CREATED_QUEUE)
  public void listen(Message<OrderCreatedEvent> message) {
      logger.info("Message consumed: {}", message);

      orderService.save(message.getPayload());
  }
}
