package com.lakhdim.accountservice.repos;

import com.lakhdim.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepositorie extends JpaRepository<BankAccount,String> {
}
