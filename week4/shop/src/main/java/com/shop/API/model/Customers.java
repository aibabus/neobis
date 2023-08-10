package com.shop.API.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Setter
@Getter
@ToString
@Entity
@Table(name = "Shop")
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customers_id")
    private int customers_id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    private String last_name;
    @Column(name="user_login")
    private String user_login;
    @Column(name="user_password")
    private String user_password;
    @Column(name="email")
    private String email;
    @Column(name = "address")
    private String address;
}

