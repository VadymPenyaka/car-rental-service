package nulp.cs.carrentalrestservice.service;

import lombok.RequiredArgsConstructor;
import nulp.cs.carrentalrestservice.mapper.CarOrderMapper;
import nulp.cs.carrentalrestservice.model.CarOrderDTO;
import nulp.cs.carrentalrestservice.model.Status;
import nulp.cs.carrentalrestservice.repository.CarOrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class CarOrderServiceImpl implements CarOrderService {
    private final CarOrderRepository carOrderRepository;
    private final CarOrderMapper carOrderMapper;

    @Override
    public CarOrderDTO createCarOrder(CarOrderDTO carOrderDTO) {
        return carOrderMapper.carOrderToCarOrderDto(carOrderRepository
                .save(carOrderMapper.carOrderDtoToCarOrder(carOrderDTO)));
    }

    @Override
    public Optional<CarOrderDTO> getCarOrderByID(Long id) {
        return Optional.ofNullable(carOrderMapper.carOrderToCarOrderDto(carOrderRepository
                .findById(id).orElse(null)));
    }

    @Override
    public boolean deleteCarOrderById(Long id) {
        if (carOrderRepository.existsById(id)) {
            carOrderRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Optional<CarOrderDTO> updateCarOrderById(Long id, CarOrderDTO carOrderDTO) {
        AtomicReference<Optional<CarOrderDTO>> atomicReference = new AtomicReference<>();

        carOrderRepository.findById(id).ifPresentOrElse(foundOrder -> {
            foundOrder.setStatus(carOrderDTO.getStatus());
            foundOrder.setAdminComment(carOrderDTO.getAdminComment());

        }, ()-> atomicReference.set(Optional.empty()));

        return atomicReference.get();
    }

    @Override
    public List<CarOrderDTO> getAllCarOrdersByStatus(Status status) {
        return carOrderRepository.getAllByStatus(status).stream()
                .map(carOrderMapper::carOrderToCarOrderDto).toList();
    }
}
