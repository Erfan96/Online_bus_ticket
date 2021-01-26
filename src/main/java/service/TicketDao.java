package service;

import entities.Gender;
import entities.Ticket;
import entities.Travel;
import util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class TicketDao extends EntityDao<Ticket, Integer>{

    public TicketDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }

    public void addTicket(String pName, Gender gender, Travel travel, String tId) {

        entityManager.getTransaction().begin();
        Ticket ticket = new Ticket();
        ticket.setPassengerName(pName);
        ticket.setGender(gender);
        ticket.setTravel(travel);
        ticket.setTicketId(tId);
        save(ticket);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    public Long countTickets() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = cb.createQuery(Long.class);
        Root<Ticket> fromTicket = criteria.from(Ticket.class);

        criteria.select(cb.count(fromTicket.get("id")));

        return entityManager.createQuery(criteria).getSingleResult();
    }
}
