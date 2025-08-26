package CRUD;

public class ItemFicha {
	private String nome;
	private int quantidade;
	private float preco;

	public ItemFicha(String nome, int quantidade, float preco) {
		this.nome = nome;
		this.quantidade = quantidade;
		this.preco = preco;
	}

	public String getNome() {
		return nome;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public float calcularSubTotal() {
		return quantidade * preco;
	}

	@Override
	public String toString() {
		return String.format("%dx %s - R$ %.2f", quantidade, nome, calcularSubTotal());
	}

}
