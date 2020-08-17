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
public class Sabor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String descricao;
    
    private Double tempoOriginal;

    public Sabor() {
    }

    public Sabor( String descricao, Double tempoOriginal) {
        this.descricao = descricao;
        this.tempoOriginal = tempoOriginal;
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

    public Double getTempoOriginal() {
        return tempoOriginal;
    }

    public void setTempoOriginal(Double tempoOriginal) {
        this.tempoOriginal = tempoOriginal;
    }
    
    
}
