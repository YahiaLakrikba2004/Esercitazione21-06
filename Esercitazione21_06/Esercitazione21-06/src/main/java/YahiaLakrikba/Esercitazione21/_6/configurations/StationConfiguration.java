package YahiaLakrikba.Esercitazione21._6.configurations;

import java.util.Locale;

import YahiaLakrikba.Esercitazione21._6.entities.Building;
import YahiaLakrikba.Esercitazione21._6.entities.Station;
import YahiaLakrikba.Esercitazione21._6.enums.StationType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.github.javafaker.Faker;


@Configuration
public class StationConfiguration {

    @Bean("Station")
    @Scope("prototype")
    Station station(String description, StationType postType, Integer maxSeats,
                    Building building) {
        return new Station();

    }

    @Bean("Station")
    @Scope("prototype")
    Station fakeStation() {
        Faker f = Faker.instance(new Locale("en-US"));
        Station s = new Station();
        s.setDescription("The station is a  " + s.getStationType() + "and provides a maximum of "
                + s.getNumberMaximumSeats() + " seats.");
        int seats = f.number().numberBetween(1, 50);
        s.getNumberMaximumSeats();
        if (seats <= 35) {
            s.setStationType(StationType.MEETINGROOM);
        } else if (seats <= 15) {
            s.setStationType(StationType.PRIVATE);
        } else {
            s.setStationType(StationType.OPENSPACE);
        }
        return s;
    }

}
