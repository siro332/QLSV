package com.utc.nckh.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CourseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "studyTime_id")
    @JsonBackReference
    private StudyTime studyTime;
    @OneToMany(mappedBy = "courseClass",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Stage> stages;
}
