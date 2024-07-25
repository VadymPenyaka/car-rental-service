package nulp.cs.carrentalrestservice.mapper;

import javax.annotation.processing.Generated;
import nulp.cs.carrentalrestservice.entity.CarPricing;
import nulp.cs.carrentalrestservice.model.CarPricingDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-24T19:27:16+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class CarPricingMapperImpl implements CarPricingMapper {

    @Override
    public CarPricingDTO carPricingToCarPricingDto(CarPricing carPricing) {
        if ( carPricing == null ) {
            return null;
        }

        CarPricingDTO.CarPricingDTOBuilder carPricingDTO = CarPricingDTO.builder();

        if ( carPricing.getId() != null ) {
            carPricingDTO.id( carPricing.getId() );
        }
        if ( carPricing.getPledge() != null ) {
            carPricingDTO.pledge( carPricing.getPledge() );
        }
        if ( carPricing.getUpToThreeDays() != null ) {
            carPricingDTO.upToThreeDays( carPricing.getUpToThreeDays() );
        }
        if ( carPricing.getUpToTenDays() != null ) {
            carPricingDTO.upToTenDays( carPricing.getUpToTenDays() );
        }
        if ( carPricing.getUpToMonth() != null ) {
            carPricingDTO.upToMonth( carPricing.getUpToMonth() );
        }
        if ( carPricing.getMoreThenMonth() != null ) {
            carPricingDTO.moreThenMonth( carPricing.getMoreThenMonth() );
        }

        return carPricingDTO.build();
    }

    @Override
    public CarPricing carPricingDtoToCarPricing(CarPricingDTO carPricingDTO) {
        if ( carPricingDTO == null ) {
            return null;
        }

        CarPricing.CarPricingBuilder carPricing = CarPricing.builder();

        carPricing.id( carPricingDTO.getId() );
        carPricing.pledge( carPricingDTO.getPledge() );
        carPricing.upToThreeDays( carPricingDTO.getUpToThreeDays() );
        carPricing.upToTenDays( carPricingDTO.getUpToTenDays() );
        carPricing.upToMonth( carPricingDTO.getUpToMonth() );
        carPricing.moreThenMonth( carPricingDTO.getMoreThenMonth() );

        return carPricing.build();
    }
}
