package YahiaLakrikba.Esercitazione21._6.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "buildings")
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameBuilding;

    @Column(nullable = false)
    private String addressBuilding;

    @Column(nullable = false)
    private String cityBuilding;

    public Building() {
    }

    public Building(String nameBuilding, String addressBuilding, String cityBuilding) {
        this.nameBuilding = nameBuilding;
        this.addressBuilding = addressBuilding;
        this.cityBuilding = cityBuilding;
    }

}
