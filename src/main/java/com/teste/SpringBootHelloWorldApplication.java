package com.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.teste.entity.Usuario;
import com.teste.model.UserDTO;
import com.teste.repository.UsuarioRepository;
import com.teste.service.JwtUserDetailsService;

@SpringBootApplication
public class SpringBootHelloWorldApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldApplication.class, args);
	}

	
	@Component
	class DemoCommandLineRunner implements CommandLineRunner{

		@Autowired
		private JwtUserDetailsService jwtUser;


		@Override
		public void run(String... args) throws Exception {

			UserDTO user1 = new UserDTO();
			user1.setUsername("admin");
			user1.setPassword("123456");
			user1.setRole("ROLE_ADMIN");
			jwtUser.save(user1);

			UserDTO user2 = new UserDTO();
			user2.setUsername("comum");
			user2.setPassword("123456");
			user2.setRole("ROLE_USER");
			jwtUser.save(user2);
		}
	}
}