package hack.code.store;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "t_transport_company")
public class TransportCompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "c_name")
    String name;

    @Column(name = "c_some_info")
    String someInfo;

    @OneToMany(mappedBy = "transportCompany")
    List<DeliveryOrderEntity> deliveryOrders;
}
