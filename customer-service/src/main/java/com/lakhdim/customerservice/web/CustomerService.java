package com.lakhdim.customerservice.web;

import com.lakhdim.customerservice.entities.Customer;
import com.lakhdim.customerservice.repositories.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerService {

    final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("/saveCustomer")
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerRepository.save(customer);
    }

    @GetMapping("/customers")
    public List<Customer>listCustomer(){
        return customerRepository.findAll();
    }

    @GetMapping("/customer/{id}")
    public Customer customerById(@PathVariable Long id){
     return customerRepository.findById(id).get();
    }
}
