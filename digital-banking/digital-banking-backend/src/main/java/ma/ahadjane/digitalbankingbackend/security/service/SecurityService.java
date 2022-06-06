package ma.ahadjane.digitalbankingbackend.security.service;


import ma.ahadjane.digitalbankingbackend.security.entities.AppRole;
import ma.ahadjane.digitalbankingbackend.security.entities.AppUser;

import java.util.List;

public interface SecurityService {

    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser( String username, String roleName);
    AppUser loadUserByUsername( String username);
    List<AppUser> listUsers();
}
