package br.com.template.dto;

import br.com.template.models.Personalizacao;
import org.springframework.data.domain.Page;

/**
 *
 * @author paulo
 */
public class PersonalizacaoDto {
    private Integer id;    
    private String descricao;    
    private Double valorAdicional;    
    private Double tempoPreparoAdicional;

    public PersonalizacaoDto(Personalizacao personal) {
        this.id = personal.getId();
        this.descricao = personal.getDescricao();
        this.valorAdicional = personal.getValorAdicional();
        this.tempoPreparoAdicional = personal.getTempoPreparoAdicional();
    }    
    

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getValorAdicional() {
        return valorAdicional;
    }

    public Double getTempoPreparoAdicional() {
        return tempoPreparoAdicional;
    }
    
    public static Page<PersonalizacaoDto> converter(Page<Personalizacao> personalizacoes ){
        return personalizacoes.map(PersonalizacaoDto::new);
    }
    
}
