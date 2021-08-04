package com.utc.nckh.domain.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Stage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Date beginTime;
    private Date endTime;
    @ManyToOne
    @JoinColumn(name = "courseClass_id")
    @JsonBackReference
    private CourseClass courseClass;
    @OneToMany(mappedBy = "stage",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Lesson> lessons;
}
