
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
public class Tamanho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String descricao;
    
    private Double valor;
    
    private Double tempoPreparo;

    public Tamanho() {
    }

    public Tamanho(String descricao, Double valor, Double tempoPreparo) {
        this.descricao = descricao;
        this.valor = valor;
        this.tempoPreparo = tempoPreparo;
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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(Double tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }
    
    
}
