package com.mycompany.controller;
import com.mycompany.model.Pessoa;
import jakarta.persistence.EntityManager;

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
}
