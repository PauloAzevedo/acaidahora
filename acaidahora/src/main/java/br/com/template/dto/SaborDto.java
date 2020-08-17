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

    public SaborDto(Sabor sabor) {
        this.id = sabor.getId();
        this.descricao = sabor.getDescricao();        
    }
      

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static Page<SaborDto> converter(Page<Sabor> sabores) {
        return sabores.map(SaborDto::new);
    }
    
}
