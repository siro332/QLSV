package com.utc.nckh.domain.service.imp;

import com.utc.nckh.domain.model.entities.Student;
import com.utc.nckh.domain.repo.StudentRepo;
import com.utc.nckh.domain.service.interfaces.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    @Override
    public Student getStudentById(Long id) {
        Optional<Student> studentOptional = studentRepo.findById(id);
        if (!studentOptional.isPresent()){
            throw new IllegalStateException("Student with id: "+id+" not found");
        }
        return studentOptional.get();
    }
}
