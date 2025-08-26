package CRUD;

import java.util.*;

public class RegistroVendas {
	private final List<VendaFinalizada> vendas = new ArrayList<>();
	
	public void registrarVenda(VendaFinalizada venda) {
		vendas.add(venda);
	}
	
	public void exibirTodasVendas() {
		if(vendas.isEmpty()) {
			System.out.println("Nenhuma venda realizada.");
			return;
		}
		System.out.println("----- RELATÓRIO DE VENDAS -----");
		for(VendaFinalizada venda : vendas) {
			System.out.println(venda);
			System.out.println("------------------------------");
		}
	}
	
	public void exibirVendasPorCpf(String cpf) {
		boolean sucesso = false;
		for(VendaFinalizada venda : vendas) {
			if(cpf.equals(venda.getCpfCliente())) {
				System.out.println(venda);
				System.out.println("------------------------------");
				sucesso = true;
			}
		}
		if(!sucesso)	System.out.println("Nenhuma venda encontrada no CPF informado");
	}
	
	
}
