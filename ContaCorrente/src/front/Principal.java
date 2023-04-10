package front;

import entidades.Conta;
import negocio.ContaNegocio;
import persistencia.ContaPersistencia;
public class Principal {
	public static void main(String[] args) {
		int opcao;
		Conta conta;
		float valor;
		do {
			System.out.println("\n\n1 - Criar conta corrente");
			System.out.println("2 - Depositar");
			System.out.println("3 - Sacar");
			System.out.println("4 - Verificar saldo");
			System.out.println("5 - TransferÃªncia: ");
			System.out.println("6 - Sair");
			opcao = Console.readInt("Informe a OpÃ§Ã£o: ");
			switch (opcao) {
			case 1:
				conta = new Conta();
				conta.setNumeroAgencia(Console.readInt("\n\nInforme o nÃºmero da agÃªncia: "));
				conta.setNumeroConta(Console.readInt("Informe o nÃºmero da conta: "));
				if(ContaPersistencia.buscarConta(conta) == null) {
					conta.setNomeCliente(Console.readString("Informe o nome do cliente: "));				
					conta.setLimite(Console.readFloat("Informe o valor do limite: "));
					conta.setSaldo(0);
					ContaPersistencia.incluirConta(conta);
				}
				else {
					System.out.println("\n\nA conta informada jÃ¡ foi cadastrada.");
				}
				break;
			case 2:
				conta = new Conta();
				conta.setNumeroAgencia(Console.readInt("\n\nInforme o nÃºmero da agÃªncia: "));
				conta.setNumeroConta(Console.readInt("Informe o nÃºmero da conta: "));
				conta = ContaPersistencia.buscarConta(conta);
				if(conta != null) {
					valor = Console.readFloat("Informe o valor a ser depositado: ");
					ContaNegocio.depositar(conta, valor);
					ContaPersistencia.atualizarConta(conta);
				}
				else {
					System.out.println("\n\nA conta informada nÃ£o foi cadastrada.");
				}
				break;
			case 3:
				conta = new Conta();
				conta.setNumeroAgencia(Console.readInt("\n\nInforme o nÃºmero da agÃªncia: "));
				conta.setNumeroConta(Console.readInt("Informe o nÃºmero da conta: "));
				conta = ContaPersistencia.buscarConta(conta);
				if(conta != null) {
					valor = Console.readFloat("Informe o valor a ser sacado: ");
					if(ContaNegocio.verificarSaldo(conta, valor) == true) {
						ContaNegocio.sacar(conta, valor);
						ContaPersistencia.atualizarConta(conta);
						System.out.println("O saque foi realizado.");
					}
					else {
						System.out.println("\n\nNÃ£o tem saldo disponÃ­vel. VocÃª pode sacar atÃ©: " + ContaNegocio.calcularSaldoDisponivel(conta));
					}
				}
				else {
					System.out.println("\n\nConta nÃ£o cadastrada.");
				}
				break;
			case 4:
				
				conta = new Conta();
				conta.setNumeroAgencia(Console.readInt("\n\nInforme o nÃºmero da agÃªncia: "));
				conta.setNumeroConta(Console.readInt("Informe o nÃºmero da conta: "));
				conta = ContaPersistencia.buscarConta(conta);
				if(conta != null) {
					System.out.println("Nome do cliente: " + conta.getNomeCliente());
					System.out.println("Saldo: " + conta.getSaldo());
					System.out.println("Limite: " + conta.getLimite());
					System.out.println("Saldo disponÃ­vel: " + ContaNegocio.calcularSaldoDisponivel(conta));
				}
				else {
					System.out.println("\n\nConta corrente nÃ£o cadastrada.");
				}
				break;
			case 5:
				break;
			}
		} while (opcao != 6);
	}
}