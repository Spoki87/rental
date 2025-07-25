package com.rental.user.registrationtoken;

import com.rental.email.EmailSender;
import com.rental.exception.domain.ResourceNotFoundException;
import com.rental.user.appuser.model.User;
import com.rental.user.appuser.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RegistrationTokenService {

    private final RegistrationTokenRepository registrationTokenRepository;
    private final EmailSender emailSender;
    private final UserRepository userRepository;
    private final TemplateEngine templateEngine;

    @Value("${app.base-url}")
    private String BASE_URL;

    public void createToken(User user) {

        String token = UUID.randomUUID().toString();

        RegistrationToken registrationToken = new RegistrationToken(user,token);

        registrationTokenRepository.save(registrationToken);

        String confirmationLink = String.format("%s/api/user/confirm?token=%s",BASE_URL,token);

        Context context = new Context();
        context.setVariable("confirmationLink", confirmationLink);

        String htmlContent = templateEngine.process("confirm_account", context);

        emailSender.send(user.getEmail(), htmlContent,"Confirmation of registration");
    }

    public void confirmToken(String token) {
        RegistrationToken registrationToken = registrationTokenRepository.findByToken(token)
                .orElseThrow(()->new ResourceNotFoundException(RegistrationToken.class, token));

        if(registrationToken.getConfirmedTime() != null){
            throw new IllegalStateException("Account already confirmed");
        }

        LocalDateTime expiredAt = registrationToken.getExpiredTime();

        if (expiredAt.isBefore(LocalDateTime.now())) {
            createToken(registrationToken.getUser());
            registrationTokenRepository.delete(registrationToken);
            throw new IllegalStateException("Token expired. New token has been sent to your email");
        }

        registrationToken.setConfirmedTime();
        userRepository.enableUser(registrationToken.getUser().getEmail());
    }
}
