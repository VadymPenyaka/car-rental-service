package nulp.cs.carrentalrestservice.repository;

import nulp.cs.carrentalrestservice.entity.CarOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarOrderRepository extends JpaRepository<CarOrder, Long> {
}
