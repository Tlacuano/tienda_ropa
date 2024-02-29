package com.example.servicesbcrypt;

import com.example.servicesbcrypt.utils.Encrypt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServicesBcryptApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ServicesBcryptApplication.class, args);
		System.out.println(Encrypt.decrypt("btnx3SDwSVpP1N7pCYhVnz6chsEUwp7VUZrvQcJFTNjRburuMw1KFjbqUFNWcCSYOt9ikhb5LdnSBi/EIq1hTEncpEKyGLSlbb2SNbj8JJU="));
	}
}
