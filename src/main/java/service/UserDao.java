package service;

import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class UserDao extends EntityDao<User, Integer>{

    public UserDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }

    public boolean checkUser(String uName, String pass) {
        try {

            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<User> criteria = cb.createQuery(User.class);
            Root<User> fromUser = criteria.from(User.class);

            Predicate predicate = cb.and(
                    cb.equal(fromUser.get("userName"), uName),
                    cb.equal(fromUser.get("password"), pass)
            );

           criteria.select(fromUser).where(predicate);
           entityManager.createQuery(criteria).getSingleResult();

        } catch (NoResultException e) {
            return false;
        }

        return true;
    }

    public User getUserWithUsernameAndPassword(String username, String password) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteria = cb.createQuery(User.class);
        Root<User> fromUser = criteria.from(User.class);

        Predicate predicate = cb.and(
          cb.equal(fromUser.get("userName"), username),
          cb.equal(fromUser.get("password"), password)
        );

        criteria.select(fromUser).where(predicate);
        return entityManager.createQuery(criteria).getSingleResult();
    }
}
