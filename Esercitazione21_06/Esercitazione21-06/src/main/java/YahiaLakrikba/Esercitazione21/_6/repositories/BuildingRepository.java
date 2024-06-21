package YahiaLakrikba.Esercitazione21._6.repositories;

import YahiaLakrikba.Esercitazione21._6.entities.Building;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Long> {

    @Query(value = "SELECT * FROM buildings ORDER BY RANDOM() LIMIT 1", nativeQuery = true)
    public Building getRandomBuilding();

}
