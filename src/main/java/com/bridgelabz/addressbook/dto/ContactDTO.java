package com.bridgelabz.addressbook.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactDTO {
    @Pattern(regexp = "^[A-Z][a-zA-Z]{2,}$",message = "Not valid")
    private String name;
    private String city;
    private String state;
    private String address;
    private List<String> phoneNumber;
    private int zipCode;
    private String email;
}
