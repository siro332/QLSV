package com.utc.nckh.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Semester {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long beginYear;
    private Long endYear;
    private Long times;

    @OneToMany(mappedBy = "semester",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<General> generals;

    @OneToMany(mappedBy = "semester",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Evaluation> evaluations;

    @OneToMany(mappedBy = "semester",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Course> courses;

    @OneToMany(mappedBy = "semester",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<StudyTime> studyTimes;


}
