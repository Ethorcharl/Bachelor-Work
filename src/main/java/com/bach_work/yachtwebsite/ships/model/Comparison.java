package com.bach_work.yachtwebsite.ships.model;
import com.bach_work.yachtwebsite.auth.model.User;
import lombok.Setter;
import lombok.Getter;
import javax.persistence.*;
@Setter
@Getter
@Entity
@Table(name = "comparison")
public class Comparison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int comparison_id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Ship_id")
    private Ship ship;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "User_id")
    private User user;

    @Override
    public String toString() {
        return "Comparison{" +
                "comparison_id=" + comparison_id +
                ", ship=" + ship +
                ", user=" + user +
                '}';
    }
}