package br.com.template.form;

import br.com.template.models.Acai;
import br.com.template.models.Personalizacao;
import br.com.template.models.Sabor;
import br.com.template.models.Tamanho;
import br.com.template.repository.PersonalizacaoRepository;
import br.com.template.repository.SaborRepository;
import br.com.template.repository.TamanhoRepository;
import java.util.ArrayList;
import java.util.Optional;
import javax.validation.constraints.NotNull;

/**
 *
 * @author paulo
 */
public class AcaiForm {

    @NotNull
    private Integer sabor;
    @NotNull
    private Integer tamanho;
    
    private Integer[] personalizacoes;

    public Acai converter(
            SaborRepository saborRepository,
            TamanhoRepository tamanhoRepository,
            PersonalizacaoRepository personalizacaoRepository
    ) {
        Optional<Sabor> saborOpt = saborRepository.findById(sabor);
        Optional<Tamanho> tamanhoOpt = tamanhoRepository.findById(tamanho);
        if (saborOpt.isPresent() && tamanhoOpt.isPresent()) {
            Double valorTotalCalculado = 0.0;
            Double tempoTotalCalculado = 0.0;
            Acai acai = new Acai();
            acai.setSabor(saborOpt.get());
            tempoTotalCalculado += saborOpt.get().getTempoOriginal();
            acai.setTamanho(tamanhoOpt.get());
            valorTotalCalculado += tamanhoOpt.get().getValor();
            tempoTotalCalculado += tamanhoOpt.get().getTempoPreparo();
            ArrayList<Personalizacao> personalizacoesObj = new ArrayList();
            if (personalizacoes != null) {
                for (int i = 0; i < personalizacoes.length; i++) {
                    Optional<Personalizacao> personal = personalizacaoRepository.findById(personalizacoes[i]);
                    if (personal.isPresent()) {
                        personalizacoesObj.add(personal.get());
                        valorTotalCalculado += personal.get().getValorAdicional();
                        tempoTotalCalculado += personal.get().getTempoPreparoAdicional();
                    }
                }
            }
            if (personalizacoesObj != null) {
                acai.setPersonalizacoes(personalizacoesObj);
            }
            acai.setValorTotal(valorTotalCalculado);
            acai.setTempoDePreparo(tempoTotalCalculado);
            return acai;
        }

        return null;
    }

    

    public void setSabor(Integer sabor) {
        this.sabor = sabor;
    }

    public void setTamanho(Integer tamanho) {
        this.tamanho = tamanho;
    }

    public void setPersonalizacoes(Integer[] personalizacoes) {
        this.personalizacoes = personalizacoes;
    }

}
