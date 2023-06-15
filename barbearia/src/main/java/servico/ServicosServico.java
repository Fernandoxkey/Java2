package servico;

import empresa.Servicos;

import java.util.List;

public class ServicosServico {
    public void inserir(Servicos servicos) {
        try (var em = HibernateUtil.criarEntityManager()){
            em.getTransaction().begin();
            em.persist(servicos);
            em.getTransaction().commit();
        }
    }
    public void alterar(Servicos servicos) {
        try (var em = HibernateUtil.criarEntityManager()){
            em.getTransaction().begin();
            em.merge(servicos);
            em.getTransaction().commit();
        }
    }
    public Servicos encontrarServicos(long id) {
        try (var em = HibernateUtil.criarEntityManager()) {
            return em.find(Servicos.class, id);
        }
    }

    public void excluir(long id){
        try (var em = HibernateUtil.criarEntityManager()){
            em.getTransaction().begin();
            var servicos = em.find(Servicos.class, id);
            if (servicos != null) {
                em.remove(servicos);
            }
            em.getTransaction().commit();
        }
    }


    public List<Servicos> listarTodos() {
        var em = HibernateUtil.criarEntityManager();

        return em.createQuery("from Servicos e", Servicos.class)
                .getResultList();
    }
}
