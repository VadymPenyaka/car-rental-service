package nulp.cs.carrentalrestservice.mapper;

import javax.annotation.processing.Generated;
import nulp.cs.carrentalrestservice.entity.Car;
import nulp.cs.carrentalrestservice.model.CarDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-24T19:27:16+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public Car carDtoToCar(CarDTO carDTO) {
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

    @Override
    public CarDTO carToCarDto(Car car) {
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
}
