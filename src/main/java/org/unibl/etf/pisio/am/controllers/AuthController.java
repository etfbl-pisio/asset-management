package org.unibl.etf.pisio.am.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.pisio.am.models.dto.JwtUser;
import org.unibl.etf.pisio.am.models.dto.LoginResponse;
import org.unibl.etf.pisio.am.models.requests.LoginRequest;
import org.unibl.etf.pisio.am.models.requests.SignUpRequest;
import org.unibl.etf.pisio.am.services.AuthService;
import org.unibl.etf.pisio.am.services.UserService;

import javax.validation.Valid;

@RestController
public class AuthController {

    private final AuthService service;
    private final UserService userService;

    public AuthController(AuthService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @PostMapping("login")
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {
        return service.login(request);
    }

    @GetMapping("state")
    public LoginResponse state(Authentication auth) {
        JwtUser jwtUser = (JwtUser) auth.getPrincipal();
        return userService.findById(jwtUser.getId(), LoginResponse.class);
    }

    @PostMapping("sign-up")
    public void signUp(@RequestBody @Valid SignUpRequest request) {
        userService.signUp(request);
    }
}
