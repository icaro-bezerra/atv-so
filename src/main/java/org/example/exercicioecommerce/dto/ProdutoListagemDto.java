package org.example.exercicioecommerce.dto;

public class ProdutoListagemDto {
    private Integer id;
    private String nome;
    private String fabricante;
    private String categoria;
    private Integer qtdEstoque;
    private Integer qtdVendidos;
    private Double precoVenda;
    private Double precoCompra;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getQtdVendidos() {
        return qtdVendidos;
    }

    public void setQtdVendidos(Integer qtdVendidos) {
        this.qtdVendidos = qtdVendidos;
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

    public Double getLucro() {
        return (precoVenda - precoCompra) * qtdVendidos;
    }
}