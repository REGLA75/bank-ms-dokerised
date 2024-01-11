package com.lakhdim.accountservice.entities;

import com.lakhdim.accountservice.enums.AccounteType;
import com.lakhdim.accountservice.models.Customer;
import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDate;

@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder @ToString
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createdAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccounteType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
