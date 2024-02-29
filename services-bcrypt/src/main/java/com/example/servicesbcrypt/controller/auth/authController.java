package com.example.servicesbcrypt.controller.auth;

import com.example.servicesbcrypt.controller.auth.dto.BeanToAuth;
import com.example.servicesbcrypt.security.service.AuthService;
import com.example.servicesbcrypt.utils.Encrypt;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = {"*"})
public class authController {
    @Autowired
    private AuthService authService;
    @Value("${encrypt.secret.key}")
    private String secretKey;

    @PostMapping("/")
    public String login (@RequestBody String jsonCifrado) throws Exception {
        String decryptedString = Encrypt.decryptObject(jsonCifrado, secretKey);
        JSONObject jsonObject = new JSONObject(decryptedString);

        String email = jsonObject.getString("email");
        String password = jsonObject.getString("password");
        BeanToAuth toAuth = new BeanToAuth(email, password);
        return authService.loginUserByEmail(toAuth);
    }
}

