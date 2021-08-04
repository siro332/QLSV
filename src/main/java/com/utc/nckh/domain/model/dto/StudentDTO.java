package com.utc.nckh.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date dob;
    private String pob;
    private boolean isMale;
    private int yearOfAdmission;
    private ClassOfFacultyDTO classOfFaculty;

}
