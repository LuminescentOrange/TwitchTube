package com.jupiter.dao;

import com.jupiter.entity.db.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceException;

@Repository
public class RegisterDao {

    @Autowired
    private SessionFactory sessionFactory;

    public boolean register(User user) {
        Session session = null;

        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (PersistenceException | IllegalStateException ex) {
            // if hibernate throws this exception, it means the user already be register
            ex.printStackTrace();
            session.getTransaction().rollback();// back to the condition before register
            return false; //register fall
        } finally {
            if (session != null) session.close();
        }
        return true;
    }
}
