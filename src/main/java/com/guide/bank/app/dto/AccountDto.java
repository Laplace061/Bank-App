package com.guide.bank.app.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class AccountDto {

    private UUID accountId;
    private String accountHolderName;
    private double balance;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
