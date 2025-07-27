package com.rental.user.appuser.service;

import com.rental.exception.domain.EmailAlreadyExistException;
import com.rental.exception.domain.UserNotFoundException;
import com.rental.user.appuser.dto.request.CreateUserDto;
import com.rental.user.appuser.dto.response.UserDto;
import com.rental.user.appuser.model.Role;
import com.rental.user.appuser.model.User;
import com.rental.user.appuser.repository.UserRepository;
import com.rental.user.mapper.UserMapper;
import com.rental.user.registrationtoken.RegistrationTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final RegistrationTokenService registrationTokenService;
    private final UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
    }

    public UserDto addUser(CreateUserDto request){

        boolean userExist = userRepository.findByEmail(request.getEmail()).isPresent();

        if(userExist){
            throw new EmailAlreadyExistException();
        }

        User user = new User(
                request.getFirstName(),
                request.getLastName(),
                request.getEmail(),
                bCryptPasswordEncoder.encode(request.getPassword()),
                Role.CLIENT);

        userRepository.save(user);
        registrationTokenService.createToken(user);

        return userMapper.toDto(user);
    }

    public void confirmRegistration(String token){
        registrationTokenService.confirmToken(token);
    }
}
