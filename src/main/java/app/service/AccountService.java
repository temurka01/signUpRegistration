package app.service;

import app.dto.RegistrationDto;
import app.dto.SignUpDto;
import app.model.Account;

public interface AccountService {
    void register(RegistrationDto dto);

    Account signUp(SignUpDto dto);
}
