package hack.code.api.controller;

import hack.code.api.service.DeliveryOrderService;
import hack.code.store.DeliveryOrderEntity;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("api/v1/delivery")
public class DeliveryOrderController {

    DeliveryOrderService deliveryOrderService;

    @PostMapping()
    public DeliveryOrderEntity createDeliveryOrder(@RequestBody DeliveryOrderEntity deliveryOrder){

        return deliveryOrderService.createDeliveryOrder(deliveryOrder);
    }

    @GetMapping()
    public List<DeliveryOrderEntity> getAllDeliveryOrderList(){

        return deliveryOrderService.getAllDeliveryOrders();
    }

    @GetMapping("/{deliveryOrderId}")
    public Optional<DeliveryOrderEntity> getDeliveryOrderById(@PathVariable(name = "deliveryOrderId") Long id){

        return deliveryOrderService.getDeliveryOrderById(id);
    }

    @PatchMapping("/{deliveryOrderId}")
    public DeliveryOrderEntity updateDeliveryOrderStatusAndLocation(@PathVariable(name = "deliveryOrderId") Long id,
                                                                    String newStatus, String location){

        return deliveryOrderService.updateDeliveryOrder(id, newStatus, location);
    }

    @DeleteMapping("/{deliveryOrderId}")
    public String deleteDeliveryOrder (@PathVariable(name = "deliveryOrderId") Long id){

        return deliveryOrderService.deleteDeliveryOrder(id);
    }
}
