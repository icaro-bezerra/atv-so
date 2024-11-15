package org.example.exercicioecommerce;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.example.exercicioecommerce.dto.ProdutoListagemDto;
import org.example.exercicioecommerce.controller.ProdutoController;
import org.example.exercicioecommerce.dto.ProdutoMapper;
import org.example.exercicioecommerce.entity.Produto;
import org.example.exercicioecommerce.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;
import java.util.List;

@WebMvcTest(org.example.exercicioecommerce.controller.ProdutoController.class)
public class ExercicioEcommerceApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProdutoRepository repository;

	@MockBean
	private ProdutoMapper produtoMapper;

	@Test
	public void deveRetornarStatus204QuandoNaoExistiremProdutos() throws Exception {
		when(repository.findAll()).thenReturn(Collections.emptyList());
		mockMvc.perform(get("/produtos"))
				.andExpect(status().is(220));
	}
}
