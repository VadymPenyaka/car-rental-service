package nulp.cs.carrentalrestservice.controller;

import lombok.RequiredArgsConstructor;
import nulp.cs.carrentalrestservice.Exception.NotFoundException;
import nulp.cs.carrentalrestservice.model.CarOrderDTO;
import nulp.cs.carrentalrestservice.model.Status;
import nulp.cs.carrentalrestservice.service.CarOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class CarOrderController {
    private final CarOrderService carOrderService;
    private final static String CAR_ORDER_BASE_PATH_V1 = "api/v1/carOrders";

    @PostMapping(CAR_ORDER_BASE_PATH_V1)
    public ResponseEntity createCarOrder (@RequestBody CarOrderDTO carOrderDTO) {
        carOrderService.createCarOrder(carOrderDTO);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(CAR_ORDER_BASE_PATH_V1+"/{id}")
    public CarOrderDTO getCarOrderById (@PathVariable Long id) {
        return carOrderService.getCarOrderByID(id).orElseThrow(NotFoundException::new);
    }

    @DeleteMapping (CAR_ORDER_BASE_PATH_V1+"/{id}")
    public ResponseEntity deleteCarOrderById (@PathVariable Long id) {
        if (!carOrderService.deleteCarOrderById(id))
            throw new NotFoundException();

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PutMapping(CAR_ORDER_BASE_PATH_V1+"/{id}")
    public ResponseEntity updateCarOrderByID (@PathVariable Long id, @RequestBody CarOrderDTO carOrderDTO) {
        if (carOrderService.updateCarOrderById(id, carOrderDTO).isEmpty()) {
            throw new NotFoundException();
        }

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = CAR_ORDER_BASE_PATH_V1, method = RequestMethod.GET)
    public List<CarOrderDTO> getAllCarOrdersByStatus (@RequestParam Status status) {
        return carOrderService.getAllCarOrdersByStatus(status);
    }

//    @GetMapping(CAR_ORDER_BASE_PATH_V1 + "/{adminId}" + "/status") {
//
//    }



}
