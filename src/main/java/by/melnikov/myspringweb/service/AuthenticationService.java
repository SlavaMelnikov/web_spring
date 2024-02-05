package by.melnikov.myspringweb.service;

import by.melnikov.myspringweb.config.JwtService;
import by.melnikov.myspringweb.controller.authentication.AuthenticationRequest;
import by.melnikov.myspringweb.controller.authentication.AuthenticationResponse;
import by.melnikov.myspringweb.controller.authentication.RegisterRequest;
import by.melnikov.myspringweb.model.Role;
import by.melnikov.myspringweb.model.User;
import by.melnikov.myspringweb.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        User user = User.builder()
                .login(request.getLogin())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .status(request.getStatus())
                .name(request.getName())
                .lastName(request.getLastName())
                .role(Role.USER)
                .birthdate(request.getBirthdate())
                .phone(request.getPhone())
                .balance(request.getBalance())
                .ordersCount(request.getOrdersCount())
                .build();
        userRepository.save(user);
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword()));
        User user = userRepository.findByLogin(request.getLogin()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();

    }
}
