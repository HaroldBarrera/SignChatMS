package com.usbbog.SignchatMS.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tbl_Message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idMessage;

    @Column(nullable = true)
    private String messageText;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime registrationDate;

    @ManyToOne
    @JoinColumn(name = "senderIdUser")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiverIdUser")
    private User receiver;

    public Message(String messageText) {
        this.messageText = messageText;
    }

    @PrePersist
    public void setRegistrationDate(){
        this.registrationDate = LocalDateTime.now();
    }
    
}