package com.utc.nckh.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Evaluation {
    @EmbeddedId
    private EvaluationKey id;
    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;

    @ManyToOne
    @MapsId("semesterId")
    @JoinColumn(name = "semester_id")
    @JsonBackReference
    private Semester semester;

    private String content;


}
@Embeddable
class EvaluationKey implements Serializable {

    @Column(name = "student_id")
    private Long studentId;

    @Column(name = "semester_id")
    private Long semesterId;
}
