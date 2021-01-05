package com.zup.zupbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zup.zupbank.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
    public Client findByEmail(String email);
    
    public Client findByCpf(String cpf);
}
