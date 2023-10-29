package com.usbbog.SignchatMS.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbl_User")
public class User{

    //Variables

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    @Column(nullable = false)
    private String userCompleteName;
    
    @Column(nullable = false, unique = true)
    private String userNickname;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private boolean userIsDeaf;

}