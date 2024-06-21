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
    public User createFakeUser() {
        User user = new User();


        user.setUsername("fake_user");
        user.setFirstName("John");
        user.setLastName("Doe");
        user.setCity("New York");
        user.setEmail("john.doe@example.com");

        return user;
    }


}