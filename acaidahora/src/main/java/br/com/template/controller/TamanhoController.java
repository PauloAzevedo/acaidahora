package br.com.template.controller;

import br.com.template.dto.SaborDto;
import br.com.template.dto.TamanhoDto;
import br.com.template.form.SaborForm;
import br.com.template.form.TamanhoForm;
import br.com.template.models.Sabor;
import br.com.template.models.Tamanho;
import br.com.template.repository.TamanhoRepository;
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
@RequestMapping("/tamanhos")
public class TamanhoController {

    @Autowired
    private TamanhoRepository tamanhoRepository;

    @GetMapping
    public Page<TamanhoDto> lista(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        Page<Tamanho> tamanhos = tamanhoRepository.findAll(paginacao);
        return TamanhoDto.converter(tamanhos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhar(@PathVariable Integer id) {
        Optional<Tamanho> tamanhoOpt = tamanhoRepository.findById(id);
        if (tamanhoOpt.isPresent()) {
            return ResponseEntity.ok(new TamanhoDto(tamanhoOpt.get()));
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid TamanhoForm saborForm, UriComponentsBuilder uriBuilder) {
        Tamanho tamanho=  saborForm.converter();
        tamanhoRepository.save(tamanho);
        URI uri = uriBuilder.path("/tamanhos/{id}").buildAndExpand(tamanho.getId()).toUri();
        return ResponseEntity.created(uri).body(new TamanhoDto(tamanho));
    }
}
