package br.com.template.controller;

import br.com.template.dto.SaborDto;
import br.com.template.form.SaborForm;
import br.com.template.models.Sabor;
import br.com.template.repository.SaborRepository;
import java.net.URI;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
@RequestMapping("/sabores")
public class SaborController {

    @Autowired
    private SaborRepository saborRepository;

    @GetMapping
    public Page<SaborDto> lista(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        Page<Sabor> sabores = saborRepository.findAll(paginacao);
        return SaborDto.converter(sabores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhar(@PathVariable Integer id) {
        Optional<Sabor> op = saborRepository.findById(id);
        if (op.isPresent()) {
            return ResponseEntity.ok(new SaborDto(op.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid SaborForm saborForm, UriComponentsBuilder uriBuilder) {
        Sabor sabor = saborForm.converter();
        saborRepository.save(sabor);
        URI uri = uriBuilder.path("/sabores/{id}").buildAndExpand(sabor.getId()).toUri();
        return ResponseEntity.created(uri).body(new SaborDto(sabor));
    }

}
