package com.mycompany.controller;
import com.mycompany.model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.List;

public class PessoaDAO {
    public static void registerPersonDAO(Pessoa registerPerson){
        EntityManager em = JPAUtil.getEntityManager();
        
        //registra no banco
        em.getTransaction().begin();
        
        em.persist(registerPerson);
        
        em.getTransaction().commit();
        JPAUtil.closeEtityManager();
    }
    
    public static Pessoa findPersonByID(int id) {
    EntityManager manager = JPAUtil.getEntityManager();
    Query query = null;
    Pessoa p;
    try {
        query = manager.createQuery("SELECT p FROM pessoa p where p.id =:id");
        query.setParameter("id", id);
        p = (Pessoa) query.getSingleResult();

        
        JPAUtil.closeEtityManager();
        p.ListInfoUser();
        return p;
    } catch (IllegalStateException e) {
        e.printStackTrace();
    } catch (NoResultException noResultException) {
    }
        return null;
    

   
}
    public static List<Pessoa> findPersons() {
    EntityManager manager = JPAUtil.getEntityManager();
    Query query = null;
    List<Pessoa> p;
    try {
        query = manager.createQuery("SELECT p FROM pessoa p");
        p = query.getResultList();

        
        JPAUtil.closeEtityManager();
        return p;
    } catch (IllegalStateException e) {
        e.printStackTrace();
    } catch (NoResultException noResultException) {
    }
        return null;
    
}
    public static Pessoa findPersonsForUser(String nome, String cpf, String celular, String nasc) {
    EntityManager manager = JPAUtil.getEntityManager();
    Query query = null;
    Pessoa p;
    try {
        query = manager.createQuery("SELECT p FROM pessoa p WHERE p.nome =:nome AND p.cpf =:cpf AND p.celular =:celular AND p.nascimento =:nascimento");
        query.setParameter("nome", nome);
        query.setParameter("cpf", cpf);
        query.setParameter("celular", celular);
        query.setParameter("nascimento", nasc);
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
