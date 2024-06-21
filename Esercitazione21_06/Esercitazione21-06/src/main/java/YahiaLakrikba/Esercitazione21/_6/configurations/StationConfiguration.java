package YahiaLakrikba.Esercitazione21._6.configurations;

import java.util.Locale;

import YahiaLakrikba.Esercitazione21._6.entities.Building;
import YahiaLakrikba.Esercitazione21._6.entities.Station;
import YahiaLakrikba.Esercitazione21._6.enums.StationState;
import YahiaLakrikba.Esercitazione21._6.enums.StationType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.github.javafaker.Faker;


@Configuration
public class StationConfiguration {

    @Bean("Station")
    @Scope("prototype")
    Station stationData(String description, StationType postType, Integer maxSeats,
                    Building building) {
        return new Station();

    }

    @Bean("FakeStation")
    @Scope("prototype")
    public Station createFakeStation() {
        Station station = new Station();


        station.setDescription("Example Station");
        station.setNumberMaximumSeats(50);
        station.setStationType(StationType.OPENSPACE);

        return station;
    }


}
