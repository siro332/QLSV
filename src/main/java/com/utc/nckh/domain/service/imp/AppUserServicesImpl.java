package com.utc.nckh.domain.service.imp;

import com.utc.nckh.domain.model.AppUser;
import com.utc.nckh.domain.model.AppUserRole;
import com.utc.nckh.domain.repo.AppUserRepo;
import com.utc.nckh.domain.repo.AppUserRoleRepo;
import com.utc.nckh.domain.service.interfaces.AppUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class AppUserServicesImpl implements AppUserService, UserDetailsService {
    private final AppUserRepo appUserRepo;
    private final AppUserRoleRepo appUserRoleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AppUser saveUser(AppUser user) {
        log.info("Saving new user {} to the database", user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = appUserRepo.findByUsername(username);
        if (user == null){
            log.error("User not found in the database");
            throw new UsernameNotFoundException("user not found in the database");
        }else{
            log.info("User found in the database: {}",username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getCode()));
        return new User(user.getUsername(),user.getPassword(),authorities);
    }
}
