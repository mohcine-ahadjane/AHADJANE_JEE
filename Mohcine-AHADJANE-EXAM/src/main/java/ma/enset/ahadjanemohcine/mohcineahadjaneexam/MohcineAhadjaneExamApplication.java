package ma.enset.ahadjanemohcine.mohcineahadjaneexam;

import ma.enset.ahadjanemohcine.mohcineahadjaneexam.entities.*;
import ma.enset.ahadjanemohcine.mohcineahadjaneexam.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class MohcineAhadjaneExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(MohcineAhadjaneExamApplication.class, args);
    }
    /*@Bean
    CommandLineRunner start(CommentaireRepository commentaireRepository, ConferenceRepository conferenceRepository, InscriptionRepository inscriptionRepository, ParticipantRepository participantRepository, SaleRepository saleRepository, SessionRepository sessionRepository) {

        return args -> {
            Stream.of("Mohcine", "Hassan", "Yassine").forEach(name -> {
                Invite invite = new Invite();
                invite.setId(UUID.randomUUID().toString());
                invite.setEmail(name);
                invite.setEmail(name + "@gmail.com");
                invite.setPhotoPath("/images/" + name + ".png");
                invite.setGenre(Genre.MASCULIN);

            });

            Stream.of("Yassmine", "Laila", "Bouchra").forEach(name -> {
                Moderateur moderateur = new Moderateur();
                moderateur.setId(UUID.randomUUID().toString());
                moderateur.setEmail(name);
                moderateur.setEmail(name + "@gmail.com");
                moderateur.setPhotoPath("/images/" + name + ".png");
                moderateur.setGenre(Genre.FEMININ);

            });

            Stream.of("Mohammed", "Hassan", "Ayman").forEach(name -> {
                Speaker speaker = new Speaker();
                speaker.setId(UUID.randomUUID().toString());
                speaker.setEmail(name);
                speaker.setEmail(name + "@gmail.com");
                speaker.setPhotoPath("/images/" + name + ".png");
                speaker.setGenre(Genre.MASCULIN);

            });


        };
    }*/

}
