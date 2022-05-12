package enset.ma.jpaap;

import enset.ma.jpaap.entities.Patient;
import enset.ma.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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
/*patientRespository.save(new Patient(null, "Mohcine", new Date(), false, 56));
        patientRespository.save(new Patient(null, "Mohcine", new Date(), false, 56));
        patientRespository.save(new Patient(null, "Mohammed", new Date(), true, 67));
        patientRespository.save(new Patient(null, "Omar", new Date(), false, 80));
        patientRespository.save(new Patient(null, "Kamal", new Date(), false, 15));
     */
        for (int i=0;i < 100; i++){
            patientRespository.save(
                    new Patient(null, "Mohcine", new Date(), Math.random()>0.5?true:false, (int) Math.random()*100));
        }
        Page<Patient> patients = patientRespository.findAll(PageRequest.of(5,5));
        System.out.println("Total pages : "+patients.getTotalPages());
        System.out.println("Total Elements : "+patients.getTotalElements());
        System.out.println("Numbers of pages : " + patients.getNumber());
        List<Patient> content = patients.getContent();
        //List<Patient> byMalade = patientRespository.findPatientByMalade(true);
        Page<Patient> byMalade = patientRespository.findByMalade(true, PageRequest.of(1,4));
        List<Patient> patientList=patientRespository.chercherPatients("%h%", 40);
        byMalade.forEach(p->{
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
        //patientRespository.deleteById(1L);

    }
}
