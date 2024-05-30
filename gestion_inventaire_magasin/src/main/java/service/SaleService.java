package service;

import entity.Sale;
import interfaces.Repository;

import java.util.List;

public class SaleService extends BaseService implements Repository<Sale> {

    @Override
    public boolean create(Sale sale) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(sale);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Sale sale) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(sale);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Sale sale) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(sale);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Sale findById(int id) {
        session = sessionFactory.openSession();
        Sale sale = session.get(Sale.class, id);
        sale.getOrders().size();
        session.close();
        return sale;
    }

    @Override
    public List<Sale> findAll() {
        session = sessionFactory.openSession();
        List<Sale> sales = session.createQuery("from Sale", Sale.class).list();
        session.close();
        return sales;
    }

    public int countAll(){
        session = sessionFactory.openSession();
        Integer count = session.createQuery("select count(s) from Sale s", Integer.class).uniqueResult();
        session.close();
        return count;
    }

    public int countByItemId(int itemId) {
        session = sessionFactory.openSession();
        Integer count = session.createQuery("select count(o) from Order o where item= :item", Integer.class)
                .setParameter("item", itemId).uniqueResult();
        session.close();
        return count;
    }
}
