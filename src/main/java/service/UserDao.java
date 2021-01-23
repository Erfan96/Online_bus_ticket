package service;

import entities.User;
import javax.persistence.EntityManager;

public class UserDao extends EntityDao<User, Integer>{

    public UserDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
