package com.mycompany.controller;

import com.mycompany.model.Pessoa;
import com.mycompany.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.List;

public class UsuarioDAO {
    
    public static List<Usuario> findUsers() {
    EntityManager manager = JPAUtil.getEntityManager();
    Query query = null;
    List<Usuario> u;
    try {
        query = manager.createQuery("SELECT u FROM usuario u");
        u = query.getResultList();

        
        JPAUtil.closeEtityManager();
        return u;
    } catch (IllegalStateException e) {
        e.printStackTrace();
    } catch (NoResultException noResultException) {
    }
        return null;
    
}
    public static Usuario findUserAndPassword(String user, String password) {
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
    public static Usuario findPersonByID(int id) {
    EntityManager manager = JPAUtil.getEntityManager();
    Query query = null;
    Usuario u = null;
    try {
        query = manager.createQuery("SELECT u FROM usuario u where u.id =:id");
        query.setParameter("id", id);
        u = (Usuario) query.getSingleResult();

        
        JPAUtil.closeEtityManager();
        return u;
    } catch (IllegalStateException e) {
        e.printStackTrace();
    } catch (NoResultException noResultException) {
    }
        return null;
    

   
}
    public static void registerUserDAO(Usuario registerPerson){
        EntityManager em = JPAUtil.getEntityManager();
        
        //registra no banco
        em.getTransaction().begin();
        
        em.persist(registerPerson);
        
        em.getTransaction().commit();
        JPAUtil.closeEtityManager();
    }
}
