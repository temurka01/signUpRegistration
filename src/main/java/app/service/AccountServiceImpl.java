package app.service;

import app.dto.RegistrationDto;
import app.dto.SignUpDto;
import app.model.Account;
import app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void register(RegistrationDto dto) {
        accountRepository.register(Account.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .password(dto.getPassword())
                .login(dto.getLogin())
                .build());
    }

    @Override
    public Account signUp(SignUpDto dto) {
        return accountRepository.signUp(Account.builder()
                .login(dto.getLogin())
                .password(dto.getPassword())
                .build());
    }
}
