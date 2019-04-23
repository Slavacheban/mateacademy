package dao;

import lombok.extern.log4j.Log4j;
import models.User;
import utils.EntityManagerFactoryUtil;

import javax.persistence.EntityManager;
import java.util.List;

@Log4j
public class UserDaoImpl implements UserDao {
    public EntityManager em = EntityManagerFactoryUtil.entityManagerFactory.createEntityManager();

    public User get(int id) {
        return em.find(User.class, id);
    }

    public void add(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public void update(User user) {
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public List<User> findAll() {
        return null;
    }
}
