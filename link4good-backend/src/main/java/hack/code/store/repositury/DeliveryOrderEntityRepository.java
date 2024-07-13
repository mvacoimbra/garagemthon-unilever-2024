package hack.code.store.repositury;

import hack.code.store.DeliveryOrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryOrderEntityRepository extends JpaRepository<DeliveryOrderEntity, Long> {
}
