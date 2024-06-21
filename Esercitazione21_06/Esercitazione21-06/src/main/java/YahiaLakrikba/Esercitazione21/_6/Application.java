package YahiaLakrikba.Esercitazione21._6;

import YahiaLakrikba.Esercitazione21._6.enums.StationType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import YahiaLakrikba.Esercitazione21._6.entities.*;
import YahiaLakrikba.Esercitazione21._6.repositories.*;

import java.time.LocalDate;

import java.util.List;

@SpringBootApplication
public class Application {

	private final UserRepository userRepository;
	private final BookingRepository bookingRepository;
	private final BuildingRepository buildingRepository;
	private final StationRepository stationRepository;

	public Application(UserRepository userRepository, BookingRepository bookingRepository,
					   BuildingRepository buildingRepository, StationRepository stationRepository) {
		this.userRepository = userRepository;
		this.bookingRepository = bookingRepository;
		this.buildingRepository = buildingRepository;
		this.stationRepository = stationRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {

			User user1 = new User("john_doe", "John", "Doe", "New York", "john.doe@example.com");
			userRepository.save(user1);


			Building building1 = new Building("BuildingA", "Address1", "City1");
			buildingRepository.save(building1);


			Station station1 = new Station( "Example Station", StationType.OPENSPACE, 50 );
			station1.setBuilding(building1);
			stationRepository.save(station1);


			LocalDate date = LocalDate.now();
			User user = userRepository.findByUsername("john_doe");
			Station station = stationRepository.findById(1L).orElseThrow(() -> new RuntimeException("Station not found"));

			Booking booking = new Booking(user, station, date);
			bookingRepository.save(booking);



			User userByUsername = userRepository.findByUsername("john_doe");
			System.out.println("User by username: " + userByUsername);


			List<Booking> bookingsByUser = bookingRepository.findByUser(userByUsername);
			System.out.println("Bookings by user: " + bookingsByUser);


			List<Station> stationsByBuilding = stationRepository.findByBuilding(building1);
			System.out.println("Stations by building: " + stationsByBuilding);


			List<User> allUsers = userRepository.findAll();
			System.out.println("All users: " + allUsers);


			userRepository.deleteById(userByUsername.getId());
		};
	}

}
