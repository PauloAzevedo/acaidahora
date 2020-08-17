package br.com.template.dto;

import br.com.template.models.Sabor;
import org.springframework.data.domain.Page;

/**
 *
 * @author paulo
 */
public class SaborDto {
    private Integer id;    
    private String descricao;
    private Double tempoOriginal;
    
    public SaborDto(Sabor sabor) {
        this.id = sabor.getId();
        this.descricao = sabor.getDescricao(); 
        this.tempoOriginal = sabor.getTempoOriginal();
    }
      

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getTempoOriginal() {
        return tempoOriginal;
    }

    
    public static Page<SaborDto> converter(Page<Sabor> sabores) {
        return sabores.map(SaborDto::new);
    }
    
}
