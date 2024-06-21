package YahiaLakrikba.Esercitazione21._6.configurations;

import YahiaLakrikba.Esercitazione21._6.entities.Booking;
import YahiaLakrikba.Esercitazione21._6.entities.Station;
import YahiaLakrikba.Esercitazione21._6.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.time.LocalDate;

@Configuration
public class BookingConfiguration {

    @Bean("Booking")
    @Scope("prototype")
    public Booking createBooking(User user, Station station, LocalDate date) {
        return new Booking(user, station, date);
    }
}
