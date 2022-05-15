package ma.enset.patientsmvc;

import ma.enset.patientsmvc.entities.Patient;
import ma.enset.patientsmvc.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(
                    new Patient(null, "Mohcine", new Date(), false, 54));
            patientRepository.save(
                    new Patient(null, "Sandra", new Date(), false, 79));
            patientRepository.save(
                    new Patient(null, "Hassan", new Date(), false, 87));
            patientRepository.save(
                    new Patient(null, "Laila", new Date(), false, 95));
            patientRepository.findAll().forEach(p ->{
                System.out.println(p.getNom());
            });
        } ;
    }

}
