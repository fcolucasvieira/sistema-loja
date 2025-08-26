package CRUD;

import java.util.*;
import java.time.*;

public class VendaFinalizada {
	private final LocalDateTime dataHora;
	private final List<ItemFicha> itens;
	private final float total;
	private final FormaPagamento formaPagamento;
	private final String cpfCliente;

	public VendaFinalizada(List<ItemFicha> itens, float total, FormaPagamento formaPagamento,
			String cpfCliente) {
		this.dataHora = LocalDateTime.now();
		this.itens = itens;
		this.total = total;
		this.formaPagamento = formaPagamento;
		this.cpfCliente = cpfCliente;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public List<ItemFicha> getItens() {
		return itens;
	}

	public float getTotal() {
		return total;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		
		result.append("Data: ").append(dataHora).append("\nCPF: ").append(cpfCliente == null ? "N/A" : cpfCliente)
				.append("\nForma de Pagamento: ").append(formaPagamento).append("\nItens:\n");
		
		for (ItemFicha item : itens) {
			result.append(" - ").append(item).append("\n");
		}
		result.append(String.format("Total: R$ .2f\n", total));
		return result.toString();
	}

}
