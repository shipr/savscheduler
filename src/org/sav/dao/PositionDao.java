package org.sav.dao;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.sav.domain.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionDao{

    @Autowired
    private SessionFactory sessionFactory;


    public List<Position> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Position.class).list();
    }


    public Position create(String name) {
        Position position = new Position();
        position.setName(name);
        sessionFactory.getCurrentSession().persist(position);
        return position;
    }

    public void update(long positionId, String name) {
        Session session = sessionFactory.getCurrentSession();
        Position position = (Position)session.get(Position.class, positionId);
        position.setName(name);
        session.update(position);
    }

    public void delete(long positionId) {
        Session session = sessionFactory.getCurrentSession();
        Position position = (Position)session.get(Position.class, positionId);
        session.delete(position);
    }
}
