package com.utc.nckh.domain.service.imp;

import com.utc.nckh.domain.model.entities.Faculty;
import com.utc.nckh.domain.repo.FacultyRepo;
import com.utc.nckh.domain.service.interfaces.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FacultyServiceImpl implements FacultyService {

    private final FacultyRepo facultyRepo;
    @Override
    public Faculty getFacultyById(Long id) {
        Optional<Faculty> facultyOptional = facultyRepo.findById(id);
        if (!facultyOptional.isPresent()){
            throw new IllegalStateException("Faculty with id: "+id+" not found");
        }
        return facultyOptional.get();
    }
}
