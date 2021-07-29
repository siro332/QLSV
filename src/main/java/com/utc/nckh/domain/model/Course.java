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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Long credits;
    @ManyToOne
    @JoinColumn(name = "semester_id")
    @JsonBackReference
    private Semester semester;
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<StudyTime> studyTimes;
}
