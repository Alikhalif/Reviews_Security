package ma.youcode.youreview;

import java.util.Arrays;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;
import ma.youcode.youreview.models.documents.Review;
import ma.youcode.youreview.models.documents.Role;
import ma.youcode.youreview.models.documents.User;
import ma.youcode.youreview.repositories.ReviewRepository;
import ma.youcode.youreview.repositories.RoleRepository;
import ma.youcode.youreview.repositories.UserRepository;

@AllArgsConstructor

@SpringBootApplication
public class YoureviewApplication {

	private RoleRepository roleRepository;
	private UserRepository userRepository;
	private ReviewRepository reviewRepository;
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(YoureviewApplication.class, args);
	}

	@Bean
    public CommandLineRunner myCommandLineRunner() { 
        return args -> {

			var role1 = Role.builder()
							.id("1")
							.name("ADMIN")
							.build();
			var role2 = Role.builder()
							.id("2")
							.name("EDITOR")
							.build();
            roleRepository.saveAll(Arrays.asList(role1, role2));

			var user = User.builder()
							.id("1")
							.userName("hamzaEssouli")
							.password(passwordEncoder.encode("password"))
							.roles(Set.of(role1, role2))
							.build();

			userRepository.save(user);

			reviewRepository.save(
				Review.builder()
					  .id("1")
					  .content("ach had service dyal walo")
					  .author(user)
					  .build()
			);

            System.out.println("Executing code during application startup.");
        };
    }

	

}
