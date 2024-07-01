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
    private String tipo;
    

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

    public String getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId_pessoa(Pessoa pessoa) {
        this.id_pessoa = pessoa.getId();
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    //precisar passar valor númerico pois no banco é registrado com números ao invés de frases e cabo ao programa traduzir
    public void setTipo(int tipo) {
        if(tipo == 1){
            this.tipo = "Cliente n/cadastrado";
        } else if(tipo == 2){
            this.tipo = "Cliente cadastrado";
        } else if(tipo == 3){
            this.tipo = "Funcionário";
        } else if(tipo == 4){
            this.tipo = "Supervisor";
        }  else if(tipo == 5){
            this.tipo = "Admin";
        }
        
    }
    
    public void ListInfoUser(){
        System.out.println("Listando informações: ");
        System.out.println("ID Usuário: " + id);
        System.out.println("Usuário. email: " + email);
        System.out.println("Usuário. senha: " + senha);
        System.out.println("Usuário. tipo: " + tipo);
    }
    
    
}
