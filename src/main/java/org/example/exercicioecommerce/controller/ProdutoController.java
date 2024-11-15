package org.example.exercicioecommerce.controller;

import jakarta.validation.Valid;
import org.example.exercicioecommerce.dto.*;
import org.example.exercicioecommerce.entity.Produto;
import org.example.exercicioecommerce.repository.ProdutoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoRepository repository;

    public ProdutoController(ProdutoRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<ProdutoListagemDto> cadastrar(@RequestBody @Validated ProdutoCriacaoDto novoProduto) {
        Produto produtoConvertido = ProdutoMapper.toEntity(novoProduto);
        this.repository.save(produtoConvertido);

        ProdutoListagemDto produtoCadastrado = ProdutoMapper.toDto(produtoConvertido);
        return ResponseEntity.status(201).body(produtoCadastrado);
    }

    @GetMapping
    public ResponseEntity<String> listarTodos() {
        return ResponseEntity.status(220).body("To não");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoListagemDto> buscarPorId(@PathVariable int id) {
        Optional<Produto> produtoBuscado = this.repository.findById(id);

        if(produtoBuscado.isEmpty()) return ResponseEntity.status(404).build();

        ProdutoListagemDto dto = ProdutoMapper.toDto(produtoBuscado.get());
        return ResponseEntity.status(200).body(dto);
    }

    @GetMapping("/{id}/cliente")
    public ResponseEntity<ProdutoClienteListagemDto> buscarPorIdCliente(@PathVariable int id) {
        Optional<Produto> produtoBuscado = this.repository.findById(id);

        if(produtoBuscado.isEmpty()) return ResponseEntity.status(404).build();

        ProdutoClienteListagemDto dto = ProdutoMapper.toClienteDto(produtoBuscado.get());
        return ResponseEntity.status(200).body(dto);
    }

    @PatchMapping("/{id}/estoque")
    public ResponseEntity<ProdutoListagemDto> atualizarEstoque(@PathVariable int id, @RequestBody @Valid ProdutoEstoqueAtualizacaoDto atualizacao) {
        Optional<Produto> produtoBuscado = this.repository.findById(id);

        if(produtoBuscado.isEmpty()) return ResponseEntity.status(404).build();

        Produto produtoAtualizado = ProdutoMapper.atualizarEstoque(produtoBuscado.get(), atualizacao);
        this.repository.save(produtoAtualizado);

        ProdutoListagemDto dto = ProdutoMapper.toDto(produtoAtualizado);
        return ResponseEntity.status(200).body(dto);
    }

    @PostMapping("/{id}/compra")
    public ResponseEntity<ProdutoClienteListagemDto> comprar(@PathVariable int id) {
        Optional<Produto> produtoBuscado = this.repository.findById(id);

        if(produtoBuscado.isEmpty()) return ResponseEntity.status(404).build();

        Produto produtoVendido = ProdutoMapper.comprar(produtoBuscado.get());
        this.repository.save(produtoVendido);

        ProdutoClienteListagemDto dto = ProdutoMapper.toClienteDto(produtoVendido);
        return ResponseEntity.status(200).body(dto);
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<ProdutoClienteListagemDto>> buscarPorCategoriaEPreco(@RequestParam String categoria,
                                                                                    @RequestParam Double valorInicio,
                                                                                    @RequestParam Double valorFinal) {
        List<Produto> listaProdutosBuscados = this.repository.findByCategoriaEqualsIgnoreCaseAndPrecoVendaBetween(
                categoria, valorInicio, valorFinal);

        if(listaProdutosBuscados.isEmpty()) return ResponseEntity.status(204).build();

        List<ProdutoClienteListagemDto> listaDto = ProdutoMapper.toClienteDto(listaProdutosBuscados);
        return ResponseEntity.status(200).body(listaDto);
    }

    @GetMapping("/mais-vendidos")
    public ResponseEntity<List<ProdutoListagemDto>> buscarMaisVendidos(@RequestParam Integer qtd) {
        List<Produto> listaProdutosBuscados = this.repository.findByQtdVendidosGreaterThanEqual(qtd);

        if(listaProdutosBuscados.isEmpty()) return ResponseEntity.status(204).build();

        List<ProdutoListagemDto> listaDto = ProdutoMapper.toDto(listaProdutosBuscados);
        return ResponseEntity.status(200).body(listaDto);
    }
}
