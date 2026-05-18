package configuracion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.text.html.parser.Entity;

public class JPAUtil {
    private static final EntityManagerFactory emf=
            Persistence.createEntityManagerFactory("conexion");
    public static EntityManager getEntityManager(){
        return emf.createEntityManager();
    }
}
