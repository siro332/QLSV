package com.utc.nckh.domain.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ExamSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studyTime_id")
    @PrimaryKeyJoinColumn
    private StudyTime studyTime;
    private Date date;
    private String shift;
    private String type;
    private String number;
    private String  room;
    private String note;
}
