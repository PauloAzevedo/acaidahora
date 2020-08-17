package br.com.template.repository;

import br.com.template.models.Personalizacao;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author paulo
 */
public interface PersonalizacaoRepository extends JpaRepository<Personalizacao, Integer> {
    
}
