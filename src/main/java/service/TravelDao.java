package service;

import entities.Travel;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TravelDao extends EntityDao<Travel, Integer> {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");

    public TravelDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Travel> getEntityClass() {
        return Travel.class;
    }

    public List<Travel> getTravels(Integer origin, Integer destination, String date) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Travel> criteria = cb.createQuery(Travel.class);
        Root<Travel> fromTravel = criteria.from(Travel.class);

        Predicate predicate = cb.and(
                cb.equal(fromTravel.get("origin").get("id"), origin),
                cb.equal(fromTravel.get("destination").get("id"), destination),
                cb.equal(fromTravel.get("departureDate"), parseDate(date))
        );

        criteria.select(fromTravel).where(predicate).orderBy(cb.asc(fromTravel.get("departureTime")));
        TypedQuery<Travel> query = entityManager.createQuery(criteria);
        return query.getResultList();
    }


    private static Date parseDate(String date){
        try {
            return new Date(DATE_FORMAT.parse(date).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }
    }
}
