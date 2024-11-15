package org.example.exercicioecommerce.dto;

import org.example.exercicioecommerce.entity.Produto;

import java.util.List;
import java.util.Objects;

public class ProdutoMapper {
    public static ProdutoListagemDto toDto(Produto produto) {
        if(Objects.isNull(produto)) {
            return null;
        }

        ProdutoListagemDto dto = new ProdutoListagemDto();
        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setFabricante(produto.getFabricante());
        dto.setCategoria(produto.getCategoria());
        dto.setQtdEstoque(produto.getQtdEstoque());
        dto.setQtdVendidos(produto.getQtdVendidos());
        dto.setPrecoVenda(produto.getPrecoVenda());
        dto.setPrecoCompra(produto.getPrecoCompra());

        return dto;
    }

    public static List<ProdutoListagemDto> toDto(List<Produto> produtos) {
        return produtos.stream().map(ProdutoMapper::toDto).toList();
    }

    public static Produto toEntity(ProdutoCriacaoDto dto) {
        Produto produto = new Produto();

        produto.setNome(dto.getNome());
        produto.setFabricante(dto.getFabricante());
        produto.setCategoria(dto.getCategoria());
        produto.setQtdEstoque(dto.getQtdEstoque());
        produto.setPrecoVenda(dto.getPrecoVenda());
        produto.setPrecoCompra(dto.getPrecoCompra());

        return produto;
    }

    public static ProdutoClienteListagemDto toClienteDto(Produto produto) {
        ProdutoClienteListagemDto dto = new ProdutoClienteListagemDto();

        dto.setId(produto.getId());
        dto.setNome(produto.getNome());
        dto.setFabricante(produto.getFabricante());
        dto.setCategoria(produto.getCategoria());
        dto.setPreco(produto.getPrecoVenda());

        return dto;
    }

    public static List<ProdutoClienteListagemDto> toClienteDto(List<Produto> produtos) {
        return produtos.stream().map(ProdutoMapper::toClienteDto).toList();
    }

    public static Produto atualizarEstoque(Produto produto, ProdutoEstoqueAtualizacaoDto atualizacao) {
        Integer novaQuantidade = atualizacao.getNovaQuantidade();
        produto.setQtdEstoque(novaQuantidade == null ? produto.getQtdEstoque() : novaQuantidade);

        return produto;
    }

    public static Produto comprar(Produto produto) {
        produto.setQtdEstoque(produto.getQtdEstoque() - 1);
        produto.setQtdVendidos(produto.getQtdVendidos() + 1);

        return produto;
    }
}
