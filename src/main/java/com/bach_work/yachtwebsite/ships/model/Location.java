package com.bach_work.yachtwebsite.ships.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Location_id;
    @Column(name = "City")
    private String city;
    @Column(name = "Country")
    private String country;

    @Override
    public String toString() {
        return "Location{" +
                "Location_id=" + Location_id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
