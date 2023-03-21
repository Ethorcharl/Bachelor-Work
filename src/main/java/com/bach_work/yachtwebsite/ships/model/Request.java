package com.bach_work.yachtwebsite.ships.model;
import com.bach_work.yachtwebsite.auth.model.User;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
@Setter
@Getter
@Entity
@Table(name = "request")
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Request_id;
    @Column(name = "Description")
    private String description;
    @Column(name = "Datestart")
    private Date datestart;
    @Column(name = "Dateend")
    private Date dateend;
    @Column(name = "Datesending")
    private Date datesending;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "Status")
    private Status_request status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "User_id_user")
    private User user_user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "User_id_manager")
    private User user_manager;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Ship_id")
    private com.bach_work.yachtwebsite.ships.model.Ship ship;
}
