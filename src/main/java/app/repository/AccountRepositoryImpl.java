package app.repository;

import app.model.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    private final DataBaseHibernate hibernate;

    @Autowired
    public AccountRepositoryImpl(DataBaseHibernate hibernate) {
        this.hibernate = hibernate;
    }

    @Override
    public void register(Account account) {
        try (Session session = hibernate.getSession()) {
            session.save(account);
            session.flush();
            int i = 0;
        } catch (RuntimeException e) {
            throw new RuntimeException("не получилось сохранить", e);
        }
    }

    @Override
    public Account signUp(Account account) {
        try (Session session = hibernate.getSession()) {
            Query query = session.createQuery("from Account a where (a.login = :login and a.password = :password)");
            query.setParameter("login", account.getLogin());
            query.setParameter("password", account.getPassword());
            List l = query.list();
            if (!l.isEmpty()) {
                return (Account) l.get(0);
            } else return null;
        } catch (RuntimeException e) {
            throw new RuntimeException("что то пошло не так", e);
        }
    }
}
