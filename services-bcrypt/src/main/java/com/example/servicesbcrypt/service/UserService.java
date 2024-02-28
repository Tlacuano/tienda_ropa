package com.example.servicesbcrypt.service;

import com.example.servicesbcrypt.model.BeanUser;
import com.example.servicesbcrypt.model.RepositoryUser;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    @Autowired
    private RepositoryUser repositoryUser;
    private PasswordEncoder passwordEncoder;

    public BeanUser insertUser(BeanUser user){
        String hashPass = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashPass);
        return repositoryUser.saveAndFlush(user);
    }

    public BeanUser getUser(String email){
        return repositoryUser.findBeanUserByEmail(email);
    }

    public boolean userExist(String email) {
        return repositoryUser.existsBeanUserByEmail(email);
    }
}
