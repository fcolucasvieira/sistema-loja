package CRUD;

import java.util.*;

public class Venda {
	private final CadastroClientes cadastroClientes;
	private final CadastroProdutos cadastroProdutos;
	private final List<ItemFicha> itensVendidos = new ArrayList<>();
	private float valorTotal;
	private final FormaPagamento formaPagamento;
	private final Scanner scanner;

	public Venda(CadastroClientes cadastroClientes, CadastroProdutos cadastroProdutos, FormaPagamento formaPagamento) {
		this.cadastroClientes = cadastroClientes;
		this.cadastroProdutos = cadastroProdutos;
		this.formaPagamento = formaPagamento;
		this.scanner = new Scanner(System.in);
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public CadastroClientes getCadastroClientes() {
		return cadastroClientes;
	}

	public CadastroProdutos getCadastroProdutos() {
		return cadastroProdutos;
	}

	public List<ItemFicha> getItensVendidos() {
		return itensVendidos;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public boolean realizarVenda(int id, int quantidade) {
		Produto produto = cadastroProdutos.buscarPorId(id);

		if (produto == null) {
			System.out.println("Produto não encontrado.");
			return false;
		}

		if (produto.getQuantidade() < quantidade) {
			System.out.println("Quantidade inválida.");
			return false;
		}

		produto.removerQuantidade(quantidade);

		ItemFicha item = new ItemFicha(produto.getNome(), quantidade, produto.getPreco());
		itensVendidos.add(item);
		valorTotal += item.calcularSubTotal();

		if (formaPagamento == FormaPagamento.FICHA) {
			System.out.println("Digite o CPF do cliente: ");
			String cpf = scanner.nextLine();

			Cliente cliente = cadastroClientes.buscarPorCpf(cpf);

			if (cliente == null) {
				System.out.println("Forma de pagamento FICHA requer cliente.");
				return false;
			}

			cliente.adicionarItemFicha(item);
			System.out.println("Venda registrada na ficha do cliente: " + cliente.getNome());
		}

		System.out.println("Venda realizada: " + quantidade + "x " + produto.getNome() + " via " + formaPagamento);
		return true;
	}
}
