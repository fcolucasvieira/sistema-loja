package CRUD;

import java.util.*;

public class CadastroClientes {
	private final Map<String, Cliente> clientesPorCpf = new HashMap<>();

	public void cadastrarCliente(Cliente cliente) {
		if (clientesPorCpf.containsKey(cliente.getCpf())) {
			throw new IllegalArgumentException("Cliente já existe com este CPF.");
		}
		clientesPorCpf.put(cliente.getCpf(), cliente);
	}

	public Cliente buscarPorCpf(String cpf) {
		return clientesPorCpf.get(cpf);
	}

	public List<Cliente> buscarPorNome(String nome) {
		List<Cliente> encontrados = new ArrayList<>();
		for (Cliente cliente : clientesPorCpf.values()) {
			if (cliente.getNome().toLowerCase().contains(nome.toLowerCase())) {
				encontrados.add(cliente);
			}
		}
		return encontrados;
	}

	public void removerCliente(String cpf) {
		if (clientesPorCpf.remove(cpf) == null) {
			System.out.println("Cliente não encontrado.");
		} else {
			System.out.println("Cliente removido com sucesso.");
		}
	}

	public void listarClientes() {
		if (clientesPorCpf.isEmpty()) {
			System.out.println("Nenhum cliente cadastrado.");
			return;
		}
		for (Cliente cliente : clientesPorCpf.values()) {
			System.out.println(cliente);
		}
	}

	public void exibirFichaCliente(String cpf) {
		Cliente cliente = clientesPorCpf.get(cpf);
		if (cliente == null) {
			System.out.println("Cliente não encontrado.");
			return;
		}
		cliente.exibirFichaDetalhada();
	}
}
