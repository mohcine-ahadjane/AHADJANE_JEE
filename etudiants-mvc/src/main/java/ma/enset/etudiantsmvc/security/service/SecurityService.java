package ma.enset.etudiantsmvc.security.service;

import ma.enset.etudiantsmvc.security.entities.AppRole;
import ma.enset.etudiantsmvc.security.entities.AppUser;


public interface SecurityService {
    AppUser saveNewUser(String  username , String password, String repassword) ;
    AppRole saveNewRole(String rolename , String description );
    void addRoleToUser(String username , String roleName);
    void removeRoleFromUser(String username , String roleName);
    AppUser loadUserByUserName(String username);
}
