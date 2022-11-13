package com.example.carwashwebappbackend.dao;

import com.example.carwashwebappbackend.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAORepository implements UserDAO{
    private EntityManager entityManager;

    @Autowired
    public UserDAORepository(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public List<User> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<User> theQuery =
                currentSession.createQuery("from user", User.class);

        return theQuery.getResultList();
    }
}
