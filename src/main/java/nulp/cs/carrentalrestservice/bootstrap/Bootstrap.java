package nulp.cs.carrentalrestservice.bootstrap;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import nulp.cs.carrentalrestservice.entity.Admin;
import nulp.cs.carrentalrestservice.entity.Car;
import nulp.cs.carrentalrestservice.entity.Customer;
import nulp.cs.carrentalrestservice.entity.OrderDetail;
import nulp.cs.carrentalrestservice.model.CarClass;
import nulp.cs.carrentalrestservice.repository.AdminRepository;
import nulp.cs.carrentalrestservice.repository.CarRepository;
import nulp.cs.carrentalrestservice.repository.CustomerRepository;
import nulp.cs.carrentalrestservice.repository.OrderDetailRepository;
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

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        createCars();
        createAdmin();
        createCustomer();
        createOrderDetail();
    }

    private void createOrderDetail() {
        System.out.println(carRepository.findAll().get(0).toString());
        OrderDetail orderDetail = OrderDetail.builder()
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

    private void createCars () {
//        checkIfEmptyOrDelete(carRepository);
        carRepository.saveAndFlush(
                Car.builder()
                        .carClass(CarClass.BUSINESS)
                        .brand("BMW")
                        .isAvailable(true)
                        .pricePerDay(100.0)
                        .model("X5")
                        .build()
        );

    }

    private void createCustomer () {
//        checkIfEmptyOrDelete(customerRepository);
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

    private void createAdmin () {
//        checkIfEmptyOrDelete(adminRepository);
        adminRepository.saveAndFlush(
                Admin.builder()
                        .password("password")
                        .firstName("FirstName")
                        .lastName("LastName")
                        .build()
        );
    }



    private boolean checkIfEmptyOrDelete (JpaRepository jpaRepository) {
        if (jpaRepository.count()==0)
            return true;
        else {
            jpaRepository.deleteAll();
            return false;
        }
    }
}
