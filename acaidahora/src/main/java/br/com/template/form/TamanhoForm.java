
package br.com.template.form;

import br.com.template.models.Tamanho;
import javax.validation.constraints.NotNull;

/**
 *
 * @author paulo
 */
public class TamanhoForm {
    @NotNull
    private String descricao;
    @NotNull
    private Double valor;
    @NotNull
    private Double tempoPreparo;

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setTempoPreparo(Double tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }
    
    public Tamanho converter(){
        return new Tamanho(descricao, valor, tempoPreparo);
    }
}
