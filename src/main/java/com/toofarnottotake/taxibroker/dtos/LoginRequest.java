package com.toofarnottotake.taxibroker.dtos;

import lombok.Data;

@Data
public class LoginRequest {
    String email;
    String password;
}
