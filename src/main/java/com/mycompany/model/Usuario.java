package com.mycompany.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name="usuario")
public class Usuario {
    @Id
    @Column(name="ID_USUARIO")
    private int id;
    @Column(name="PESSOA_USUARIO")
    private int id_pessoa;
    @Column(name="EMAIL_USUARIO")
    private String email;
    @Column(name="SENHA_USUARIO")
    private String senha;
    @Column(name="TIPO_USUARIO")
    private int tipo;
    

    public int getId() {
        return id;
    }

    public int getId_pessoa() {
        return id_pessoa;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_pessoa(int id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    //precisar passar valor númerico pois no banco é registrado com números ao invés de frases e cabo ao programa traduzir
    public void setTipo(String tipo) {
        if(tipo.equals("Cliente n/cadastrado")){
            this.tipo = 1;
        } else if(tipo.equals("Cliente")){
            this.tipo = 2;
        } else if(tipo.equals("Funcionário")){
            this.tipo = 3;
        } else if(tipo.equals("Supervisor")){
            this.tipo = 4;
        }else if(tipo.equals("SuperADMIN")){
            this.tipo = 5;
        }

    }
    
    public void ListInfoUser(){
        System.out.println("Listando informações: ");
        System.out.println("ID Usuário: " + id);
        System.out.println("Usuário. email: " + email);
        System.out.println("Usuário. senha: " + senha);
        System.out.println("Usuário. tipo: " + tipo);
        System.out.println("Usuário. tipo user: " + id_pessoa);
    }
    
    
}
