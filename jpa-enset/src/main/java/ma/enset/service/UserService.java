package ma.enset.service;

import ma.enset.entities.Role;
import ma.enset.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUsername(String username);
    Role findRoleByName(String roleName);
    void addRoleToUser(String username, String roleName);
    User authenticate(String userName, String password);

}
