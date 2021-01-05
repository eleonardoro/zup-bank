package com.zup.zupbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zup.zupbank.entity.Client;
import com.zup.zupbank.exception.ClientCpfDuplicateException;
import com.zup.zupbank.exception.ClientEmailDuplicateException;
import com.zup.zupbank.exception.ClientNotFoundException;
import com.zup.zupbank.repository.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client findOne(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

    public Client includeClient(Client client) {
        
        if(clientRepository.findByEmail(client.getEmail()) != null)
            throw new ClientEmailDuplicateException(client.getEmail());
        
        if(clientRepository.findByCpf(client.getCpf()) != null)
            throw new ClientCpfDuplicateException(client.getCpf());
        
        return clientRepository.save(client);
    }

    public Client updateClient(Client newClient, Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));

        client.setName(newClient.getName());
        client.setEmail(newClient.getEmail());
        client.setCpf(newClient.getCpf());
        client.setBirthDate(newClient.getBirthDate());

        return clientRepository.save(client);
    }

    public void deleteClient(long id) {
        clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
        
        clientRepository.deleteById(id);
    }
}
