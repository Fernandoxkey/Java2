package servico;

import empresa.Profissional;

import java.util.List;

public class ProfissionalServico {
    public void inserir(Profissional profissional) {
        try ( var em = HibernateUtil.criarEntityManager()){
            em.getTransaction().begin();
            em.persist(profissional);
            em.getTransaction().commit();
        }
    }
    public void alterar(Profissional profissional) {
        try (var em = HibernateUtil.criarEntityManager()){
            em.getTransaction().begin();
            em.merge(profissional);
            em.getTransaction().commit();
        }
    }
    public Profissional encontrarProfissional(long id) {
        try (var em = HibernateUtil.criarEntityManager()) {
            return em.find(Profissional.class, id);
        }
    }

    public void excluir(long id){
        try (var em = HibernateUtil.criarEntityManager()){
            em.getTransaction().begin();
            var profissional = em.find(Profissional.class, id);
            if (profissional != null) {
                em.remove(profissional);
            }
            em.getTransaction().commit();
        }
    }

    public List<Profissional> listarTodos() {
        var em = HibernateUtil.criarEntityManager();

        return em.createQuery("from Profissional e", Profissional.class)
                .getResultList();
    }
}
