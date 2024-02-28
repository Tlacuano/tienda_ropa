package com.example.servicesbcrypt.controller.auth;

import com.example.servicesbcrypt.controller.auth.dto.BeanToAuth;
import com.example.servicesbcrypt.security.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"*"})
public class authController {
    @Autowired
    private AuthService authService;

    @PostMapping("/")
    public String login (@RequestBody BeanToAuth toAuth) throws Exception {
        return authService.loginUserByEmail(toAuth);
    }
}

