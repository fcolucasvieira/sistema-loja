package CRUD;

import java.util.*;

public class CadastroProdutos {
	private final Map<Integer, Produto> produtosPorId = new HashMap<>();

	public void cadastrarProduto(Produto produto) {
		if (produto == null) {
			throw new IllegalArgumentException("Produto não pode ser nulo.");
		}
		if (produtosPorId.containsKey(produto.getId())) {
			throw new IllegalArgumentException("Já existe um produto com este ID.");
		}
		produtosPorId.put(produto.getId(), produto);
		System.out.println("Produto adicionado com sucesso!");
	}

	public Produto buscarPorId(int id) {
		return produtosPorId.get(id);
	}

	public void removerProduto(int id) {
		Produto removido = produtosPorId.remove(id);
		if (removido != null) {
			System.out.println("Produto removido com sucesso!");
		} else {
			System.out.println("Produto não encontrado.");
		}
	}

	public void listarProdutos() {
		if (produtosPorId.isEmpty()) {
			System.out.println("Nenhum produto cadastrado.");
			return;
		}
		System.out.println("Produtos cadastrados: ");
		for (Produto produto : produtosPorId.values()) {
			System.out.println(produto);
		}
	}

	public boolean existeProduto(int id) {
		return produtosPorId.containsKey(id);
	}

	public void atualizarPreco(int id, float novoPreco) {
		Produto produto = produtosPorId.get(id);
		if (produto == null) {
			System.out.println("Produto não encontrado.");
			return;
		}
		if (novoPreco < 0) {
			System.out.println("Preço inválido.");
			return;
		}
		produto.setPreco(novoPreco);
		System.out.println("Produto atualizado com sucesso!");
	}
}
