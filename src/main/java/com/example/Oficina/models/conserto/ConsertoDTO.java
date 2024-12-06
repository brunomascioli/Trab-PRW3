package com.example.Oficina.models.conserto;

import com.example.Oficina.models.mecanico.MecanicoDTO;
import com.example.Oficina.models.veiculo.VeiculoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ConsertoDTO(
        Long id,
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Data não está no formato: dd/mm/yyyy")
        String data_entrada,
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Data não está no formato: dd/mm/yyyy")
        String data_saida,
        @NotNull(message = "Objeto mecânico é obrigatório")
        @Valid
        MecanicoDTO mecanico_responsavel,
        @NotNull(message = "Objeto veículo é obrigatório")
        @Valid
        VeiculoDTO veiculo
) {
        public ConsertoDTO(Conserto conserto) {
                this(
                        conserto.getId(),
                        conserto.getData_entrada(),
                        conserto.getData_saida(),
                        new MecanicoDTO(conserto.getMecanico_responsavel()),
                        new VeiculoDTO(conserto.getVeiculo())
                );
        }
}