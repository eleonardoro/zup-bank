package com.zup.zupbank.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.zup.zupbank.entity.Client;
import com.zup.zupbank.service.ClientService;

@RestController
public class ClientController {
    
    @Autowired
    private ClientService clientService;
    
    @GetMapping("/clients")
    List<Client> findAll() {
        return clientService.findAll();
    }

    @PostMapping("/clients")
    Client includeClient(@Valid @RequestBody Client client){
      return clientService.includeClient(client);
    }
    

    @GetMapping("/clients/{id}")
    Client findOne(@PathVariable Long id) {
        return clientService.findOne(id);
    }

    @PutMapping("/clients/{id}")
    Client updateClient(@Valid @RequestBody Client client, @PathVariable Long id) {
        return clientService.updateClient(client, id);
    }

    @DeleteMapping("/clients/{id}")
    void deleteClient(@PathVariable Long id) {
      clientService.deleteClient(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
