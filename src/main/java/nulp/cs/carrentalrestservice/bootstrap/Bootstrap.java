package nulp.cs.carrentalrestservice.bootstrap;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nulp.cs.carrentalrestservice.entity.*;
import nulp.cs.carrentalrestservice.model.CarClass;
import nulp.cs.carrentalrestservice.model.Status;
import nulp.cs.carrentalrestservice.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class Bootstrap implements CommandLineRunner {
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;

    private final AdminRepository adminRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final CarOrderRepository carOrderRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        createCars();
        createAdmin();
        createCustomer();
        createOrderDetail();
        createOrder();
    }

    private void createOrder() {
        if (carOrderRepository.count()==0) {
            carOrderRepository.saveAndFlush(
                    CarOrder.builder()
                            .status(Status.IN_USE)
                            .orderDetail(orderDetailRepository.findAll().get(0))
                            .admin(adminRepository.findAll().get(0))
                            .adminComment("Comment")
                            .build()
            );

        }
    }

    private void createOrderDetail() {
        if (orderDetailRepository.count()==0) {
            OrderDetail orderDetail = OrderDetail.builder()
                    .id(Long.valueOf(123))
                    .numberOfDays(1)
                    .pickUpDate(LocalDate.now())
                    .pickUpLocation("Lviv")
                    .dropOffDate(LocalDate.now())
                    .dropOffLocation("Lviv")
                    .totalPrice(123.2)
                    .customer(customerRepository.findAll().get(0))
                    .car(carRepository.findAll().get(0))
                    .build();
            orderDetailRepository.saveAndFlush(orderDetail);
        }



    }

    private void createCars () {
        if (carRepository.count()==0) {
            carRepository.saveAndFlush(
                    Car.builder()
                            .carClass(CarClass.BUSINESS)
                            .brand("BMW")
                            .isAvailable(true)
                            .pricePerDay(100.0)
                            .model("X5")
                            .build()
            );

//            carRepository.saveAndFlush(
//                    Car.builder()
//                            .carClass(CarClass.COMFORT)
//                            .brand("SKODA")
//                            .isAvailable(false)
//                            .pricePerDay(100.0)
//                            .model("Oktavia A7")
//                            .build()
//            );

        }

    }

    private void createCustomer () {
        if (customerRepository.count()==0) {
            customerRepository.saveAndFlush(
                    Customer.builder()
                            .birthDate(LocalDate.now())
                            .expiryDate(LocalDate.now())
                            .firstName("FirstName")
                            .lastName("LastName")
                            .sureName("SureName")
                            .passportId("12345678")
                            .build()
            );
        }
    }

    private void createAdmin () {
        if (adminRepository.count()==0) {
            adminRepository.saveAndFlush(
                    Admin.builder()
                            .password("password")
                            .firstName("FirstName")
                            .lastName("LastName")
                            .build()
            );
        }
    }

}
