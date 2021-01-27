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
import javax.persistence.criteria.Join;
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

    public List<Tuple> getDetailsOfTicket(String ticketId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tuple> criteria = cb.createTupleQuery();
        Root<Ticket> fromTicket = criteria.from(Ticket.class);

        Join<Ticket, Travel> ticketTravelJoin = fromTicket.join("travel");
        criteria.multiselect(fromTicket.get("ticketId"), fromTicket.get("passengerName"),
                fromTicket.get("gender"),ticketTravelJoin.get("origin").get("name")
                , ticketTravelJoin.get("destination").get("name"), fromTicket.get("travel").get("departureDate"),
                fromTicket.get("travel").get("departureTime"), fromTicket.get("travel").get("travelId"))
                .where(cb.equal(fromTicket.get("ticketId"), ticketId));

        TypedQuery<Tuple> query = entityManager.createQuery(criteria);
        return query.getResultList();
    }

    public void removeTicket(String ticketId) {
        entityManager.getTransaction().begin();
        Ticket ticket = getTicketWithId(ticketId);
        delete(ticket);

        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Ticket getTicketWithId(String ticketId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> criteria = cb.createQuery(Ticket.class);
        Root<Ticket> fromTicket = criteria.from(Ticket.class);

        criteria.select(fromTicket).where(cb.equal(fromTicket.get("ticketId"), ticketId));
        TypedQuery<Ticket> query = entityManager.createQuery(criteria);
        return query.getSingleResult();
    }
}
