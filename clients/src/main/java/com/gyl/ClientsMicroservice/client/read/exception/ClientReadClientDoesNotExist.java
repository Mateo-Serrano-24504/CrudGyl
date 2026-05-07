package com.gyl.ClientsMicroservice.client.read.exception;

public class ClientReadClientDoesNotExist extends RuntimeException {
    public ClientReadClientDoesNotExist(Long id) {
        super("Client of id " + id + " does not exist");
    }
}
