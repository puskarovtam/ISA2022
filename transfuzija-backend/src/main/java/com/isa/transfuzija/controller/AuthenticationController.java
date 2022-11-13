package com.isa.transfuzija.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.transfuzija.dto.RegisterDTO;
import com.isa.transfuzija.repository.RoleRepository;
import com.isa.transfuzija.repository.UserRepository;
import com.isa.transfuzija.response.MessageResponse;
import com.isa.transfuzija.security.jwt.JwtUtils;
import com.isa.transfuzija.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private JwtUtils jwtUtils;

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDTO registerDTO) {
		if (userRepository.existsByEmail(registerDTO.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		userService.save(registerDTO);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

	}

}
