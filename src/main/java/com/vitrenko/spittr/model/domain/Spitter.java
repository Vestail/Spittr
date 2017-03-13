/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.domain;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;
import org.hibernate.validator.constraints.Email;

import java.util.List;

/**
 * @author Vitalii_Vitrenko
 */
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(exclude = "spittles")
public class Spitter {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Size(min = 4, max = 16)
    @Column(unique = true)
    private String login;

    @NotNull
    @Size(min = 6, max = 24)
    private String password;

    @Email
    @NotNull
    @Size(max = 50)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(max = 50)
    private String firstName;

    @NotNull
    @Size(max = 50)
    private String lastName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "spitter", orphanRemoval = true)
    private List<Spittle> spittles;

}
