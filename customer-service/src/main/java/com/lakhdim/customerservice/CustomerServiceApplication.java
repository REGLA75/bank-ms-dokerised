package com.lakhdim.customerservice;

import com.lakhdim.customerservice.config.GlobalConfig;
import com.lakhdim.customerservice.entities.Customer;
import com.lakhdim.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            Customer customer1 = Customer.builder()
                    .firstName("abdelhadi")
                    .lastName("lakhdim")
                    .email("lakhdim@gmail.com")
                    .build();

            Customer customer2 = Customer.builder()
                    .firstName("abdessamad")
                    .lastName("lakhdim")
                    .email("abdessamad@gmail.com")
                    .build();
            Customer customer3 = Customer.builder()
                    .firstName("naima")
                    .lastName("lakhdim")
                    .email("naima@gmail.com")
                    .build();
            customerRepository.save(customer1);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
        };
    }

}
