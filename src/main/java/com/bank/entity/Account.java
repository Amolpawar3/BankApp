package com.bank.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long account_number;
    private String account_holder_name;
    private Double accoutn_balance;

    public Long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(Long account_number) {
        this.account_number = account_number;
    }

    public String getAccount_holder_name() {
        return account_holder_name;
    }

    public void setAccount_holder_name(String account_holder_name) {
        this.account_holder_name = account_holder_name;
    }

    public Double getAccoutn_balance() {
        return accoutn_balance;
    }

    public void setAccoutn_balance(Double accoutn_balance) {
        this.accoutn_balance = accoutn_balance;
    }
}
