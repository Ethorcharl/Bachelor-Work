package com.bach_work.yachtwebsite.ships.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "Images")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Image_id;
    @Column(name = "Path")
    private String path;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Ship_id")
    private com.bach_work.yachtwebsite.ships.model.Ship sh;
    @Override
    public String toString() {
        return "Image{" +
                "Image_id=" + Image_id +
                ", path='" + path + '\'' +
                ", sh=" + sh +
                '}';
    }
}
