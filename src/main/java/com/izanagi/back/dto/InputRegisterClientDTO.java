package com.izanagi.back.dto;

import lombok.Data;

@Data
public class InputRegisterClientDTO {
    private String username;
    private String email;
    private String password;
}
