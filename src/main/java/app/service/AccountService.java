package app.service;

import app.dto.RegistrationDto;
import app.dto.signUpDto;
import app.model.Account;

public interface AccountService {
    void register(RegistrationDto dto);
    Account signUp(signUpDto dto);
}
