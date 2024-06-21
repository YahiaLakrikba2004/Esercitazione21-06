package YahiaLakrikba.Esercitazione21._6.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import YahiaLakrikba.Esercitazione21._6.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Query(value = "SELECT * FROM users WHERE id = :id", nativeQuery = true)
    User findByIdNativeQuery(@Param("id") Long id);


    @Query("SELECT u FROM User u WHERE u.city = :city")
    List<User> findByCity(@Param("city") String city);


    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findByUsername(@Param("username") String username);


}
