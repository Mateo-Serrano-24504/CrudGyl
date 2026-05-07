package com.gyl.ClientsMicroservice.client.update.exception;

public class ClientUpdateClientDoesNotExist extends RuntimeException {
    public ClientUpdateClientDoesNotExist(Long id) {
        super("Client of id " + id + " does not exist");
    }
}
