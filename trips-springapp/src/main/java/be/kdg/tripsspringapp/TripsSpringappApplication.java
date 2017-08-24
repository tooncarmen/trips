package be.kdg.tripsspringapp;

import be.kdg.trips.core.boundries.InvitationSender;
import be.kdg.trips.core.boundries.InvitationsRepository;
import be.kdg.trips.core.boundries.TripRepository;
import be.kdg.trips.core.boundries.UserRepository;
import be.kdg.trips.core.usecases.CreateTrip;
import be.kdg.trips.core.usecases.FindTrips;
import be.kdg.trips.core.usecases.Login;
import be.kdg.trips.repo.InMemoryInvitationRepo;
import be.kdg.trips.repo.InMemoryTripRepo;
import be.kdg.trips.repo.InMemoryUserRepo;
import be.kdg.trips.tripsInvitationmailer.InvitationEmailer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class TripsSpringappApplication {

	@Bean
    @Scope("singleton")
    public TripRepository getInMemoryTripRepo(){
	    return new InMemoryTripRepo();
    }
    @Bean
    @Scope("singleton")
    public InvitationsRepository getInMemoryInvitationRepo(){
        return new InMemoryInvitationRepo();
    }

    @Bean
    @Scope("singleton")
    public UserRepository getInMemoryUserRepo(){
        return new InMemoryUserRepo();
    }
    @Bean
    public InvitationSender getInvitationSender(){
        return new InvitationEmailer();
    }

    @Bean
    public Login getLogin(){
        return new Login(getInMemoryUserRepo());
    }

    @Bean
    public FindTrips getFindTrips(){
        return new FindTrips(getInMemoryTripRepo());
    }
    @Bean
    public CreateTrip getCreateTrip(){
        return new CreateTrip(getInMemoryTripRepo());
    }

	public static void main(String[] args) {
		SpringApplication.run(TripsSpringappApplication.class, args);
	}
}
