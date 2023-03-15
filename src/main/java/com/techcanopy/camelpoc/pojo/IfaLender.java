package com.techcanopy.camelpoc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class IfaLender {

    private String uuid;
    private String firstName;
    private String lastName;
    private String pan;
    private String address1;
    private String address2;
    private double investmentAmount;
}
