package com.bach_work.yachtwebsite.ships.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Set;
@Setter
@Getter
@Entity
@Table(name = "ships")
public class Ship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Ship_id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Length")
    private int length;
    @Column(name = "Guests")
    private int guests;
    @Column(name = "Rent_cost")
    private int rent_cost;
    @Column(name = "Speed")
    private int speed;
    @Column(name = "Built_year")
    private int built_year;
    @Column(name = "Description")
    private String description;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sh")
    private Set<Image> images ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Location_id")
    private Location location;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Type_id")
    private ShipType shipType;
}
