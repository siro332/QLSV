package com.utc.nckh.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date dob;
    private String pob;
    private boolean isMale;
    private int yearOfAdmission;
    @ManyToOne
    @JoinColumn(name = "class_id")
    @JsonBackReference
    private ClassOfFaculty classOfFaculty;

}
