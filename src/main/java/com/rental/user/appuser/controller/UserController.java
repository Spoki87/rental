package com.rental.user.appuser.controller;

import com.rental.response.Response;
import com.rental.user.appuser.dto.request.CreateUserDto;
import com.rental.user.appuser.dto.response.UserDto;
import com.rental.user.appuser.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<Response<UserDto>> register(@Valid @RequestBody CreateUserDto request) {
        UserDto userDto = userService.addUser(request);
        return ResponseEntity.ok(Response.success("Account registered",userDto, HttpStatus.CREATED));
    }

    @GetMapping("/confirm")
    public ResponseEntity<Response<String>> confirmRegistration(@RequestParam String token) {
        userService.confirmRegistration(token);
        return ResponseEntity.ok(Response.success("Account confirmed",null,HttpStatus.OK));
    }
}