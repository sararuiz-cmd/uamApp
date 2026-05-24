package dao;

import configuracion.JPAUtil;
import jakarta.persistence.EntityManager;
import modelos.Carrera;

import java.util.List;

public class CarreraDao implements CRUDinterface<Carrera> {

    @Override
    public List<Carrera> listar() {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.createQuery("SELECT c FROM Carrera c", Carrera.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Carrera buscarPorId(Long id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            return em.find(Carrera.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public void guardar(Carrera object) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            em.persist(object);

            em.getTransaction().commit();
            System.out.println("Carrera guardada correctamente.");

        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            System.out.println("Error al guardar la carrera:");
            ex.printStackTrace();

        } finally {
            em.close();
        }
    }

    @Override
    public void actualizar(Carrera object) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            em.merge(object);

            em.getTransaction().commit();
            System.out.println("Carrera actualizada correctamente.");

        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            System.out.println("Error al actualizar la carrera:");
            ex.printStackTrace();

        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long id) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            em.getTransaction().begin();

            Carrera carrera = em.find(Carrera.class, id);

            if (carrera != null) {
                em.remove(carrera);
                System.out.println("Carrera eliminada correctamente.");
            } else {
                System.out.println("No existe una carrera con ese ID.");
            }

            em.getTransaction().commit();

        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }

            System.out.println("Error al eliminar la carrera:");
            ex.printStackTrace();

        } finally {
            em.close();
        }
    }
}