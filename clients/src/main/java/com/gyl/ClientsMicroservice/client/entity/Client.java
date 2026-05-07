package com.gyl.ClientsMicroservice.client.entity;

import com.gyl.ClientsMicroservice.persistence.entity.DatedEntity;
import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "clients")
@Data
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
