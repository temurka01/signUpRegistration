import app.dto.RegistrationDto;
import app.dto.signUpDto;
import app.model.Account;
import app.repository.AccountRepositoryImpl;
import app.repository.DataBaseHibernateImpl;
import app.service.AccountService;
import app.service.AccountServiceImpl;

public class Main {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl(new AccountRepositoryImpl(new DataBaseHibernateImpl()));
        RegistrationDto registrationDto = RegistrationDto.builder()
                .firstName("ijk")
                .login("апроао")
                .lastName("jkbkl")
                .password("апоаоп")
                .build();
        accountService.register(registrationDto);
        int i = 0;
    }
}
