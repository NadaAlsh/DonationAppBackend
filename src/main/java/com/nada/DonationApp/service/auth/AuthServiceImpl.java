package com.nada.DonationApp.service.auth;

import com.nada.DonationApp.bo.auth.AuthenticationResponse;
import com.nada.DonationApp.bo.auth.CreateLoginRequest;
import com.nada.DonationApp.bo.auth.CreateSignUpRequest;
import com.nada.DonationApp.bo.auth.LogoutResponse;
import com.nada.DonationApp.bo.customUserDetail.CustomUserDetails;
import com.nada.DonationApp.config.JWTUtil;
import com.nada.DonationApp.entity.RoleEntity;
import com.nada.DonationApp.entity.UserEntity;
import com.nada.DonationApp.util.enums.BloodType;
import com.nada.DonationApp.exception.BodyGuardException;
import com.nada.DonationApp.exception.UserNotFoundException;
import com.nada.DonationApp.repository.ResearchResultRepository;
import com.nada.DonationApp.repository.RoleRepository;
import com.nada.DonationApp.repository.UserRepository;
import com.nada.DonationApp.util.enums.Gender;
import com.nada.DonationApp.util.enums.Roles;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService userDetailService;
    private final JWTUtil jwtUtil;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final ResearchResultRepository researchResultRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public AuthServiceImpl(AuthenticationManager authenticationManager, CustomUserDetailsService userDetailService, JWTUtil jwtUtil, BCryptPasswordEncoder bCryptPasswordEncoder, ResearchResultRepository researchResultRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailService = userDetailService;
        this.jwtUtil = jwtUtil;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

        this.researchResultRepository = researchResultRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void signup(CreateSignUpRequest createSignupRequest) {

        RoleEntity roleEntity= roleRepository.findRoleEntityByTitle(Roles.user.name())
                .orElseThrow();
        UserEntity user = new UserEntity();
        user.setFullName(createSignupRequest.getFullName());
        user.setUsername(createSignupRequest.getUsername());
        user.setPhoneNumber(createSignupRequest.getPhoneNumber());
        user.setEmail(createSignupRequest.getEmail());
        user.setCivilId(createSignupRequest.getCivilId());
        user.setAge(createSignupRequest.getAge());
        user.setGender(Gender.valueOf(createSignupRequest.getGender()));
        user.setBloodType(BloodType.valueOf(createSignupRequest.getBloodType()));
        user.setPassword(bCryptPasswordEncoder.encode(createSignupRequest.getPassword()));
        user.setRoles(roleEntity);
        userRepository.save(user);
    }


    @Override
    public AuthenticationResponse login(CreateLoginRequest createLoginRequest) {
        requiredNonNull(createLoginRequest.getUsername(),"username");
        requiredNonNull(createLoginRequest.getPassword(),"password");

        String username= createLoginRequest.getUsername().toLowerCase();
        String password= createLoginRequest.getPassword();

        authentication(username, password);

        CustomUserDetails userDetails= userDetailService.loadUserByUsername(username);

        String accessToken = jwtUtil.generateToken(userDetails);

        AuthenticationResponse response = new AuthenticationResponse();
        response.setId(userDetails.getId());
        response.setUsername(userDetails.getUsername());
        response.setRole(userDetails.getRole());
        response.setToken("Bearer "+accessToken);
        return response;
    }

    @Override
    public void logout(LogoutResponse logoutResponse) {
        requiredNonNull(logoutResponse.getToken(), "Token");

    }

    private void requiredNonNull(Object obj, String name) {
        if (obj == null || obj.toString().isEmpty()) {
            throw new BodyGuardException(name + "can not be empty");
        }
    }

    private void authentication(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BodyGuardException e) {
            throw new BodyGuardException("Incorrect password");
        } catch (AuthenticationServiceException e) {
            throw new UserNotFoundException("Incorrect username");
        }
    }
}


