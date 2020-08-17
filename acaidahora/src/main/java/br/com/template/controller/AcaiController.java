package br.com.template.controller;

import br.com.template.dto.AcaiDto;
import br.com.template.form.AcaiForm;
import br.com.template.models.Acai;
import br.com.template.repository.AcaiRepository;
import br.com.template.repository.PersonalizacaoRepository;
import br.com.template.repository.SaborRepository;
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
@RequestMapping("/pedidos")
public class AcaiController {

    @Autowired
    private AcaiRepository acaiRepository;

    @Autowired
    private SaborRepository saborRepository;

    @Autowired
    private TamanhoRepository tamanhoRepository;

    @Autowired
    private PersonalizacaoRepository personalizacaoRepository;

    @GetMapping
    public Page<AcaiDto> lista(@PageableDefault(sort = "id", direction = Sort.Direction.DESC, page = 0, size = 10) Pageable paginacao) {
        Page<Acai> pedidos = acaiRepository.findAll(paginacao);
        return AcaiDto.converter(pedidos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhar(@PathVariable Integer id) {
        Optional<Acai> op = acaiRepository.findById(id);
        if (op.isPresent()) {
            return ResponseEntity.ok(new AcaiDto(op.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AcaiForm acaiForm, UriComponentsBuilder uriBuilder) {
        Acai acai = acaiForm.converter(saborRepository, tamanhoRepository, personalizacaoRepository);
        if (acai != null) {
            acaiRepository.save(acai);
            URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(acai.getId()).toUri();
            return ResponseEntity.created(uri).body(new AcaiDto(acai));
        }
        return ResponseEntity.badRequest().build();
    }

}
