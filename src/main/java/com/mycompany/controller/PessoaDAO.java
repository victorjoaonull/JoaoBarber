package com.mycompany.controller;
import com.mycompany.model.Pessoa;
import com.mycompany.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;

public class PessoaDAO {
    public static void registerUserDAO(Pessoa registerPerson){
        EntityManager em = JPAUtil.getEntityManager();
        //formata para date sql
        String nasc[] = registerPerson.getNascimento().split("/");
        String nascFormated = nasc[2] + "-" + nasc[1] + "-" + nasc[0];
        registerPerson.setNascimento(nascFormated);
        
        //registra no banco
        em.getTransaction().begin();
        
        em.persist(registerPerson);
        
        em.getTransaction().commit();
        JPAUtil.closeEtityManager();
    }
    
    public static Usuario findUser(String user, String password) {
    EntityManager manager = JPAUtil.getEntityManager();
    Query query;
    Usuario u;
    Pessoa p;
    try {
        query = manager.createQuery("SELECT u FROM usuario u WHERE u.email =:email AND u.senha =:password");
        query.setParameter("email", user);
        query.setParameter("password", password);
        u = (Usuario) query.getSingleResult();
        u.ListInfoUser();

        
        JPAUtil.closeEtityManager();
        return u;
    } catch (IllegalStateException e) {
        e.printStackTrace();
    } catch (NoResultException noResultException) {
    }
        return null;
    
}
    
    public static Pessoa findPersonByID(int id) {
    EntityManager manager = JPAUtil.getEntityManager();
    Query query = null;
    Pessoa p = null;
    try {
        query = manager.createQuery("SELECT p FROM pessoa p where p.id =:id");
        query.setParameter("id", id);
        p = (Pessoa) query.getSingleResult();

        
        JPAUtil.closeEtityManager();
        return p;
    } catch (IllegalStateException e) {
        e.printStackTrace();
    } catch (NoResultException noResultException) {
    }
        return null;
    
}
    
}
