package com.example.tmo.domain.user.facade;

import com.example.tmo.domain.user.domain.User;
import com.example.tmo.domain.user.domain.repository.UserRepository;
import com.example.tmo.domain.user.exception.PasswordNotMatchException;
import com.example.tmo.domain.user.exception.UserNotFoundException;
import com.example.tmo.global.error.handler.TmoException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();

        return userRepository.findByEmail(email)
                .orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }

    public void checkPassword(User user, String password) {
        if(!passwordEncoder.matches(password, user.getPassword())) {
            throw PasswordNotMatchException.EXCEPTION;
        }
    }

    public Long getUserId()  {
        return getCurrentUser().getId();
    }

}