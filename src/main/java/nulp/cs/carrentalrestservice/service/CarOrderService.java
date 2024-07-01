package nulp.cs.carrentalrestservice.service;

import nulp.cs.carrentalrestservice.model.CarOrderDTO;
import nulp.cs.carrentalrestservice.model.Status;

import java.util.List;
import java.util.Optional;

public interface CarOrderService {
    CarOrderDTO createCarOrder (CarOrderDTO carOrderDTO);

    Optional<CarOrderDTO> getCarOrderByID (Long id);

    boolean deleteCarOrderById (Long id);

    Optional<CarOrderDTO> updateCarOrderById(Long id, CarOrderDTO carOrderDTO);

    List<CarOrderDTO> getAllCarOrdersByStatus(Status status);

    List<CarOrderDTO> getCarOrdersByAdminAndStatus (Long adminId, Status status);
}
