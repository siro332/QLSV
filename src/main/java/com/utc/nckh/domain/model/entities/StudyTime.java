package com.utc.nckh.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class StudyTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    @JsonBackReference
    private Course course;
    @ManyToOne
    @JoinColumn(name = "semester_id")
    @JsonBackReference
    private Semester semester;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @JsonBackReference
    private Student student;

    @OneToMany(mappedBy = "studyTime",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<CourseClass> courseClasses;

    @OneToOne(mappedBy = "studyTime")
    private Result result;

    @OneToOne(mappedBy = "studyTime")
    private ExamSchedule examSchedule;
}
