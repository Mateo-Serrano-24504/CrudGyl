package com.gyl.CrudGyl.client.update.exception;

public class ClientDoesNotExist extends RuntimeException {
    public ClientDoesNotExist(Long id) {
        super("Client of id " + id + " does not exist");
    }
}
