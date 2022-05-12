package enset.ma.jpaap;

import enset.ma.jpaap.entities.Patient;
import enset.ma.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRespository;
    public static void main(String[] args) {
        SpringApplication.run(JpaApApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
patientRespository.save(new Patient(null, "Mohcine", new Date(), false, 56));
        patientRespository.save(new Patient(null, "Mohcine", new Date(), false, 56));
        patientRespository.save(new Patient(null, "Mohammed", new Date(), true, 67));
        patientRespository.save(new Patient(null, "Omar", new Date(), false, 80));
        patientRespository.save(new Patient(null, "Kamal", new Date(), false, 15));
        List<Patient> patients = patientRespository.findAll();
        patients.forEach(p->{
            System.out.println("--------------------------------");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.isMalade());
        });
        System.out.println("******************************************");
        Patient patient=patientRespository.findById(1L).orElse(null);
        if(patient!=null){
            System.out.println(patient.getNom());
            System.out.println(patient.isMalade());
        }
        patient.setScore(89);
        patientRespository.deleteById(1L);

    }
}
