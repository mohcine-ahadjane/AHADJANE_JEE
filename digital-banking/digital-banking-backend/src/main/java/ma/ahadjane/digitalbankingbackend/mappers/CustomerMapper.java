package ma.ahadjane.digitalbankingbackend.mappers;

import ma.ahadjane.digitalbankingbackend.dtos.CustomerDTO;
import ma.ahadjane.digitalbankingbackend.entities.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        BeanUtils.copyProperties( customer, customerDTO);
        return customerDTO;
    }

    public Customer fromCustomerDto( CustomerDTO customerDto){
        Customer customer = new Customer();
        BeanUtils.copyProperties( customerDto, customer);
        return customer;
    }

}
