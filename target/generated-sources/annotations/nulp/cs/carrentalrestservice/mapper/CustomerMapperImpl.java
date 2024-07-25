package nulp.cs.carrentalrestservice.mapper;

import javax.annotation.processing.Generated;
import nulp.cs.carrentalrestservice.entity.Customer;
import nulp.cs.carrentalrestservice.model.CustomerDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-07-24T19:27:16+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.4.1 (Amazon.com Inc.)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public Customer customerDtoToCustomer(CustomerDTO customerDTO) {
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

    @Override
    public CustomerDTO customerToCustomerDto(Customer customer) {
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
}
