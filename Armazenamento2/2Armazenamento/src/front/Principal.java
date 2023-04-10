package front;

import entidades.Armazenamento;
import negocio.ArmazenamentoNegocio;
import persistencia.ArmazenamentoPersistencia;

public class Principal {
	public static void main(String[] args) {
		int opcao;
		double valor;
		String unidade;
		Armazenamento objArmazenamento;
		
		do {
			System.out.println("\n\n1 - Criar objeto de armazenamento");
			System.out.println("2 - Gravar dados");
			System.out.println("3 - Apagar dados");
			System.out.println("4 - Verificar espaço disponível");
			System.out.println("5 - Sair");
			opcao = Console.readInt("Informe a opção: ");
			
			switch(opcao){
				case 1: /*CRIAR */
					objArmazenamento  = new Armazenamento();
					objArmazenamento.setDescricao(Console.readString("\n\nInforme o tipo do objeto de armazenamento a ser criado: "));
					if(ArmazenamentoPersistencia.procurar(objArmazenamento) == null) {
						objArmazenamento.setEspaco(Console.readDouble("Informe o espaço de armazenamento em GB: "));
						ArmazenamentoPersistencia.incluir(objArmazenamento);
                        System.out.println("\nDispositivo cadastrado com sucesso!");
					}
					else {
						System.out.println("\n\nObjeto de armazenamento já cadastrado.");
					}
					break;
				case 2: /*GRAVAR DADOS */
					objArmazenamento  = new Armazenamento();
					objArmazenamento.setDescricao(Console.readString("\n\nInforme o tipo do objeto de armazenamento a ser procurado: "));
					objArmazenamento = ArmazenamentoPersistencia.procurar(objArmazenamento);
					if(objArmazenamento != null) {
						valor = Console.readDouble("Informe o valor a ser gravado no objeto de armazenamento: ");
						unidade = Console.readString("Ingforme a unidade de medida a ser utilizada na gravação: ");
						objArmazenamento = ArmazenamentoNegocio.salvarDados(objArmazenamento, unidade, valor);
						if(objArmazenamento != null) {
							ArmazenamentoPersistencia.atualizar(objArmazenamento);
							System.out.println("\n\nGravação realizada com sucesso.");
						}
						else {
							System.out.println("\n\nSem espaço disponível para gravar o arquivo");
						}
					}
					else {
						System.out.println("\n\nObjeto de armazenamento não cadastrado.");
					}
					break;
				case 3: /*APAGAR  */
					objArmazenamento  = new Armazenamento();
					objArmazenamento.setDescricao(Console.readString("\n\nInforme o tipo do objeto de armazenamento a ser procurado: "));
					objArmazenamento = ArmazenamentoPersistencia.procurar(objArmazenamento);
					if(objArmazenamento != null) {
						valor = Console.readDouble("Informe o valor a ser removido do objeto: ");
						unidade = Console.readString("Informe a unidade de medida a ser utilizada na remoção: ");
						objArmazenamento = ArmazenamentoNegocio.removerDados(objArmazenamento, unidade, valor);
						if(objArmazenamento != null) {
							ArmazenamentoPersistencia.atualizar(objArmazenamento);
							System.out.println("\n\nRemoção realizada.");
						}
						else {
							System.out.println("\n\nO valor informado é maior que o espaço disponível.");
						}
					}
					else {
						System.out.println("\n\nObjeto de armazenamento não cadastrado.");
					}
					break;
				case 4: /*VERIFICAR */
					objArmazenamento  = new Armazenamento();
					objArmazenamento.setDescricao(Console.readString("\n\nInforme o tipo do objeto de armazenamento a ser procurado: "));
					objArmazenamento = ArmazenamentoPersistencia.procurar(objArmazenamento);
					if(objArmazenamento != null) {
						System.out.println("Espaço total: " + objArmazenamento.getEspaco());
						System.out.println("Espaço ocupado: " + objArmazenamento.getOcupado());
						System.out.println("Espaço disponível: " + ArmazenamentoNegocio.calcularEspacoDisponivel(objArmazenamento));
					}
					else {
						System.out.println("\n\nObjeto de armazenamento não cadastrado.");
					}
					break;
			}
			
		}while(opcao != 5);
	}
}
