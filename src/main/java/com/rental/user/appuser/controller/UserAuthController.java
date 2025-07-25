package com.rental.user.appuser.controller;

import com.rental.response.Response;
import com.rental.user.appuser.dto.request.AuthenticateUserDto;
import com.rental.user.appuser.dto.response.UserDto;
import com.rental.user.appuser.service.AuthService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
public class UserAuthController {

    private final AuthService authService;

    @PostMapping()
    public ResponseEntity<Response<UserDto>> authenticate(@Valid @RequestBody AuthenticateUserDto request) {
        authService.authenticate(request);
        return ResponseEntity.ok(Response.success("Authenticated successfully",null, HttpStatus.OK));
    }
}