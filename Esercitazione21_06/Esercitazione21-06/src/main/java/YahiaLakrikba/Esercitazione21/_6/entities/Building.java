package YahiaLakrikba.Esercitazione21._6.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "buildings")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nameBuilding;

    @Column(nullable = false)
    private String adressBuilding;

    @Column(nullable = false)
    private String cityBuilding;

    public Building(String nameBuilding, String adressBuilding, String cityBuilding) {
        super();
        this.nameBuilding = nameBuilding;
        this.adressBuilding = adressBuilding;
        this.cityBuilding = cityBuilding;
    }



}