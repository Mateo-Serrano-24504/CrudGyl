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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "mail", nullable = false, unique = true)
    private String mail;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "valid_since", nullable = false)
    private Instant validSince;

    @Column(name = "state", nullable = false)
    private EntityState state;

    @Column(name = "created_at", nullable = false)
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
