package hack.code.store;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "t_delivery_order")
public class DeliveryOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "c_status")
    OrderStatus deliveryStatus;

    @Column(name = "c_status_changed_at")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    ZonedDateTime statusChangedAt;

    @Column(name = "c_location")
    String location;

    @ManyToMany
    @JoinTable(
            name = "t_order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    List<ProductEntity> productsToBeDelivered;

    @ManyToOne
    @JoinColumn(name = "transport_company_id")
    TransportCompanyEntity transportCompany;

    @ManyToOne
    @JoinColumn(name = "destination_company_id")
    DestinationCompanyEntity destinationCompanies;
}
