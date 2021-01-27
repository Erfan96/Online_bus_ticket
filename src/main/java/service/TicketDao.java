package service;

import entities.Gender;
import entities.Ticket;
import entities.Travel;
import entities.User;
import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TicketDao extends EntityDao<Ticket, Integer>{

    public TicketDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }

    public void addTicket(String pName, Gender gender, Travel travel, String tId, User user) {

        entityManager.getTransaction().begin();
        Ticket ticket = new Ticket();
        ticket.setPassengerName(pName);
        ticket.setGender(gender);
        ticket.setTravel(travel);
        ticket.setTicketId(tId);
        ticket.setUser(user);
        save(ticket);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public List<Tuple> getDateAndId(User user) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteria = cb.createTupleQuery();
        Root<Ticket> fromTicket = criteria.from(Ticket.class);

        criteria.multiselect(fromTicket.get("ticketId"), fromTicket.get("travel").get("departureDate"))
                .where(cb.equal(fromTicket.get("user"), user));

        TypedQuery<Tuple> query = entityManager.createQuery(criteria);
        return query.getResultList();
    }
}
