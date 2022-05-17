package ma.enset.patientsmvc;

import ma.enset.patientsmvc.entities.Patient;
import ma.enset.patientsmvc.repositories.PatientRepository;
import ma.enset.patientsmvc.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }
    //@Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(
                    new Patient(null, "Mohcine", new Date(), false, 154));
            patientRepository.save(
                    new Patient(null, "Sandra", new Date(), false, 279));
            patientRepository.save(
                    new Patient(null, "Hassan", new Date(), false, 187));
            patientRepository.save(
                    new Patient(null, "Laila", new Date(), false, 995));
            patientRepository.findAll().forEach(p ->{
                System.out.println(p.getNom());
            });
        } ;
    }
    //@Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args -> {
            securityService.saveNewUser("mohammed", "1234", "1234");
            securityService.saveNewUser("Sandra", "1234", "1234");
            securityService.saveNewUser("Hassan", "1234", "1234");


            securityService.saveNewRole("USER", "");
            securityService.saveNewRole("ADMIN", "");

            securityService.addRoleToUser("mohammed", "USER");
            securityService.addRoleToUser("mohammed", "ADMIN");
            securityService.addRoleToUser("sandra", "USER");
            securityService.addRoleToUser("Hassan", "USER");

        };
    }

}
