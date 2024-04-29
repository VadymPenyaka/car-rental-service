package nulp.cs.carrentalrestservice.service;

import lombok.RequiredArgsConstructor;
import nulp.cs.carrentalrestservice.mapper.CustomerMapper;
import nulp.cs.carrentalrestservice.model.CustomerDTO;
import nulp.cs.carrentalrestservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        return customerMapper.customerToCustomerDto(customerRepository
                .save(customerMapper.customerDtoToCustomer(customerDTO)));
    }

    @Override
    public Optional<CustomerDTO> getCustomerByID(Long id) {
        return Optional.ofNullable(customerMapper.customerToCustomerDto(customerRepository
                .findById(id).orElse(null)));
    }
}
