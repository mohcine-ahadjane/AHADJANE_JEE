package ma.enset.web;

import ma.enset.entities.User;
import ma.enset.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class UserController {
    private UserService userService;
    @GetMapping("/users/{username}")
    public User user(@PathVariable String username){
        User user=userService.findUserByUsername(username);
        return user;
    }
}
