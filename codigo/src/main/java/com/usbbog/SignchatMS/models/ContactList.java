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
@Table(name = "tbl_ContactList")
public class ContactList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idContactList;
    
    @ManyToOne
    @JoinColumn(name = "idUser")
    private User user;

    @ManyToOne
    @JoinColumn(name = "idContact")
    private User contact;

}