package service;

import entity.Client;
import interfaces.Repository;

import java.util.List;

public class ClientService extends BaseService implements Repository<Client> {
    public ClientService() {
        super();
    }
    @Override
    public boolean create(Client client) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Client client) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(client);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Client client) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(client);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Client findById(int id) {
        session = sessionFactory.openSession();
        Client client = session.get(Client.class, id);
        session.close();
        return client;
    }

    @Override
    public List<Client> findAll() {
        session = sessionFactory.openSession();
        List<Client> clients = session.createQuery("from Client", Client.class).list();
        session.close();
        return clients;
    }
}
