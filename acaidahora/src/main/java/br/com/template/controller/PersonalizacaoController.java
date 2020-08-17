
package br.com.template.controller;

import br.com.template.dto.PersonalizacaoDto;
import br.com.template.dto.SaborDto;
import br.com.template.form.PersonalizacaoForm;
import br.com.template.form.SaborForm;
import br.com.template.models.Personalizacao;
import br.com.template.models.Sabor;
import br.com.template.repository.PersonalizacaoRepository;
import java.net.URI;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author paulo
 */
@RestController
@RequestMapping("/personalizacoes")
public class PersonalizacaoController {
    @Autowired
    private PersonalizacaoRepository personalizacaoRepository;

    @GetMapping
    public Page<PersonalizacaoDto> lista(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        Page<Personalizacao> personalizacoes = personalizacaoRepository.findAll(paginacao);
        return PersonalizacaoDto.converter(personalizacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhar(@PathVariable Integer id) {
        Optional<Personalizacao> personalizacaoOpt = personalizacaoRepository.findById(id);
        if (personalizacaoOpt.isPresent()) {
            return ResponseEntity.ok(new PersonalizacaoDto(personalizacaoOpt.get()));
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PersonalizacaoForm personalizacaoForm, UriComponentsBuilder uriBuilder) {
        Personalizacao personalizacao = personalizacaoForm.converter();
        personalizacaoRepository.save(personalizacao);
        URI uri = uriBuilder.path("/personalizacoes/{id}").buildAndExpand(personalizacao.getId()).toUri();
        return ResponseEntity.created(uri).body(new PersonalizacaoDto(personalizacao));
    }

}
