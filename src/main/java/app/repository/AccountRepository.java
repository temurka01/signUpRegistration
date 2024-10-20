package app.repository;

import app.model.Account;


public interface AccountRepository {
    void register(Account account);

    Account signUp(Account account);
}
