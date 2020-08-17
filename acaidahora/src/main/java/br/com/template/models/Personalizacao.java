package br.com.template.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author paulo
 */
@Entity
public class Personalizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String descricao;
    
    private Double valorAdicional;
    
    private Double tempoPreparoAdicional;

    public Personalizacao() {
    }

    public Personalizacao(String descricao, Double valorAdicional, Double tempoPreparoAdicional) {
        this.descricao = descricao;
        this.valorAdicional = valorAdicional;
        this.tempoPreparoAdicional = tempoPreparoAdicional;
    } 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorAdicional() {
        return valorAdicional;
    }

    public void setValorAdicional(Double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public Double getTempoPreparoAdicional() {
        return tempoPreparoAdicional;
    }

    public void setTempoPreparoAdicional(Double tempoPreparoAdicional) {
        this.tempoPreparoAdicional = tempoPreparoAdicional;
    }
    
    
    
}
