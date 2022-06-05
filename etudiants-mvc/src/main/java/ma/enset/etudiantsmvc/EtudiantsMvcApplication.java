package ma.enset.etudiantsmvc;
import ma.enset.etudiantsmvc.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EtudiantsMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(EtudiantsMvcApplication.class, args);


}
@Bean
	CommandLineRunner saveUsers(SecurityService securityService){
		return args -> {
			securityService.saveNewUser("Mohcine", "1234", "1234");
			securityService.saveNewUser("Ikram", "1234", "1234");
			securityService.saveNewUser("Omar", "1234", "1234");


			securityService.saveNewRole("USER", "");
			securityService.saveNewRole("ADMIN", "");

			securityService.addRoleToUser("Mohcine", "USER");
			securityService.addRoleToUser("Mohcine", "ADMIN");
			securityService.addRoleToUser("Ikram", "USER");
			securityService.addRoleToUser("Omar", "USER");
		};
	}

}
