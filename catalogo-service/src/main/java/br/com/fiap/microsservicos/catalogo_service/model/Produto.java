package br.com.fiap.microsservicos.catalogo_service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private double preco;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id(id);
    }


}


