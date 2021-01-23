package service;

import entities.Travel;
import javax.persistence.EntityManager;

public class TravelDao extends EntityDao<Travel, Integer> {

    public TravelDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Travel> getEntityClass() {
        return Travel.class;
    }
}
