package br.com.trainning.DAO;

import br.com.trainning.model.Agenda;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AgendaDAO {

    private static AgendaDAO instance;
    protected EntityManager entityManager;

    public static AgendaDAO getInstance() {
        if (instance == null) {
            instance = new AgendaDAO();
        }

        return instance;
    }

    public AgendaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("agendaPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Agenda getById(final int id) {
        return entityManager.find(Agenda.class, id);
    }

    public boolean salvar(Agenda agenda) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(agenda);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(AgendaDAO.class.getName()).
                    log(Level.SEVERE, null, ex);

            entityManager.getTransaction().rollback();

        }
        return true;
    }

    public boolean atualizar(Agenda agenda) {

        try {
            entityManager.getTransaction().begin();
            entityManager.merge(agenda);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(AgendaDAO.class.getName()).
                    log(Level.SEVERE, null, ex);

            entityManager.getTransaction().rollback();

        }
        return true;
    }
    
    public boolean remover(Agenda agenda) {

        try {
            entityManager.getTransaction().begin();
            agenda= entityManager.find(Agenda.class, agenda.getId());
            entityManager.remove(agenda);
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            Logger.getLogger(AgendaDAO.class.getName()).
                    log(Level.SEVERE, null, ex);

            entityManager.getTransaction().rollback();

        }
        return true;
    }
    
    
    public void removeById(final int id) {
        try {
            Agenda agenda = getById(id);
            remover(agenda);
        } catch (Exception ex) {
           Logger.getLogger(AgendaDAO.class.getName()).
                   log(Level.SEVERE, null, ex);
        }
    }
    
     public List<Agenda> lista() {
        List<Agenda> lista = new ArrayList<Agenda>();
        return entityManager.createQuery("FROM " + 
                Agenda.class.getName()).getResultList();
    }

}
