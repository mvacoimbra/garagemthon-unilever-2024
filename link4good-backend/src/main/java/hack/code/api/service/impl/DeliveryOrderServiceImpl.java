package hack.code.api.service.impl;

import hack.code.api.service.DeliveryOrderService;
import hack.code.store.*;
import hack.code.store.repositury.DeliveryOrderEntityRepository;
import hack.code.store.repositury.DestinationCompanyEntityRepository;
import hack.code.store.repositury.ProductEntityRepository;
import hack.code.store.repositury.TransportCompanyEntityRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class DeliveryOrderServiceImpl implements DeliveryOrderService {

    DeliveryOrderEntityRepository deliveryOrderEntityRepository;
    ProductEntityRepository productEntityRepository;
    TransportCompanyEntityRepository transportCompanyEntityRepository;
    DestinationCompanyEntityRepository destinationCompanyEntityRepository;
    @Override
    @Transactional
    public DeliveryOrderEntity createDeliveryOrder(@RequestBody DeliveryOrderEntity deliveryOrder) {

        ProductEntity product1 = productEntityRepository.findById(1L).orElseThrow();
        ProductEntity product2 = productEntityRepository.findById(2L).orElseThrow();
        ProductEntity product3 = productEntityRepository.findById(3L).orElseThrow();
        ProductEntity product4 = productEntityRepository.findById(4L).orElseThrow();
        ProductEntity product5 = productEntityRepository.findById(5L).orElseThrow();
        ProductEntity product6 = productEntityRepository.findById(6L).orElseThrow();
        ProductEntity product7 = productEntityRepository.findById(7L).orElseThrow();
        ProductEntity product8 = productEntityRepository.findById(8L).orElseThrow();
        ProductEntity product9 = productEntityRepository.findById(9L).orElseThrow();
        ProductEntity product10 = productEntityRepository.findById(10L).orElseThrow();
        List<ProductEntity> productList = new ArrayList<>(10);

        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        productList.add(product5);
        productList.add(product6);
        productList.add(product7);
        productList.add(product8);
        productList.add(product9);
        productList.add(product10);

        DestinationCompanyEntity destinationCompany = DestinationCompanyEntity
                .builder()
                .name("Destination company name")
                .registrationInfo("Information")
                .build();
        destinationCompanyEntityRepository.saveAndFlush(destinationCompany);


        DeliveryOrderEntity newDeliveryOrder = DeliveryOrderEntity
                .builder()
                .deliveryStatus(OrderStatus.ORDER_RECEIVED)
                .statusChangedAt(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")))
                .location(deliveryOrder.getLocation())
                .productsToBeDelivered(productList)
                .destinationCompanies(destinationCompany)
                .build();

        deliveryOrderEntityRepository.saveAndFlush(newDeliveryOrder);
        return newDeliveryOrder;
    }

    @Override
    public List<DeliveryOrderEntity> getAllDeliveryOrders() {
        return deliveryOrderEntityRepository.findAll();
    }

    @Override
    public Optional<DeliveryOrderEntity> getDeliveryOrderById(@PathVariable(name = "deliveryOrderId") Long id) {
        Optional<DeliveryOrderEntity> deliveryOrder = deliveryOrderEntityRepository.findById(id);

        return deliveryOrder;
    }

    @Override
    @Transactional
    public DeliveryOrderEntity updateDeliveryOrder(@PathVariable(name = "deliveryOrderId") Long id,
                                                   String newStatus, String location) {

        DeliveryOrderEntity deliveryOrderToBeUpdated = deliveryOrderEntityRepository.findById(id).orElseThrow();
        TransportCompanyEntity transportCompany = TransportCompanyEntity
                .builder()
                .name("Transport company name")
                .someInfo("Some info")
                .build();
        transportCompanyEntityRepository.saveAndFlush(transportCompany);


        deliveryOrderToBeUpdated.setDeliveryStatus(OrderStatus.valueOf(newStatus));
        deliveryOrderToBeUpdated.setStatusChangedAt(ZonedDateTime.now(ZoneId.of("America/Sao_Paulo")));
        deliveryOrderToBeUpdated.setLocation(location);
        deliveryOrderToBeUpdated.setTransportCompany(transportCompany);

        deliveryOrderEntityRepository.saveAndFlush(deliveryOrderToBeUpdated);
        return deliveryOrderToBeUpdated;
    }

    @Override
    @Transactional
    public String deleteDeliveryOrder(@PathVariable(name = "deliveryOrderId") Long id) {

        DeliveryOrderEntity order = deliveryOrderEntityRepository.findById(id).orElseThrow();
        deliveryOrderEntityRepository.deleteById(id);

        return "Delivery order was deleted";
    }
}
