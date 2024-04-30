package nulp.cs.carrentalrestservice.controller;

import nulp.cs.carrentalrestservice.entity.CarOrder;
import nulp.cs.carrentalrestservice.mapper.CarOrderMapper;
import nulp.cs.carrentalrestservice.model.CarOrderDTO;
import nulp.cs.carrentalrestservice.repository.CarOrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CarOrderControllerIT {
    @Autowired
    private CarOrderController controller;

    @Autowired
    private CarOrderMapper carOrderMapper;

    @Autowired
    private CarOrderRepository carOrderRepository;


    @Test
    void createCarOrder() {
        CarOrderDTO carOrderDTOToSave = carOrderMapper
                .carOrderToCarOrderDto(carOrderRepository.findAll().get(0));

        ResponseEntity responseEntity = controller.createCarOrder(carOrderDTOToSave);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        assertThat(carOrderRepository.findById(carOrderDTOToSave.getId())).isNotNull();
    }

    @Test
    void getCarOrderById() {
        CarOrder expected = carOrderRepository.findAll().get(0);
        CarOrderDTO expectedDTO = carOrderMapper.carOrderToCarOrderDto(expected);

        CarOrderDTO actual = controller.getCarOrderById(expected.getId());

        assertThat(actual).isEqualTo(expectedDTO);
    }
}