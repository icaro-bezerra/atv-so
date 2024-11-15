package org.example.exercicioecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class ProdutoCriacaoDto {
    @NotBlank
    @Size(min = 3, max = 100)
    private String nome;
    @NotBlank
    @Size(min = 2, max = 50)
    private String fabricante;
    @NotBlank
    @Size(min = 2, max = 50)
    private String categoria;
    @NotNull
    @PositiveOrZero
    private Integer qtdEstoque;
    @NotNull
    @PositiveOrZero
    private Double precoVenda;
    @NotNull
    @PositiveOrZero
    private Double precoCompra;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Integer getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(Integer qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public Double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(Double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Double getPrecoCompra() {
        return precoCompra;
    }

    public void setPrecoCompra(Double precoCompra) {
        this.precoCompra = precoCompra;
    }
}
