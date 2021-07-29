package com.utc.nckh.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class General {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double trainingPoint;
    private Long tuition;
    private Long scholarship;
    private String classification;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;
    @ManyToOne
    @JoinColumn(name = "semester_id")
    @JsonBackReference
    private Semester semester;

}
