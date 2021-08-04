package com.utc.nckh.api;

import com.utc.nckh.domain.converter.StudentConverter;
import com.utc.nckh.domain.model.dto.ClassOfFacultyDTO;
import com.utc.nckh.domain.model.dto.FacultyDTO;
import com.utc.nckh.domain.model.dto.StudentDTO;
import com.utc.nckh.domain.model.entities.ClassOfFaculty;
import com.utc.nckh.domain.model.entities.Faculty;
import com.utc.nckh.domain.model.entities.Student;
import com.utc.nckh.domain.service.imp.ClassOfFacultyServiceImpl;
import com.utc.nckh.domain.service.imp.FacultyServiceImpl;
import com.utc.nckh.domain.service.imp.StudentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ParentController {
    final FacultyServiceImpl facultyService;
    final ClassOfFacultyServiceImpl classService;
    final StudentServiceImpl studentService;
    final StudentConverter studentConverter;
    @GetMapping("/parent/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable Long id){
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok().body(studentConverter.entityToDTO(student));
    }
}
