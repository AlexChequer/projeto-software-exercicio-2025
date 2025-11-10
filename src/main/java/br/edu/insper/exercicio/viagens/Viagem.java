package br.edu.insper.exercicio.viagens;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
public class Viagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String origem;
    private String destino;

    @Column(length = 2000)
    private String descricao;

    @Enumerated(EnumType.STRING)
    private ModoTransporte modoTransporte;

    // Getters/Setters/equals/hashCode
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getOrigem() { return origem; }
    public void setOrigem(String origem) { this.origem = origem; }

    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public ModoTransporte getModoTransporte() { return modoTransporte; }
    public void setModoTransporte(ModoTransporte modoTransporte) { this.modoTransporte = modoTransporte; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Viagem)) return false;
        Viagem viagem = (Viagem) o;
        return Objects.equals(id, viagem.id);
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
