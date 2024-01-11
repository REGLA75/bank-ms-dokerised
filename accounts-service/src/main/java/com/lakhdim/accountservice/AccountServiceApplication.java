package com.lakhdim.accountservice;

import com.lakhdim.accountservice.clients.CustomerRestClient;
import com.lakhdim.accountservice.entities.BankAccount;
import com.lakhdim.accountservice.enums.AccounteType;
import com.lakhdim.accountservice.repos.BankAccountRepositorie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepositorie bankAccountRepositorie, CustomerRestClient crc){
        return args -> {

            crc.findAllCustomer().forEach(c->{

                BankAccount b1 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random()*4588)
                        .createdAt(LocalDate.now())
                        .customerId(c.getId())
                        .type(AccounteType.CURRENT_ACCOUNT)
                        .build();
                BankAccount b2 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("MAD")
                        .balance(Math.random()*10000)
                        .createdAt(LocalDate.now())
                        .customerId(c.getId())
                        .type(AccounteType.CURRENT_ACCOUNT)
                        .build();
                bankAccountRepositorie.save(b1);
                bankAccountRepositorie.save(b2);
            });


        };
    }

}
