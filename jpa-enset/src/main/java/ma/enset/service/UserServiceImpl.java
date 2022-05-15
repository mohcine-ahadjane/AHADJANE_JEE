package ma.enset.service;

import lombok.AllArgsConstructor;
import ma.enset.entities.Role;
import ma.enset.entities.User;
import ma.enset.repositories.RoleRepository;
import ma.enset.repositories.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public User findUserByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    @Override
    public Role findRoleByName(String roleName) {

        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUsername(username);
        Role role = findRoleByName(roleName);
        if(user.getRoles()!=null){
        user.getRoles().add(role);
        role.getUsers().add(user);
        //userRepository.save(user);   //pas besoin @Transactionnal
        }

    }

    @Override
    public User authenticate(String userName, String password) {
        User user = userRepository.findByUsername(userName);
        if(user==null) throw new RuntimeException("Bad credentials");
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad credentials");
    }
}
