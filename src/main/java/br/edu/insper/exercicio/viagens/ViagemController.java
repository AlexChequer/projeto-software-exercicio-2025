package br.edu.insper.exercicio.viagens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viagens")
public class ViagemController {

    @Autowired
    private ViagemService viagemService;

    // Qualquer usuário autenticado pode listar
    @GetMapping
    public List<Viagem> listar() {
        return viagemService.listar();
    }

    // Qualquer usuário autenticado pode criar
    @PostMapping
    public Viagem criar(@RequestBody Viagem viagem) {
        return viagemService.criar(viagem);
    }

    @GetMapping("/{id}")
    public Viagem obter(@PathVariable Integer id) {
        return viagemService.obter(id);
    }

    // Somente ADMIN (quem tiver a permissão delete:viagens) pode excluir
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('delete:viagens')")
    public void excluir(@PathVariable Integer id) {
        viagemService.excluir(id);
    }
}
