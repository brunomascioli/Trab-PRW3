package com.example.Oficina.models.conserto;

import com.example.Oficina.models.mecanico.MecanicoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record AtualizacaoConserto(
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Data não está no formato: dd/mm/yyyy")
        String dataSaida,
        @NotNull(message = "Objeto mecânico é obrigatório")
        @Valid
        MecanicoDTO mecanico,
        Long id
) {
    public AtualizacaoConserto(Conserto conserto){
        this (
                conserto.getData_saida(),
                new MecanicoDTO(conserto.getMecanico_responsavel()),
                conserto.getId()
        );
    }
}

