package dao;

import configuracion.JPAUtil;
import jakarta.persistence.EntityManager;
import modelos.Carrera;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarreraDao implements CRUDinterface<Carrera>{


    @Override
    public List<Carrera> listar() {
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();

        try {
            return em.createQuery("SELECT c FROM Carrera c", Carrera.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void guardar(Carrera object) {
        EntityManager em=JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(object);

            em.getTransaction().commit();
        }catch (Exception ex){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }

    }
}
