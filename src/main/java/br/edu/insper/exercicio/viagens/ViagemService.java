package br.edu.insper.exercicio.viagens;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ViagemService {

    @Autowired
    private ViagemRepository viagemRepository;

    public List<Viagem> listar() {
        return viagemRepository.findAll();
    }

    public Viagem criar(Viagem v) {
        return viagemRepository.save(v);
    }

    public Viagem obter(Integer id) {
        return viagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Viagem não encontrada"));
    }

    public void excluir(Integer id) {
        if (!viagemRepository.existsById(id)) {
            throw new RuntimeException("Viagem não encontrada");
        }
        viagemRepository.deleteById(id);
    }
}
