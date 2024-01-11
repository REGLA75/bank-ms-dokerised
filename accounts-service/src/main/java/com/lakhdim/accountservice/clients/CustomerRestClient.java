package com.lakhdim.accountservice.clients;

import com.lakhdim.accountservice.models.Customer;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService" ,fallbackMethod = "defaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    @GetMapping("/customers")
    @CircuitBreaker(name = "customerService", fallbackMethod = "defaultAllCustommer")
    List<Customer> findAllCustomer();

    default Customer defaultCustomer(Long id, Exception e){
        Customer customer = new Customer();
        customer.setId(id);
        customer.setFirstName("not vailable");
        customer.setLastName("not vailable");
        customer.setEmail("not vailable");
        return customer;
    }

    default List<Customer>defaultAllCustommer(Exception e){
        return List.of();
    }
}
