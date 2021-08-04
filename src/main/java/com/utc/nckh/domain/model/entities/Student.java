package com.utc.nckh.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
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
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    @JsonManagedReference
    private  Set<Parent> parents;

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<General> generals;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Evaluation> evaluations;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<StudyTime> studyTimes;
}
