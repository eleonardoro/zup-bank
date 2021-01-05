package com.zup.zupbank.exception;

@SuppressWarnings("serial")
public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(Long id) {
      super("Could not find client with id: " + id);
    }
  }