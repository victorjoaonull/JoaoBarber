package com.mycompany.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity(name="pessoa")
public class Pessoa {
    @Id
    @Column(name="ID_PESSOA")
    private int id;
    @Column(name="NOME")
    private String nome;
    @Column(name="SOBRENOME")
    private String sobrenome;
    @Column(name="CPF")
    private long cpf;
    @Column(name="NASCIMENTO")
    private String nascimento;
    @Column(name="SENHA")
    private String senha;
    @Column(name="SEXO")
    private String sexo;
    @Column(name="CELULAR")
    private long celular;
    @Column(name="EMAIL")
    private String email;

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public long getCpf() {
        return cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public String getSenha() {
        return senha;
    }

    public String getSexo() {
        return sexo;
    }

    public long getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String formataCPF(String cpf){
        String cpfFormatado = null;
        Pattern pattern = Pattern.compile("(\\d{3})(\\d{3})(\\d{3})(\\d{2})");
        Matcher matcher = pattern.matcher(cpf);
        if (matcher.matches()) {
            cpfFormatado = matcher.group(1) + "." + matcher.group(2) + "." + matcher.group(3) + "-" + matcher.group(4);
        return cpfFormatado;
    }
        return cpfFormatado;
} 
}
