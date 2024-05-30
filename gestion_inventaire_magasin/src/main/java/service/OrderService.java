package service;

import entity.Order;
import interfaces.Repository;

import java.util.List;

public class OrderService extends BaseService implements Repository<Order> {

    @Override
    public boolean create(Order order) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(order);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Order order) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(order);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Order order) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(order);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Order findById(int id) {
        session = sessionFactory.openSession();
        Order order = session.get(Order.class, id);
        session.close();
        return order;
    }

    @Override
    public List<Order> findAll() {
        session = sessionFactory.openSession();
        List<Order> orders = session.createQuery("from Order", Order.class).list();
        session.close();
        return orders;
    }

    public List<Order> findBySaleId(int id) {
        session = sessionFactory.openSession();
        List<Order> orders = session.createQuery("from Order where sale.id = :id", Order.class).setParameter("id", id).list();
        session.close();
        return orders;
    }
}
