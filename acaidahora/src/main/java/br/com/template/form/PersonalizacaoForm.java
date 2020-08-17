package br.com.template.form;

import br.com.template.models.Personalizacao;
import javax.validation.constraints.NotNull;

/**
 *
 * @author paulo
 */
public class PersonalizacaoForm {
    @NotNull
    private String descricao;    
    @NotNull
    private Double valorAdicional;    
    @NotNull
    private Double tempoPreparoAdicional;

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValorAdicional(Double valorAdicional) {
        this.valorAdicional = valorAdicional;
    }

    public void setTempoPreparoAdicional(Double tempoPreparoAdicional) {
        this.tempoPreparoAdicional = tempoPreparoAdicional;
    }
    
    public Personalizacao converter(){
        return new Personalizacao(descricao, valorAdicional, tempoPreparoAdicional);
    }
    
}
