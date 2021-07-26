package com.utc.nckh.auth.service.imp;

import com.utc.nckh.auth.model.AppUser;
import com.utc.nckh.auth.model.AppUserRole;
import com.utc.nckh.auth.repo.AppUserRepo;
import com.utc.nckh.auth.repo.AppUserRoleRepo;
import com.utc.nckh.auth.service.interfaces.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServicesImpl implements AppUserService {
    private final AppUserRepo appUserRepo;
    private final AppUserRoleRepo appUserRoleRepo;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving new user {} to the database", user.getUsername());
        return appUserRepo.save(user);
    }

    @Override
    public AppUserRole saveRole(AppUserRole role) {
        log.info("Saving new role {} to the database", role.getName());
        return appUserRoleRepo.save(role);
    }

    @Override
    public void setRoleToUser(String username, String roleCode) {
        log.info("Add role {} to user {}", username, roleCode);
        AppUser user = appUserRepo.findByUsername(username);
        AppUserRole role = appUserRoleRepo.findByCode(roleCode);
        user.setRole(role);
    }


    @Override
    public AppUser getUser(String username) {
        log.info("fetching user {}", username);
        return appUserRepo.findByUsername(username);
    }

    @Override
    public List<AppUser> getUsers() {
        log.info("fetching all users");
        return appUserRepo.findAll();
    }

    @Override
    public void setUsernameForNewAccount() {

    }
}
