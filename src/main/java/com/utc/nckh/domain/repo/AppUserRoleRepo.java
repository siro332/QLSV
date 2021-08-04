package com.utc.nckh.domain.repo;

import com.utc.nckh.domain.model.entities.AppUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRoleRepo extends JpaRepository<AppUserRole, Long> {
    AppUserRole findByCode(String code);
}
