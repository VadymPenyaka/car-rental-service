package nulp.cs.carrentalrestservice.mapper;

import javax.annotation.processing.Generated;
import nulp.cs.carrentalrestservice.entity.Admin;
import nulp.cs.carrentalrestservice.entity.Car;
import nulp.cs.carrentalrestservice.entity.CarOrder;
import nulp.cs.carrentalrestservice.entity.Customer;
import nulp.cs.carrentalrestservice.entity.OrderDetail;
import nulp.cs.carrentalrestservice.model.AdminDTO;
import nulp.cs.carrentalrestservice.model.CarDTO;
import nulp.cs.carrentalrestservice.model.CarOrderDTO;
import nulp.cs.carrentalrestservice.model.CustomerDTO;
import nulp.cs.carrentalrestservice.model.OrderDetailDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-24T19:27:16+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class CarOrderMapperImpl implements CarOrderMapper {

    @Override
    public CarOrder carOrderDtoToCarOrder(CarOrderDTO carOrderDTO) {
        if ( carOrderDTO == null ) {
            return null;
        }

        CarOrder.CarOrderBuilder carOrder = CarOrder.builder();

        carOrder.id( carOrderDTO.getId() );
        carOrder.orderDetail( orderDetailDTOToOrderDetail( carOrderDTO.getOrderDetail() ) );
        carOrder.admin( adminDTOToAdmin( carOrderDTO.getAdmin() ) );
        carOrder.status( carOrderDTO.getStatus() );

        return carOrder.build();
    }

    @Override
    public CarOrderDTO carOrderToCarOrderDto(CarOrder carOrder) {
        if ( carOrder == null ) {
            return null;
        }

        CarOrderDTO.CarOrderDTOBuilder carOrderDTO = CarOrderDTO.builder();

        carOrderDTO.id( carOrder.getId() );
        carOrderDTO.admin( adminToAdminDTO( carOrder.getAdmin() ) );
        carOrderDTO.status( carOrder.getStatus() );
        carOrderDTO.orderDetail( orderDetailToOrderDetailDTO( carOrder.getOrderDetail() ) );

        return carOrderDTO.build();
    }

    protected Customer customerDTOToCustomer(CustomerDTO customerDTO) {
        if ( customerDTO == null ) {
            return null;
        }

        Customer.CustomerBuilder customer = Customer.builder();

        customer.id( customerDTO.getId() );
        customer.firstName( customerDTO.getFirstName() );
        customer.lastName( customerDTO.getLastName() );
        customer.sureName( customerDTO.getSureName() );
        customer.passportId( customerDTO.getPassportId() );
        customer.birthDate( customerDTO.getBirthDate() );
        customer.expiryDate( customerDTO.getExpiryDate() );

        return customer.build();
    }

    protected Car carDTOToCar(CarDTO carDTO) {
        if ( carDTO == null ) {
            return null;
        }

        Car.CarBuilder car = Car.builder();

        car.id( carDTO.getId() );
        car.brand( carDTO.getBrand() );
        car.model( carDTO.getModel() );
        car.pricePerDay( carDTO.getPricePerDay() );
        car.carClass( carDTO.getCarClass() );
        car.fuelConsumption( carDTO.getFuelConsumption() );
        car.numberOfSeats( carDTO.getNumberOfSeats() );
        car.location( carDTO.getLocation() );
        car.fuelType( carDTO.getFuelType() );
        car.gearboxType( carDTO.getGearboxType() );

        return car.build();
    }

    protected OrderDetail orderDetailDTOToOrderDetail(OrderDetailDTO orderDetailDTO) {
        if ( orderDetailDTO == null ) {
            return null;
        }

        OrderDetail.OrderDetailBuilder orderDetail = OrderDetail.builder();

        orderDetail.id( orderDetailDTO.getId() );
        orderDetail.numberOfDays( orderDetailDTO.getNumberOfDays() );
        orderDetail.pickUpDate( orderDetailDTO.getPickUpDate() );
        orderDetail.dropOffDate( orderDetailDTO.getDropOffDate() );
        orderDetail.pickUpLocation( orderDetailDTO.getPickUpLocation() );
        orderDetail.dropOffLocation( orderDetailDTO.getDropOffLocation() );
        orderDetail.totalPrice( orderDetailDTO.getTotalPrice() );
        orderDetail.customer( customerDTOToCustomer( orderDetailDTO.getCustomer() ) );
        orderDetail.car( carDTOToCar( orderDetailDTO.getCar() ) );
        orderDetail.comment( orderDetailDTO.getComment() );

        return orderDetail.build();
    }

    protected Admin adminDTOToAdmin(AdminDTO adminDTO) {
        if ( adminDTO == null ) {
            return null;
        }

        Admin.AdminBuilder admin = Admin.builder();

        admin.id( adminDTO.getId() );
        admin.firstName( adminDTO.getFirstName() );
        admin.lastName( adminDTO.getLastName() );
        admin.password( adminDTO.getPassword() );

        return admin.build();
    }

    protected AdminDTO adminToAdminDTO(Admin admin) {
        if ( admin == null ) {
            return null;
        }

        AdminDTO.AdminDTOBuilder adminDTO = AdminDTO.builder();

        adminDTO.id( admin.getId() );
        adminDTO.firstName( admin.getFirstName() );
        adminDTO.lastName( admin.getLastName() );
        adminDTO.password( admin.getPassword() );

        return adminDTO.build();
    }

    protected CarDTO carToCarDTO(Car car) {
        if ( car == null ) {
            return null;
        }

        CarDTO.CarDTOBuilder carDTO = CarDTO.builder();

        if ( car.getId() != null ) {
            carDTO.id( car.getId() );
        }
        carDTO.brand( car.getBrand() );
        carDTO.model( car.getModel() );
        carDTO.pricePerDay( car.getPricePerDay() );
        carDTO.carClass( car.getCarClass() );
        if ( car.getFuelConsumption() != null ) {
            carDTO.fuelConsumption( car.getFuelConsumption() );
        }
        if ( car.getNumberOfSeats() != null ) {
            carDTO.numberOfSeats( car.getNumberOfSeats() );
        }
        carDTO.location( car.getLocation() );
        carDTO.fuelType( car.getFuelType() );
        carDTO.gearboxType( car.getGearboxType() );

        return carDTO.build();
    }

    protected CustomerDTO customerToCustomerDTO(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDTO.CustomerDTOBuilder customerDTO = CustomerDTO.builder();

        customerDTO.id( customer.getId() );
        customerDTO.firstName( customer.getFirstName() );
        customerDTO.lastName( customer.getLastName() );
        customerDTO.sureName( customer.getSureName() );
        customerDTO.passportId( customer.getPassportId() );
        customerDTO.birthDate( customer.getBirthDate() );
        customerDTO.expiryDate( customer.getExpiryDate() );

        return customerDTO.build();
    }

    protected OrderDetailDTO orderDetailToOrderDetailDTO(OrderDetail orderDetail) {
        if ( orderDetail == null ) {
            return null;
        }

        OrderDetailDTO.OrderDetailDTOBuilder orderDetailDTO = OrderDetailDTO.builder();

        orderDetailDTO.id( orderDetail.getId() );
        orderDetailDTO.car( carToCarDTO( orderDetail.getCar() ) );
        orderDetailDTO.customer( customerToCustomerDTO( orderDetail.getCustomer() ) );
        orderDetailDTO.numberOfDays( orderDetail.getNumberOfDays() );
        orderDetailDTO.pickUpDate( orderDetail.getPickUpDate() );
        orderDetailDTO.dropOffDate( orderDetail.getDropOffDate() );
        orderDetailDTO.pickUpLocation( orderDetail.getPickUpLocation() );
        orderDetailDTO.dropOffLocation( orderDetail.getDropOffLocation() );
        orderDetailDTO.totalPrice( orderDetail.getTotalPrice() );
        orderDetailDTO.comment( orderDetail.getComment() );

        return orderDetailDTO.build();
    }
}
