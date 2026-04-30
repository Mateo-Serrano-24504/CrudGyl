package com.gyl.CrudGyl.client.entity;

import com.gyl.CrudGyl.persistence.EntityState;
import com.gyl.CrudGyl.sale.entity.Sale;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
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

    @Column(name = "valid_since")
    private Instant validSince;

    @Column(name = "state")
    private EntityState state;

    @Column(name = "created_at")
    private Instant createdAt;

    @OneToMany(mappedBy = "client")
    private List<Sale> sales = new ArrayList<>();

    public Client(
            String name,
            String surname,
            String mail,
            String phoneNumber,
            String address
    ) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public Client(
            String name,
            String surname,
            String mail,
            String phoneNumber,
            String address,
            EntityState state
    ) {
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.state = state;
    }
}
