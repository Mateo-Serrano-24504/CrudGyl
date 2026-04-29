package com.gyl.CrudGyl.client.entity;

import com.gyl.CrudGyl.sale.entity.Sale;
import com.gyl.CrudGyl.saleDetail.entity.SaleDetail;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "mail")
    private String mail;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @OneToMany
    private List<Sale> sales = new ArrayList<>();

    @OneToMany
    private List<SaleDetail> salesDetails = new ArrayList<>();

    public Client(String name, String surname, String mail, String phoneNumber, String address) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
