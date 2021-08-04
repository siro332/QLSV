package com.utc.nckh.domain.repo;

import com.utc.nckh.domain.model.entities.ClassOfFaculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassOfFacultyRepo extends JpaRepository<ClassOfFaculty,Long> {
}
