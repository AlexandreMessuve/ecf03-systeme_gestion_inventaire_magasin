package service;

import entity.Item;
import interfaces.Repository;

import java.util.List;

public class ItemService extends BaseService implements Repository<Item> {
    public ItemService() {
        super();
    }

    @Override
    public boolean create(Item item) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(item);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Item item) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(item);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Item item) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(item);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Item findById(int id) {
        session = sessionFactory.openSession();
        Item item = session.get(Item.class, id);
        session.close();
        return item;
    }

    @Override
    public List<Item> findAll() {
        session = sessionFactory.openSession();
        List<Item> items = session.createQuery("from Item", Item.class).list();
        session.close();
        return items;
    }
}
