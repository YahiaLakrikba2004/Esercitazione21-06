package YahiaLakrikba.Esercitazione21._6.repositories;

import java.util.List;

import YahiaLakrikba.Esercitazione21._6.entities.Station;
import YahiaLakrikba.Esercitazione21._6.entities.Building;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends CrudRepository<Station, Long> {


    List<Station> findByBuilding(Building building);
}
