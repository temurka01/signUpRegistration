package app.repository;

import org.hibernate.Session;

public interface DataBaseHibernate {
    Session getSession();
}
