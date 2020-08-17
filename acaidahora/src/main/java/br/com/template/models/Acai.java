package br.com.template.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author paulo
 */
@Entity
public class Acai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Sabor sabor;
    @ManyToOne
    private Tamanho tamanho;   
    
    private Double tempoDePreparo;
    
    private Double valorTotal;
    
    @OneToMany
    private List<Personalizacao> personalizacoes;

    public Acai() {
    }

    public Acai(Sabor sabor, Tamanho tamanho, List<Personalizacao> personalizacoes) {
        this.sabor = sabor;
        this.tamanho = tamanho;
        this.personalizacoes = personalizacoes;
    }   
    
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Sabor getSabor() {
        return sabor;
    }

    public void setSabor(Sabor sabor) {
        this.sabor = sabor;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public List<Personalizacao> getPersonalizacoes() {
        return personalizacoes;
    }

    public void setPersonalizacoes(List<Personalizacao> personalizacoes) {
        this.personalizacoes = personalizacoes;
    }

    public Double getTempoDePreparo() {
        return tempoDePreparo;
    }

    public void setTempoDePreparo(Double tempoDePreparo) {
        this.tempoDePreparo = tempoDePreparo;
    }

    

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    
}
