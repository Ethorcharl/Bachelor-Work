package com.bach_work.yachtwebsite.auth.model;
import lombok.Data;
import javax.persistence.*;
@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Userid; //was long
    @Column(name = "Name")
    private String name;
    @Column(name = "Surname")
    private String surname;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "Role")
    private Role role;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "Status")
    private Status status;
}
