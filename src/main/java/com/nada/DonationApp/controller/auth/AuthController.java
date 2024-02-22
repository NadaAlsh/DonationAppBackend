package com.nada.DonationApp.controller.auth;

import com.nada.DonationApp.bo.auth.AuthenticationResponse;
import com.nada.DonationApp.bo.auth.CreateLoginRequest;
import com.nada.DonationApp.bo.auth.CreateSignUpRequest;
import com.nada.DonationApp.bo.auth.LogoutResponse;
import com.nada.DonationApp.service.auth.AuthService;
import com.nada.DonationApp.service.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody CreateSignUpRequest createSignUpRequest){
        logger.info("Received request: {}", createSignUpRequest);
        System.out.println(createSignUpRequest);
        authService.signup(createSignUpRequest);
        return ResponseEntity.ok("User created");
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody CreateLoginRequest createLoginRequest) {
        AuthenticationResponse response = authService.login(createLoginRequest);
        HttpStatus status = HttpStatus.OK;
        if (response == null) {
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, status);
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutResponse logoutResponse) {
        authService.logout(logoutResponse);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

