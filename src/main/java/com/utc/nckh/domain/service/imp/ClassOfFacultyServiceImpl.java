package com.utc.nckh.domain.service.imp;

import com.utc.nckh.domain.model.entities.ClassOfFaculty;
import com.utc.nckh.domain.repo.ClassOfFacultyRepo;
import com.utc.nckh.domain.service.interfaces.ClassOfFacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassOfFacultyServiceImpl implements ClassOfFacultyService {
    private final ClassOfFacultyRepo classOfFacultyRepo;
    @Override
    public ClassOfFaculty getClassById(Long id) {
        Optional<ClassOfFaculty> classOfFaculty = classOfFacultyRepo.findById(id);
        if (!classOfFaculty.isPresent()){
            throw new IllegalStateException("Class with id: "+id+" not found");
        }
        return classOfFaculty.get();
    }
}
