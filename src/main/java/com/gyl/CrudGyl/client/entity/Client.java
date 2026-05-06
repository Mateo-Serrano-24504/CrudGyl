package com.gyl.CrudGyl.client.entity;

import com.gyl.CrudGyl.persistence.entity.DatedEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clients")
@Getter
@Setter
@NoArgsConstructor
public class Client extends DatedEntity<Client> {
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
}
