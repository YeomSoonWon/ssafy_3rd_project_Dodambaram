package com.ficrew.yourbutler.Chat.domain;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
public class Chat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean isBot;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime timeStamp;

    @Column(nullable = false, length = 1000)  // Adjust length as needed
    private String message;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id")
    private Loan loan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chatroom_id")
    private ChatRoom chatRoom;

    public Chat(Boolean isBot, String message, ChatRoom chatRoom) {
        this.isBot = isBot;
        this.message = message;
        this.chatRoom = chatRoom;
    }

    public Chat(Boolean isBot, String message, Loan loan, ChatRoom chatRoom) {
        this.isBot = isBot;
        this.message = message;
        this.loan = loan;
        this.chatRoom = chatRoom;
    }

    protected Chat() {

    }

}
