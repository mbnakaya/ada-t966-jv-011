package io.cs.mbnakaya.aula3.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Name required")
    private String name;

    @NotBlank(message = "Email required")
    @Email
    private String email;

    private String address;

    @Size(min = 11)
    private String phone;
}
