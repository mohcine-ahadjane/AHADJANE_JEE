package ma.enset.etudiantsmvc.security.service;

import ma.enset.etudiantsmvc.security.entities.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserDetailsServiceIml implements UserDetailsService {
    @Autowired
    private SecurityService securityService;

//    public UserDetailsServiceIml(SecurityService securityService) {
//        this.securityService = securityService;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = securityService.loadUserByUserName(username);
//        Collection<GrantedAuthority> authorities = new ArrayList<>();
//        appUser.getAppRoleList().forEach(role->{
//            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getRole());
//            authorities.add(authority);
//
//        });
//
        Collection<GrantedAuthority> authorities1=
                appUser.getAppRoleList().stream().map(role->new SimpleGrantedAuthority(role.getRole())).collect(Collectors.toList());
        User user= new User(appUser.getUsername(), appUser.getPassword(),authorities1 );
        return user;
    }
}
