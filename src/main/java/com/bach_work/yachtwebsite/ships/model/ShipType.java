package com.bach_work.yachtwebsite.ships.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
@Setter
@Getter
@Entity
@Table(name = "ship_type")
public class ShipType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Type_id;
    @Column(name = "Description")
    private String description;
    @Override
    public String toString() {
        return "ShipType{" +
                "Type_id=" + Type_id +
                ", description='" + description + '\'' +

                '}';
    }
}
