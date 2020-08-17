
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

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public Sabor converter(){
        return new Sabor(descricao);
    }
}
