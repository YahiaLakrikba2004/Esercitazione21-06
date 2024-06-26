package YahiaLakrikba.Esercitazione21._6.entities;

import YahiaLakrikba.Esercitazione21._6.enums.StationState;
import YahiaLakrikba.Esercitazione21._6.enums.StationType;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "stations")
@Getter
@Setter

public class Station {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @Enumerated(EnumType.STRING)
    private StationType stationType;

    @Enumerated(EnumType.STRING)
    private StationState stationState;

    private Integer numberMaximumSeats;

    @ManyToOne
    @JoinColumn(name = "building_id", nullable = false)
    private Building building;

    public Station( String description, StationType stationType, Integer numberMaximumSeats) {
        this.description = description;
        this.stationType = stationType;
        this.numberMaximumSeats = numberMaximumSeats;
    }

    public Station() {
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", stationType=" + stationType +
                ", stationState=" + stationState +
                ", numberMaximumSeats=" + numberMaximumSeats +
                ", building=" + building +
                '}';
    }
}
