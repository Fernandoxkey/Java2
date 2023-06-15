package servico;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class HibernateUtil {
    private static final EntityManagerFactory INSTANCIA
            = Persistence
            .createEntityManagerFactory("hibernate-example");

    public static EntityManager criarEntityManager() {
        return INSTANCIA.createEntityManager();
    }

    public static void fecharFectory() {
        INSTANCIA.close();
    }
}
