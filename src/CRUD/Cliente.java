package CRUD;

import java.util.*;

public class Cliente {
	private final String nome;
	private final String telefone;
	private final String cpf;
	private final Ficha ficha = new Ficha();

	public Cliente(String nome, String telefone, String cpf) {
		if (nome == null || nome.isBlank()) {
			throw new IllegalArgumentException("Nome não pode ser nulo ou vazio");
		}
		if (telefone == null || telefone.isBlank()) {
			throw new IllegalArgumentException("Telefone não pode ser nulo ou vazio");
		}
		if (cpf == null || cpf.isBlank()) {
			throw new IllegalArgumentException("CPF não pode ser nulo ou vazio");
		}
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public Ficha getFicha() {
		return ficha;
	}

	public void adicionarItemFicha(ItemFicha item) {
		ficha.adicionarCompra(item);
	}

	public void exibirFichaDetalhada() {
		System.out.println("Ficha de compras do cliente " + nome + ":");
		ficha.exibirDetalhamento();
	}

	public float calcularTotalFicha() {
		return ficha.calcularTotal();
	}

	@Override
	public String toString() {
		return String.format("Cliente: %s | Telefone: %s | CPF: %s", nome, telefone, cpf);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, nome.toLowerCase(), telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Cliente))
			return false;
		Cliente cliente = (Cliente) obj;
		return cpf.equals(cliente.cpf) && nome.equalsIgnoreCase(cliente.nome) && telefone.equals(cliente.telefone);
	}

}