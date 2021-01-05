package com.zup.zupbank.exception;

@SuppressWarnings("serial")
public class ClientCpfDuplicateException extends RuntimeException {

    public ClientCpfDuplicateException(String cpf) {
      super("Client already registered with cpf: " + cpf);
    }
  }