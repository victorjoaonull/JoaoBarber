package com.mycompany.controller;
import com.mycompany.model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.List;

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
    public static Pessoa findUser(String user, String password) {
    EntityManager manager = JPAUtil.getEntityManager();
    Query query = null;
    Pessoa p = null;
    try {
        query = manager.createQuery("SELECT m FROM pessoa m where m.email =:email AND m.senha =:password");
        query.setParameter("email", user);
        query.setParameter("password", password);
        p = (Pessoa) query.getSingleResult();
        System.out.println(p.getSenha());
        JPAUtil.closeEtityManager();
        return p;
    } catch (IllegalStateException e) {
        e.printStackTrace();
    } catch (NoResultException noResultException) {
    }
        return null;
    
}
}
