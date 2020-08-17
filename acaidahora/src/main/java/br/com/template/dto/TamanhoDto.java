
package br.com.template.dto;

import br.com.template.models.Tamanho;
import org.springframework.data.domain.Page;

/**
 *
 * @author paulo
 */
public class TamanhoDto {
    private Integer id;    
    private String descricao;    
    private Double valor;    
    private Double tempoPreparo;
    
    public TamanhoDto(Tamanho tamanho){
        this.id = tamanho.getId();
        this.descricao = tamanho.getDescricao();
        this.valor = tamanho.getValor();
        this.tempoPreparo = tamanho.getTempoPreparo();
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValor() {
        return valor;
    }

    public Double getTempoPreparo() {
        return tempoPreparo;
    }
    
    public static Page<TamanhoDto> converter(Page<Tamanho> tamanhos) {
        return tamanhos.map(TamanhoDto::new);
    }
    
}
