package com.example.Oficina.models.conserto;

import com.example.Oficina.models.mecanico.Mecanico;
import com.example.Oficina.models.veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "conserto")
@Entity(name = "Conserto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Conserto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String data_entrada;
    private String data_saida;

    @Embedded
    private Mecanico mecanico_responsavel;

    @Embedded
    private Veiculo veiculo;

    private boolean ativo;

    public Conserto(ConsertoDTO consertoDTO) {
        this.ativo = true;
        this.data_entrada = consertoDTO.data_entrada();
        this.data_saida = consertoDTO.data_saida();
        this.mecanico_responsavel = new Mecanico(consertoDTO.mecanico_responsavel());
        this.veiculo = new Veiculo(consertoDTO.veiculo());
    }

    public void apagar(){
        this.ativo = false;
    }

    public void atualizarInformacoes(AtualizacaoConserto dados) {
        if (dados.dataSaida() != null) {
            this.data_saida = dados.dataSaida();
        }
        if (dados.mecanico() != null) {
            this.mecanico_responsavel.atualizarInformacoes(dados.mecanico());
        }
    }
}
