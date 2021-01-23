package service;

import entities.City;
import javax.persistence.EntityManager;

public class CityDao extends EntityDao<City, Integer>{

    public CityDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<City> getEntityClass() {
        return City.class;
    }
}
