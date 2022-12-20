package com.isa.transfuzija.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isa.transfuzija.dto.LoginDTO;
import com.isa.transfuzija.dto.RegisterDTO;
import com.isa.transfuzija.dto.UserDTO;
import com.isa.transfuzija.model.BloodCenterAdministrator;
import com.isa.transfuzija.model.SystemAdministrator;
import com.isa.transfuzija.model.User;
import com.isa.transfuzija.repository.UserRepository;
import com.isa.transfuzija.response.JwtResponse;
import com.isa.transfuzija.response.MessageResponse;
import com.isa.transfuzija.security.jwt.JwtUtils;
import com.isa.transfuzija.security.service.UserDetailsImpl;
import com.isa.transfuzija.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserService userService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtUtils jwtUtils;

	@GetMapping
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public UserDTO findUser(@PathVariable Long id) {
		return userService.findById(id);
	}

	@GetMapping("/activate/{verificationToken}")
	public ResponseEntity<User> findUserByVerificationToken(@PathVariable String verificationToken) {
		User user = userRepository.findByVerificationToken(verificationToken);
		if (user == null) {
			return new ResponseEntity<User>(user, HttpStatus.NO_CONTENT);
		} else {
			user.setVerificationToken(null);
			user.setEnabled(true);
			userRepository.save(user);
		}
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterDTO registerDTO)
			throws UnsupportedEncodingException {
		if (userRepository.existsByEmail(registerDTO.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		userService.save(registerDTO);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));

	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@Valid @RequestBody LoginDTO loginDTO) {
		User user = userRepository.findByEmail(loginDTO.getEmail()).get();

		if (user.getEnabled() == false) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {

			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmail(), loginDTO.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			String jwt = jwtUtils.generateJwtToken(authentication);

			UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
			Set<String> roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority())
					.collect(Collectors.toSet());

			return ResponseEntity.ok(new JwtResponse(jwt, userDetails.getId(), userDetails.getUsername(),
					userDetails.getEmail(), roles));
		}
	}

	@PostMapping("/addAdmin")
	public ResponseEntity<?> admin(@Valid @RequestBody SystemAdministrator admin) {
		if (userRepository.existsByEmail(admin.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		userService.addAdmin(admin);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

	@PostMapping("/addCenter")
	public ResponseEntity<?> center(@Valid @RequestBody BloodCenterAdministrator admin) {
		if (userRepository.existsByEmail(admin.getEmail())) {
			return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
		}

		userService.addCenterAdmin(admin);
		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}

}
