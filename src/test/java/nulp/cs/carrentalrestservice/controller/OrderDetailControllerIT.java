package nulp.cs.carrentalrestservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import nulp.cs.carrentalrestservice.entity.OrderDetail;
import nulp.cs.carrentalrestservice.mapper.OrderDetailMapper;
import nulp.cs.carrentalrestservice.model.OrderDetailDTO;
import nulp.cs.carrentalrestservice.repository.OrderDetailRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class OrderDetailControllerIT {
    @Autowired
    private OrderDetailController orderDetailController;

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    void gerOrderDetailById() {
        OrderDetailDTO expected = orderDetailMapper.orderDetailToOrderDetailDto(orderDetailRepository.findAll().get(0));

        OrderDetailDTO actual = orderDetailController.gerOrderDetailById(expected.getId());

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Rollback
    @Transactional
    void createOrderDetail() {
        OrderDetailDTO orderDetailToCreate = orderDetailMapper.orderDetailToOrderDetailDto(orderDetailRepository.findAll().get(0));

        ResponseEntity responseEntity = orderDetailController.createOrderDetail(orderDetailToCreate);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

    }

    @Test
    @Rollback
    @Transactional
    void updateOrderDetailById() {
        OrderDetail detailToUpdate = orderDetailRepository.findAll().get(0);

        OrderDetailDTO orderDetailUpdated = orderDetailMapper.orderDetailToOrderDetailDto(detailToUpdate);

        final int numberOfDays = -1;
        orderDetailUpdated.setNumberOfDays(numberOfDays);

        ResponseEntity responseEntity = orderDetailController.updateOrderDetailById(orderDetailUpdated, orderDetailUpdated.getId());

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
        assertThat(orderDetailRepository.findAll().get(0).getNumberOfDays()).isEqualTo(numberOfDays);
    }
}