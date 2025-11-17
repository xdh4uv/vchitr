package com.vichitr.springboot.vchitr.DTO.landingPageDTO;


// for user, we need the email_id, password, uuid for the user ( to check if user already exists ) and a remember me boolean

import com.fasterxml.jackson.annotation.JsonProperty;

public record userLoginDTO(
        @JsonProperty("uuid_user")
        Integer uuid,

        @JsonProperty("user_email")
        String userEmail,

        @JsonProperty("user_password")
        String userPassword,

        @JsonProperty("remember_me")
        Boolean userRemember

        ) { }