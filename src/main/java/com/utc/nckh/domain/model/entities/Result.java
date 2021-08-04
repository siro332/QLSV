package com.utc.nckh.domain.model.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studyTime_id")
    @PrimaryKeyJoinColumn
    private StudyTime studyTime;
    private Double markProcess;
    private Double markExam;
    private String evaluation;
}
