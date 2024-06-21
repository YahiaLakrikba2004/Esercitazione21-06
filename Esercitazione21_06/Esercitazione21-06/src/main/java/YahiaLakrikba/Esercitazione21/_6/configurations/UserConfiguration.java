package YahiaLakrikba.Esercitazione21._6.configurations;


import java.util.Locale;


import YahiaLakrikba.Esercitazione21._6.entities.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;



@Configuration
@PropertySource("classpath:application.properties")
public class UserConfiguration {

    @Bean("User")
    @Scope("prototype")
    User userData(String username, String firstName, String lastName, String city, String email) {
        return new User(username, firstName, lastName, city, email);
    }

    @Bean("FakeUser")
    @Scope("prototype")
    User fakeUser() {
        Faker faker = Faker.instance(new Locale("en-US"));
        User user = new User();
        user.setUsername(user.getLastName() + "." + user.getFirstName() + "0");
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setCity(faker.address().cityName());
        user.setEmail(user.getFirstName() + "." + user.getLastName() + "@domain.com");
        return user;
    }

}