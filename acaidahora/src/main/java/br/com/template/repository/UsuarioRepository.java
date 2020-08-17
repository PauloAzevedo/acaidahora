
package br.com.template.repository;



import br.com.template.models.UsuarioApi;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author paulo
 */
public interface UsuarioRepository extends JpaRepository<UsuarioApi, Long> {
    
    
    Optional<UsuarioApi> findByLogin(String login);
    
    
}
