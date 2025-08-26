package CRUD;

import java.util.*;

public class Loja {
	private final CadastroProdutos cadastroProdutos;
	private final CadastroClientes cadastroClientes;
	private final RegistroVendas registroVendas;
	private final Scanner scanner;

	public Loja() {
		cadastroProdutos = new CadastroProdutos();
		cadastroClientes = new CadastroClientes();
		registroVendas = new RegistroVendas();
		scanner = new Scanner(System.in);
	}

	public void iniciar() {
		int opcao;
		do {
			menuPrincipal();
			opcao = scanner.nextInt();
			scanner.nextLine();

			switch (opcao) {
			case 1 -> cadastrarProduto();
			case 2 -> listarProdutos();
			case 3 -> cadastrarCliente();
			case 4 -> listarClientes();
			case 5 -> realizarVenda();
			case 6 -> verFichaCliente();
			case 0 -> System.out.println("Encerrando...");
			default -> System.out.println("Opção inválida.");
			}
		} while (opcao != 0);
	}

	private void menuPrincipal() {
		System.out.println("\n----- MENU PRINCIPAL -----\n");
		System.out.println("1. Cadastrar produto. ");
		System.out.println("2. Listar produtos. ");
		System.out.println("3. Cadastrar cliente. ");
		System.out.println("4. Listar clientes. ");
		System.out.println("5. Realizar venda. ");
		System.out.println("6. Ver ficha de cliente.");
		System.out.print("\nEscolha: ");
	}

	private void cadastrarProduto() {
		System.out.print("\nID: ");
		int id = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Nome do produto: ");
		String nome = scanner.nextLine();

		System.out.print("Preço: R$ ");
		float preco = scanner.nextFloat();
		scanner.nextLine();

		System.out.print("Quantidade: ");
		int quantidade = scanner.nextInt();
		scanner.nextLine();

		Produto produto = new Produto(id, nome, preco, quantidade);
		cadastroProdutos.cadastrarProduto(produto);
	}

	private void listarProdutos() {
		cadastroProdutos.listarProdutos();
	}

	private void cadastrarCliente() {
		System.out.print("Nome do cliente: ");
		String nome = scanner.nextLine();

		System.out.print("Telefone: ");
		String telefone = scanner.nextLine();

		System.out.print("CPF: ");
		String cpf = scanner.nextLine();

		Cliente cliente = new Cliente(nome, telefone, cpf);
		cadastroClientes.cadastrarCliente(cliente);
		System.out.println("Cliente cadastrado!");
	}

	private void listarClientes() {
		cadastroClientes.listarClientes();
	}

	private void realizarVenda() {
		System.out.println("Selecione a forma de pagamento:");
		System.out.println("1. DINHEIRO");
		System.out.println("2. PIX");
		System.out.println("3. CARTÃO");
		System.out.println("4. FICHA");
		System.out.print("Escolha: ");
		int opcaoPagamento = scanner.nextInt();
		scanner.nextLine();

		FormaPagamento formaPagamento;
		switch (opcaoPagamento) {
		case 1 -> formaPagamento = FormaPagamento.DINHEIRO;
		case 2 -> formaPagamento = FormaPagamento.PIX;
		case 3 -> formaPagamento = FormaPagamento.CARTAO;
		case 4 -> formaPagamento = FormaPagamento.FICHA;
		default -> {
			System.out.println("Forma de pagamento inválida.");
			return;
		}
		}

		Venda venda = new Venda(cadastroClientes, cadastroProdutos, formaPagamento);

		while (true) {
			System.out.print("ID do produto (ou -1 para finalizar): ");
			int idProduto = scanner.nextInt();
			scanner.nextLine();

			if (idProduto == -1)
				break;

			System.out.print("Quantidade: ");
			int quantidade = scanner.nextInt();
			scanner.nextLine();

			boolean sucesso = venda.realizarVenda(idProduto, quantidade);
			if (!sucesso) {
				System.out.println("Erro ao realizar a venda.");
			}
		}

		System.out.printf("Venda finalizada. Total da venda: R$ %.2f\n", venda.getValorTotal());
	}

	private void verFichaCliente() {
		System.out.print("CPF do cliente: ");
		String cpf = scanner.nextLine();
		cadastroClientes.exibirFichaCliente(cpf);
	}
}
