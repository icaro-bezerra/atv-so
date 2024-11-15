package org.example.exercicioecommerce.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProdutoEstoqueAtualizacaoDto {
    @NotNull
    @Positive
    private Integer novaQuantidade;

    public Integer getNovaQuantidade() {
        return novaQuantidade;
    }

    public void setNovaQuantidade(Integer novaQuantidade) {
        this.novaQuantidade = novaQuantidade;
    }
}
