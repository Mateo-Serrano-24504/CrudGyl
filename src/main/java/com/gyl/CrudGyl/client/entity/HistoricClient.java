package com.gyl.CrudGyl.client.entity;

import com.gyl.CrudGyl.persistence.EntityState;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Table(name = "historic_clients")
@Getter
@Setter
@NoArgsConstructor
public class HistoricClient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "client_id")
    private Long clientId;

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

    @Column(name = "valid_from")
    private Instant validFrom;

    @Column(name = "valid_to")
    private Instant validTo;

    @Column(name = "state")
    private EntityState state;

    public HistoricClient(Client client) {
        this.clientId = client.getId();
        this.name = client.getName();
        this.surname = client.getSurname();
        this.mail = client.getMail();
        this.phoneNumber = client.getPhoneNumber();
        this.address = client.getAddress();
        this.validFrom = client.getValidSince();
        this.state = client.getState();
    }
}
