package YahiaLakrikba.Esercitazione21._6.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import com.github.javafaker.Faker;
import YahiaLakrikba.Esercitazione21._6.entities.Building;

import java.util.Locale;

@Configuration
public class BuildingConfiguration {

    @Bean("BuildingData")
    @Scope("prototype")
    public Building BuildingData(String nameBuilding, String addressBuilding, String cityBuilding) {
        return new Building(nameBuilding, addressBuilding, cityBuilding);
    }

    @Bean("FakeBuild")
    @Scope("prototype")
    public Building createFakeBuilding() {
        Building building = new Building();


        building.setNameBuilding("Example Building");
        building.setAddressBuilding("123 Main Street");
        building.setCityBuilding("Cityville");

        return building;
    }
}
