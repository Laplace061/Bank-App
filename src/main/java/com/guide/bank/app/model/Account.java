package com.guide.bank.app.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.grammars.hql.HqlParser;

import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "Accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "AccountId")
    private UUID accountId;

    @Column(name = "AccountName")
    private String accountHolderName;

    @Column(name = "Balances")
    private double balance;

    @Column(name = "CreatedOn")
    private LocalDateTime createdOn;

    @Column(name = "UpdatedOn")
    private LocalDateTime updatedOn;


}
