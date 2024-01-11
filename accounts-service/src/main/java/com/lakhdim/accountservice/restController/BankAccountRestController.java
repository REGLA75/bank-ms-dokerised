package com.lakhdim.accountservice.restController;

import com.lakhdim.accountservice.clients.CustomerRestClient;
import com.lakhdim.accountservice.entities.BankAccount;
import com.lakhdim.accountservice.models.Customer;
import com.lakhdim.accountservice.repos.BankAccountRepositorie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountRestController {

    private final BankAccountRepositorie bankAccountRepositorie;
    private  final CustomerRestClient customerRestClient;

    public BankAccountRestController(BankAccountRepositorie bankAccountRepositorie, CustomerRestClient customerRestClient) {
        this.bankAccountRepositorie = bankAccountRepositorie;
        this.customerRestClient = customerRestClient;
    }

    @GetMapping("/accounts")
    public List<BankAccount> allAccounts(){
        List<BankAccount> bankAccounts = bankAccountRepositorie.findAll();
        bankAccounts.forEach(b->{
            b.setCustomer(customerRestClient.findCustomerById(b.getCustomerId()));
        });
        return bankAccounts;
    }

    @GetMapping("/accounts/{id}")
    public BankAccount getAccountById(@PathVariable String id){
        BankAccount bankAccount = bankAccountRepositorie.findById(id).get();
        Customer customer = customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;

    }
}
