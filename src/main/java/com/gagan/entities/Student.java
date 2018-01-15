package com.gagan.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter@Getter@NoArgsConstructor
@Entity
public class Student {

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roll;

    public Student(String name) {
        this.name = name;
    }
}
