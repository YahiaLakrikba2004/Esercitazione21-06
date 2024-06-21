package YahiaLakrikba.Esercitazione21._6.repositories;

import java.time.LocalDate;
import java.util.List;

import YahiaLakrikba.Esercitazione21._6.entities.Booking;
import YahiaLakrikba.Esercitazione21._6.entities.Station;
import YahiaLakrikba.Esercitazione21._6.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {

    @Query(value = "SELECT b FROM Booking b INNER JOIN b.user u WHERE u = :user")
    public List<Booking> findByUser(User user);

    @Query(value = "SELECT b FROM Booking b INNER JOIN b.user u WHERE u = :user AND b.date = :date")
    public List<Booking> findByUserAndDate(User user, LocalDate date);

    @Query(value = "SELECT b FROM Booking b INNER JOIN b.station s WHERE s = :station AND b.date = :date")
    public List<Booking> findByStationAndDate(Station station, LocalDate date);
}
