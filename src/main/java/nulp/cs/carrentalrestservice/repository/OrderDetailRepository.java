package nulp.cs.carrentalrestservice.repository;

import nulp.cs.carrentalrestservice.entity.Car;
import nulp.cs.carrentalrestservice.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> getAllByCar (Car car);
}
