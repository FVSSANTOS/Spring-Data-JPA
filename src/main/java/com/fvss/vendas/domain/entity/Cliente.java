package com.fvss.vendas.domain.entity;

public class Cliente {
    
    private Integer id;
    private String nome;

    public Cliente(){}

    public Cliente(String nome){
        this.nome = nome;
    }
    
    public Cliente(String nome, Integer id){
        this.nome = nome;
        this.id = id;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + "]";
    }

    
}
