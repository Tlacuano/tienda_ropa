package com.example.servicesbcrypt.controller.auth.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BeanToAuth {
    private String email;
    private String password;
}
