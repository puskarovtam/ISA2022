package com.isa.transfuzija.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.isa.transfuzija.dto.RegisterDTO;
import com.isa.transfuzija.dto.UserDTO;
import com.isa.transfuzija.enums.RoleName;
import com.isa.transfuzija.model.BloodCenterAdministrator;
import com.isa.transfuzija.model.RegisteredClient;
import com.isa.transfuzija.model.Role;
import com.isa.transfuzija.model.SystemAdministrator;
import com.isa.transfuzija.model.User;
import com.isa.transfuzija.repository.BloodCenterAdministratorRepository;
import com.isa.transfuzija.repository.RegisteredClientRepository;
import com.isa.transfuzija.repository.SystemAdministratorRepository;
import com.isa.transfuzija.repository.UserRepository;
import com.isa.transfuzija.service.EmailService;
import com.isa.transfuzija.service.RoleService;
import com.isa.transfuzija.service.UserService;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RegisteredClientRepository registeredClientRepository;
	@Autowired
	private SystemAdministratorRepository systemAdministratorRepository;
	@Autowired
	private BloodCenterAdministratorRepository bloodCenterAdministratorRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleService roleService;
	@Autowired
	private EmailService emailService;

	@Override
	public UserDTO findById(Long id) {
		User user = userRepository.findById(id).orElseGet(null);
		UserDTO userDTO = new UserDTO(user);
		return userDTO;
	}

	@Override
	public UserDTO findByEmail(String email) {
		User user = userRepository.findByEmail(email).orElseGet(null);
		UserDTO userDTO = new UserDTO(user);
		return userDTO;
	}

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> usersDTO = new ArrayList<>();
		List<User> users = userRepository.findAll();

		for (User u : users) {
			usersDTO.add(new UserDTO(u));
		}
		return usersDTO;
	}

	@Override
	public User save(RegisterDTO userDTO) throws UnsupportedEncodingException {
		RegisteredClient rc = new RegisteredClient();
		rc.setEmail(userDTO.getEmail());
		rc.setPassword(passwordEncoder.encode(userDTO.getPassword()));
		rc.setName(userDTO.getName());
		rc.setSurname(userDTO.getSurname());
		rc.setAddress(userDTO.getAddress());
		rc.setCity(userDTO.getCity());
		rc.setCountry(userDTO.getCountry());
		rc.setPhoneNumber(userDTO.getPhoneNumber());
		rc.setEnabled(false);
		Set<Role> roles = roleService.findByName(RoleName.REGISTERED_CLIENT);
		rc.setRoles(roles);
		rc.setJmbg(userDTO.getJmbg());
		rc.setGender(userDTO.getGender());
		rc.setOccupation(userDTO.getOccupation());
		rc.setJobInformation(userDTO.getJobInformation());
		rc.setBlocked(false);
		rc.setPenalties(0);
		String randomCode = RandomString.make(64);
		rc.setVerificationToken(randomCode);

		emailService.sendRegistrationEmail(rc);

		return registeredClientRepository.save(rc);
	}

	@Override
	public User addAdmin(SystemAdministrator admin) {
		SystemAdministrator sa = new SystemAdministrator();
		sa.setEmail(admin.getEmail());
		sa.setPassword(passwordEncoder.encode("123456"));
		sa.setName(admin.getName());
		sa.setSurname(admin.getSurname());
		sa.setAddress(admin.getAddress());
		sa.setCity(admin.getCity());
		sa.setCountry(admin.getCountry());
		sa.setPhoneNumber(admin.getPhoneNumber());
		Set<Role> roles = roleService.findByName(RoleName.SYSTEM_ADMINISTRATOR);
		sa.setRoles(roles);
		sa.setEnabled(true);

		return systemAdministratorRepository.save(sa);
	}

	@Override
	public User addCenterAdmin(BloodCenterAdministrator admin) {
		BloodCenterAdministrator bca = new BloodCenterAdministrator();
		bca.setEmail(admin.getEmail());
		bca.setPassword(passwordEncoder.encode("123456"));
		bca.setName(admin.getName());
		bca.setSurname(admin.getSurname());
		bca.setAddress(admin.getAddress());
		bca.setCity(admin.getCity());
		bca.setCountry(admin.getCountry());
		bca.setPhoneNumber(admin.getPhoneNumber());
		Set<Role> roles = roleService.findByName(RoleName.CENTER_ADMINISTRATOR);
		bca.setRoles(roles);
		bca.setEnabled(true);

		return bloodCenterAdministratorRepository.save(bca);
	}

}
