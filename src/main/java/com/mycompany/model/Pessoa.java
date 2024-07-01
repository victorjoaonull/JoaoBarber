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
    @Column(name="NOME_PESSOA")
    private String nome;
    @Column(name="CPF_PESSOA")
    private long cpf;
    @Column(name="CEL_PESSOA")
    private long celular;
    @Column(name="NASCIMENTO_PESSOA")
    private String nascimento;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }

    public long getCelular() {
        return celular;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    

    public void setCelular(long celular) {
        this.celular = celular;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
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
    public void ListInfoUser(){
        System.out.println("Listando informações: ");
        System.out.println("ID Pessoa: " + id);
        System.out.println("Pessoa. nome: " + nome);
        System.out.println("Pessoa. cpf: " + cpf);
        System.out.println("Pessoa. celular: " + celular);
        System.out.println("Pessoa. nascimento: " + nascimento);
    }
}
