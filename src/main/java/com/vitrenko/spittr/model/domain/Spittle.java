/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vitrenko.spittr.model.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;

/**
 * @author Vitalii_Vitrenko
 */
@Entity
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(exclude = "spitter")
public class Spittle {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String message;

    @Past
    private LocalDate date;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Spitter spitter;

}
