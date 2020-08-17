package br.com.template.dto;

import br.com.template.models.Acai;
import br.com.template.models.Personalizacao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author paulo
 */
public class AcaiDto {
    private Integer id;
    private SaborDto sabor;    
    private TamanhoDto tamanho;  
    private List<PersonalizacaoDto> personalizacoes = new ArrayList();
    private Double tempoDePreparo;    
    private Double valorTotal;

    public AcaiDto(Acai acai) {
        this.id = acai.getId();
        this.sabor = new SaborDto(acai.getSabor());
        this.tamanho = new TamanhoDto(acai.getTamanho());
        this.valorTotal = acai.getValorTotal();
        this.tempoDePreparo = acai.getTempoDePreparo();
        for (Personalizacao personal : acai.getPersonalizacoes()) {
            personalizacoes.add(new PersonalizacaoDto(personal));
        }        
    }
    

    public Integer getId() {
        return id;
    }

    public SaborDto getSabor() {
        return sabor;
    }

    public TamanhoDto getTamanho() {
        return tamanho;
    }

    public List<PersonalizacaoDto> getPersonalizacoes() {
        return personalizacoes;
    }

    public Double getTempoDePreparo() {
        return tempoDePreparo;
    }

    public Double getValorTotal() {
        return valorTotal;
    }
    
    public Page<AcaiDto> converter(Page<Acai> acais) {
        return acais.map(AcaiDto::new);
    }
    
}
