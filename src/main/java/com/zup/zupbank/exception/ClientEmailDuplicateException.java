package com.zup.zupbank.exception;

@SuppressWarnings("serial")
public class ClientEmailDuplicateException extends RuntimeException {

    public ClientEmailDuplicateException(String email) {
      super("Client already registered with email: " + email);
    }
  }