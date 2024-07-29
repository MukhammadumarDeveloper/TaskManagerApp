package com.epam.learning.dto;


import lombok.Data;

@Data
public class SignupRequest {

    private String name;

    private String email;

    private String password;

}
