package com.onlineStore.onlineStore.Registration;

import com.onlineStore.onlineStore.Entity.AppUserRole;
import com.onlineStore.onlineStore.Entity.AppUserService;
import com.onlineStore.onlineStore.Entity.User;
import com.onlineStore.onlineStore.Registration.Token.ConfirmationToken;
import com.onlineStore.onlineStore.Registration.Token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class RegistrationService {
    private EmailValidator emailValidator;
    private final AppUserService appUserService;
    private final ConfirmationTokenService confirmationTokenService;
    public String register(RegistrationRequest registrationRequest) {
        boolean isValidEmail = emailValidator
                .test(registrationRequest.getEmail());
        if(!isValidEmail){
            throw new IllegalStateException("email is not valid");
        }
        return appUserService.singUpUser(new User(
                registrationRequest.getFirst_name(),
                registrationRequest.getLast_name(),
                registrationRequest.getEmail(),
                registrationRequest.getPassword(),
                AppUserRole.USER

        ));
    }

    @Transactional
    public String ConfirmToken(String token){
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token).orElseThrow(() ->
                        new IllegalStateException("Token not found"));
        if(confirmationToken.getConfirmedAt() != null){
            throw new IllegalStateException("email already confirmed");
        }
        LocalDateTime expiredAt = confirmationToken.getExpiresAt();

        if(expiredAt.isBefore(LocalDateTime.now())){
            throw new IllegalStateException("Token expired");
        }
        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(confirmationToken.getUser().getEmail());
        return "Confirmed";
    }
}
