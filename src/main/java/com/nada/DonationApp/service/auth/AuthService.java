package com.nada.DonationApp.service.auth;

import com.nada.DonationApp.bo.auth.AuthenticationResponse;
import com.nada.DonationApp.bo.auth.CreateLoginRequest;
import com.nada.DonationApp.bo.auth.CreateSignUpRequest;
import com.nada.DonationApp.bo.auth.LogoutResponse;

public interface AuthService {
    AuthenticationResponse signup(CreateSignUpRequest createSignupRequest);
    AuthenticationResponse login(CreateLoginRequest createLoginRequest);
    void logout(LogoutResponse logoutResponse);
}
