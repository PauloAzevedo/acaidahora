package br.com.template.repository;

import br.com.template.models.Sabor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author paulo
 */
public interface SaborRepository extends JpaRepository<Sabor, Integer> {
    
}
