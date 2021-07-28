package com.utc.nckh.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ClassOfFaculty {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "faculty_id")
    @JsonBackReference
    private Faculty faculty;

    @OneToMany(mappedBy = "classOfFaculty",cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Teacher> teachers = new ArrayList<>();

    @OneToMany(mappedBy = "classOfFaculty",cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Student> students = new ArrayList<>();

}
