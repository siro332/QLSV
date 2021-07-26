package com.utc.nckh.auth.service.interfaces;

import com.utc.nckh.auth.model.AppUser;
import com.utc.nckh.auth.model.AppUserRole;

import java.util.List;

public interface AppUserService {
    AppUser saveUser(AppUser user);

    AppUserRole saveRole(AppUserRole role);

    void setRoleToUser(String username, String roleCode);

    AppUser getUser(String username);

    List<AppUser> getUsers();

    void setUsernameForNewAccount();
}
