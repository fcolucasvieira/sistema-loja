package CRUD;

public class Produto {
	private int id;
	private int quantidade;
	private float preco;
	private String nome;

	public Produto(int id, String nome, float preco, int quantidade) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}

	// Getters e Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public void adicionarQuantidade(int qtd) {
		this.quantidade += qtd;
	}

	public void removerQuantidade(int qtd) {
		if (qtd <= this.quantidade) {
			this.quantidade -= qtd;
		} else {
			throw new IllegalArgumentException("Quantidade para remover excede o estoque disponível.");
		}
	}

	@Override
	public String toString() {
		return String.format("ID: %d | Nome: %s | Preço: R$ %.2f | Quantidade: %d", id, nome, preco, quantidade);
	}
}
