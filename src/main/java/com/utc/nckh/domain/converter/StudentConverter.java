package com.utc.nckh.domain.converter;

import com.utc.nckh.domain.model.dto.StudentDTO;
import com.utc.nckh.domain.model.entities.Student;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

    public StudentDTO entityToDTO(Student student){
        ModelMapper mapper = new ModelMapper();
        return mapper.map(student,StudentDTO.class);
    }

}
