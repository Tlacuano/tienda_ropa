package com.example.servicesbcrypt.security.service;

import com.example.servicesbcrypt.controller.auth.dto.BeanToAuth;
import com.example.servicesbcrypt.model.BeanUser;
import com.example.servicesbcrypt.service.UserService;
import com.example.servicesbcrypt.utils.Encrypt;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class AuthService {
    @Autowired
    private UserService service;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public String loginUserByEmail(BeanToAuth toAuth) throws Exception {

        toAuth.setEmail(Encrypt.decrypt(toAuth.getEmail()));
        toAuth.setPassword(Encrypt.decrypt(toAuth.getPassword()));

        boolean exist = service.userExist(toAuth.getEmail());
        if (!exist) {
            return "false";
        }

        BeanUser user = service.getUser(toAuth.getEmail());
        String sentPassword = toAuth.getPassword();
        String password = user.getPassword();

        return sentPassword.equals(password) ? Encrypt.encrypt(user.getUsername()) : "Esa no es la contraseña papi, pero si le atinaste al correo";
    }
}
