package front;
import entidades.Folha;
import negocio.FolhaNegocio;
import persistencia.FolhaPersistencia;

public class Principal {
    public static void main(String[] args) {
		int opc;
		float bruto, inss, ir, liquido, total;
		Folha folha = null;
		do{
			System.out.println("\n\n1 - Cadastro da folha");
			System.out.println("2 - Consultar folha");
			System.out.println("3 - Listar folha");
			System.out.println("4 - Sair");
			opc = Console.readInt("Informe a opÃ§Ã£o: ");
			switch(opc){
				case 1: /*Cadastro da folha */
					System.out.println("\n\n");
					folha = new Folha();
					folha.setMesPagamento(Console.readInt("\n\nInforme o mÃªs de pagamento: "));
					folha.setAnoPagamento(Console.readInt("Informe o ano de pagamento: "));
					folha.setNomeFuncionario(Console.readString("Informe o nome do funcionÃ¡rio: "));
					if(FolhaPersistencia.consultarFolha(folha) == null) {
						folha.setNumeroHoras(Console.readInt("Horas trabalhadas: "));
						folha.setValorHora(Console.readFloat("Valor da hora: "));
						FolhaPersistencia.incluirFolha(folha);
					}
					else {
						System.out.println("\n\nJÃ¡ existe uma folha de pagamento para o funcionÃ¡rio/mÃªs e ano informados.");
					}
					break;
				case 2: /*Consultar folha */
					folha = new Folha();
					folha.setMesPagamento(Console.readInt("\n\nInforme o mÃªs de pagamento: "));
					folha.setAnoPagamento(Console.readInt("Informe o ano de pagamento: "));
					folha.setNomeFuncionario(Console.readString("Informe o nome do funcionÃ¡rio: "));
					folha = FolhaPersistencia.consultarFolha(folha);
					if(folha != null) {
						System.out.println("\n\nNome do funcionÃ¡rio: " + folha.getNomeFuncionario());
						System.out.println("MÃªs de pagamento: " + folha.getMesPagamento());
						System.out.println("Ano de pagamento: " + folha.getAnoPagamento());
						System.out.println("Horas trabalhadas: " + folha.getNumeroHoras());
						System.out.println("Valor da hora: " + folha.getValorHora());
						System.out.println("*** ----------------------------- ***");
						System.out.println("Calculo do salario");
						System.out.println("*** ----------------------------- ***");
						bruto = FolhaNegocio.calcularSalarioBruto(folha);
						ir = FolhaNegocio.calcularIR(bruto);
						inss = FolhaNegocio.calcularINSS(bruto);
						System.out.println("SalÃ¡rio bruto: " + bruto);
						System.out.println("IR: " + ir);
						System.out.println("INSS: " + inss);
						System.out.println("FGTS: " + FolhaNegocio.calcularFGTS(bruto));
						System.out.println("SalÃ¡rio lÃ­quido: " + FolhaNegocio.calcularSalarioLiquido(bruto, inss, ir));
					}
					else {
						System.out.println("\n\nNÃ£o existe uma folha de pagamento para o funcionÃ¡rio/mÃªs/ano infornados.");
					}
					break;
				case 3: /*Listar folha */
					folha = new Folha();
					folha.setMesPagamento(Console.readInt("\n\nInforme o mÃªs de pagamento: "));
					folha.setAnoPagamento(Console.readInt("Informe o ano de pagamento: "));
					total = 0;
					for(Folha itemFolha2: FolhaPersistencia.listarFolhasMesAno(folha)) {
						System.out.println("Nome do funcionÃ¡rio: " + itemFolha2.getNomeFuncionario());
						bruto = FolhaNegocio.calcularSalarioBruto(itemFolha2);
						ir = FolhaNegocio.calcularIR(bruto);
						inss = FolhaNegocio.calcularINSS(bruto);
						liquido = FolhaNegocio.calcularSalarioLiquido(bruto, inss, ir);
						System.out.println("SalÃ¡rio lÃ­quido: " + liquido);
						System.out.println("---------------------------------------------");
						total += liquido;
					}
					System.out.println("Total: " + total);
					System.out.println("---------------------------------------------");
			}
		}while(opc != 4);
	}   
}
