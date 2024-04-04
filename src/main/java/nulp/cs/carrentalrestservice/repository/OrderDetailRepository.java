package nulp.cs.carrentalrestservice.repository;

import nulp.cs.carrentalrestservice.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

}
