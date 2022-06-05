package ma.enset.etudiantsmvc.security;
import ma.enset.etudiantsmvc.security.service.UserDetailsServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration // instancier  en premier lieu
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource ;
    @Autowired
    private UserDetailsServiceIml userDetailsServiceIml;


    @Override // strategy pour que spring security va chercher les users
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

         PasswordEncoder passwordEncoder=myPasswordEncoder();
//        String ecodedPassword=passwordEncoder.encode("1234");
//        System.out.println(ecodedPassword);
        // preciser comment spring va chercherr les user et les roles ( bdd ou user en memoire ou  annuaire en  entreprise)
//        auth.inMemoryAuthentication().withUser("user1").password(ecodedPassword).roles("USER");
//        auth.inMemoryAuthentication().withUser("user2").password(passwordEncoder.encode("1111")).roles("USER");
//        auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("2345")).roles("USER","ADMIN"); // user qui on le droit d'acceder a l'application seront stockerr en memoire
//   auth.jdbcAuthentication()
//           .dataSource(dataSource)
//           .usersByUsernameQuery("select username as principal, password as credentials,active from users where username=?")
//           .authoritiesByUsernameQuery("Select username as principal, role as role from users_roles where username=?")
//           .rolePrefix("ROLE_")
//           .passwordEncoder(passwordEncoder);


        auth.userDetailsService(userDetailsServiceIml);

    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin();
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/admin/**").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers("/user/**").hasAuthority("USER");
        http.authorizeRequests().antMatchers("/webjars/**").permitAll();
        http.authorizeRequests().anyRequest().authenticated(); // toutes les rrequetes http neccecite une  authentification
        http.exceptionHandling().accessDeniedPage("/403");
    }

    @Bean
    PasswordEncoder myPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
