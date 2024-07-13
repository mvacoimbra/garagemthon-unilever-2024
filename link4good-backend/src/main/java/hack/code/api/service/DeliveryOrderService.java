package hack.code.api.service;

import hack.code.store.DeliveryOrderEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface DeliveryOrderService {

    DeliveryOrderEntity createDeliveryOrder(@RequestBody DeliveryOrderEntity deliveryOrder);

    List<DeliveryOrderEntity> getAllDeliveryOrders();

    Optional<DeliveryOrderEntity> getDeliveryOrderById(@PathVariable(name = "deliveryOrderId") Long id);

    DeliveryOrderEntity updateDeliveryOrder(@PathVariable(name = "deliveryOrderId") Long id,
                                            String newStatus, String location);

    String deleteDeliveryOrder(@PathVariable(name = "deliveryOrderId") Long id);
}
