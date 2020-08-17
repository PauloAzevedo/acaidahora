
package br.com.template.form;

import br.com.template.models.Sabor;
import javax.validation.constraints.NotNull;

/**
 *
 * @author paulo
 */
public class SaborForm {
    @NotNull
    private String descricao;
    
    private Double tempoAdicional;

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTempoAdicional(Double tempoAdicional) {
        this.tempoAdicional = tempoAdicional;
    }
    
    
    public Sabor converter(){
        return new Sabor(descricao, tempoAdicional);
    }
}
