package com.gyl.ClientsMicroservice.client.entity;

import com.gyl.ClientsMicroservice.persistence.entity.HistoricEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "historic_clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoricClient extends HistoricEntity<HistoricClient> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "mail", nullable = false)
    private String mail;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "address", nullable = false)
    private String address;
}
