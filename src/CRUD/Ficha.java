package CRUD;

import java.util.*;

public class Ficha {
	private final List<ItemFicha> fichaCompras = new ArrayList<>();

	public List<ItemFicha> getFichaCompras() {
		return fichaCompras;
	}

	public void adicionarCompra(ItemFicha item) {
		if (item != null) {
			fichaCompras.add(item);
		}
	}

	public void exibirDetalhamento() {
		if (fichaCompras.isEmpty()) {
			System.out.println("Ficha vazia.");
			return;
		}

		for (ItemFicha item : fichaCompras) {
			System.out.println(item);
		}
	}

	public void limparFicha() {
		fichaCompras.clear();
	}

	public float calcularTotal() {
		float total = 0;
		for (ItemFicha item : fichaCompras) {
			total += item.calcularSubTotal();
		}
		return total;
	}
}
