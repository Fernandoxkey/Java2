package servico;

import empresa.Cliente;

import java.util.List;

public class ClienteServico {
    public void inserir(Cliente cliente) {
        try (var em = HibernateUtil.criarEntityManager()){
            em.getTransaction().begin();
            em.persist(cliente);
            em.getTransaction().commit();
        }
    }
    public void alterar(Cliente cliente) {
        try (var em = HibernateUtil.criarEntityManager()){
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
        }
    }
    public Cliente encontrarCliente(long id) {
        try (var em = HibernateUtil.criarEntityManager()) {
            return em.find(Cliente.class, id);
        }
    }

    public void excluir(long id){
        try (var em = HibernateUtil.criarEntityManager()){
            em.getTransaction().begin();
            var cliente = em.find(Cliente.class, id);
            if (cliente != null) {
                em.remove(cliente);
            }
            em.getTransaction().commit();
        }
    }


    public List<Cliente> listarTodos() {
        var em = HibernateUtil.criarEntityManager();

        return em.createQuery("from Cliente e", Cliente.class)
                .getResultList();
    }
}
