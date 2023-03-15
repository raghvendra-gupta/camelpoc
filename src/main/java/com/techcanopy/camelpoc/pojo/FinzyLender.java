package com.techcanopy.camelpoc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinzyLender {

    private String lenderId;
    private String lenderName;
    private double portfolioValue;
    private String panNumber;
    private String fullAddress;
//    private LocalDateTime createdAt = LocalDateTime.now() ;
//    private LocalDateTime updatedAt = LocalDateTime.now() ;
}
