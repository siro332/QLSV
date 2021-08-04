package com.utc.nckh.domain.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassOfFacultyDTO {
    private Long id;
    private String name;
    private FacultyDTO faculty;
}
