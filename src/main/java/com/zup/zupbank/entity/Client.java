package com.zup.zupbank.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    
    @NotBlank(message = "Name is mandatory")
    @Size(min = 5, max = 60, message = "Name must contain between 5 and 60 characters")
    private String name;
    
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is invalid")
    private String email;
    
    @NotBlank(message = "CPF is mandatory")
    @CPF(message = "CPF is invalid")
    @Pattern(regexp = "[0-9]+", message = "CPF must contain only numbers")
    private String cpf;
    
    @NotNull(message = "Birth Date is mandatory")
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Birth Date must be today or in the past")
    private LocalDate birthDate;

    public Client(String name, String email, String cpf, LocalDate birthDate) {
        super();
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthDate = birthDate;
    }    
}
