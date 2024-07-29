package com.epam.learning.service;

import com.epam.learning.dto.SignupRequest;
import com.epam.learning.dto.UserDto;

public interface AuthService {

    UserDto singupUser(SignupRequest signupRequest);

    boolean hasUserWithEmail(String email);
}
