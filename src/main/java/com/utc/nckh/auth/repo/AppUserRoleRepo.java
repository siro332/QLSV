package com.utc.nckh.auth.repo;

import com.utc.nckh.auth.model.AppUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRoleRepo extends JpaRepository<AppUserRole, Long> {
    AppUserRole findByCode(String code);
}
