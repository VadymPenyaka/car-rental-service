package nulp.cs.carrentalrestservice.repository;

import nulp.cs.carrentalrestservice.entity.Admin;
import nulp.cs.carrentalrestservice.entity.CarOrder;
import nulp.cs.carrentalrestservice.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarOrderRepository extends JpaRepository<CarOrder, Long> {
    List<CarOrder> getAllByStatus (Status status);

    List<CarOrder> getCarOrdersByAdminAndStatus (Admin admin, Status status);
}
