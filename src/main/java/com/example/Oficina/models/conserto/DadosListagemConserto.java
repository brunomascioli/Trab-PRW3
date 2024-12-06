package com.example.Oficina.models.conserto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosListagemConserto(
        Long id,
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Data não está no formato: dd/mm/yyyy")
        String data_entrada,
        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Data não está no formato: dd/mm/yyyy")
        String data_saida,
        @NotBlank(message = "Nome do mecânico é obrigatório")
        String nome_mecanico,
        @NotBlank(message = "Marca do veículo é obrigatório")
        String marca_veiculo,
        @NotBlank(message = "Modelo do veículo é obrigatório")
        String modelo_veiculo
) {
    public DadosListagemConserto(Conserto conserto) {
        this(   conserto.getId(),
                conserto.getData_entrada(),
                conserto.getData_saida(),
                conserto.getMecanico_responsavel().getNome_mecanico(),
                conserto.getVeiculo().getNome_veiculo(),
                conserto.getVeiculo().getModelo_veiculo()
        );
    }
}
