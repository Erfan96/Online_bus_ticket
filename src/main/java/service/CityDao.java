package service;

import entities.City;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CityDao extends EntityDao<City, Integer>{

    public CityDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<City> getEntityClass() {
        return City.class;
    }

    public List<City> getAllCities() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<City> criteria = cb.createQuery(City.class);
        Root<City> fromCity = criteria.from(City.class);

        criteria.select(fromCity).orderBy(cb.asc(fromCity.get("name")));
        TypedQuery<City> query = entityManager.createQuery(criteria);
        return query.getResultList();
    }
}
