package br.com.template.repository;

import br.com.template.models.Tamanho;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author paulo
 */
public interface TamanhoRepository extends JpaRepository<Tamanho, Integer> {
    
}
