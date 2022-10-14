package ru.kata.spring.boot_security.demo.dao;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() == null) {
            entityManager.persist(user);
        } else {entityManager.merge(user);}

    }

    @Override
    public User getUser(long id) {
        return entityManager.find(User.class, id);
    }


    @Override
    public void deleteUserById(long id) {
        if (id != 0) {
            entityManager.remove(entityManager.find(User.class, id));
        }
    }

    @Override
    public UserDetails findUserByUsername(String username) {

        TypedQuery<User> query = (entityManager.createQuery("select user from User user " +
                "join fetch user.roles where user.username = :username",User.class));
        query.setParameter("username",username);
        return query.getResultList().stream().findFirst().orElse(null);
    }

}
