package service;

import entities.Ticket;
import javax.persistence.EntityManager;

public class TicketDao extends EntityDao<Ticket, Integer>{

    public TicketDao(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Ticket> getEntityClass() {
        return Ticket.class;
    }
}
