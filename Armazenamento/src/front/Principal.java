package front;
import entidades.Armazenamento;
import persistencia.ArmazenamentoPersistencia;
import negocio.ArmazenamentoNegocio;

public class Principal {
    public static void main(String[] args) {
        int opcao;
        double valor;
        String unidade;
        Armazenamento armazenamento;
        
        do {
            System.out.println("\n\n1 - Criar objeto de armazenamento");
            System.out.println("2 - Gravar dados");
            System.out.println("3 - Apagar dados");
            System.out.println("4 - Verificar espaço disponível");
            System.out.println("5 - Sair");
            opcao = Console.readInt("Informe a opção: ");

            switch (opcao) {
                case 1: /*CRIAR */
                armazenamento = new Armazenamento();
                armazenamento.setTipoDispo(Console.readString("\n\nInforme o tipo do dispositvo de armazenamento: "));
                
                if(ArmazenamentoPersistencia.buscar(armazenamento) == null) {
                    armazenamento.setEspaco(Console.readDouble("Informe o espaço de armazenamento em GB: "));
                    ArmazenamentoPersistencia.incluir(armazenamento);
                    System.out.println("\nDispositivo cadastrado com sucesso!");
                }
                else {
                    System.out.println("\n\nO dispositivo informado já foi cadastrado");
                }
                break;

                case 2: /*GRAVAR DADOS */
                armazenamento = new Armazenamento();
                armazenamento.setTipoDispo(Console.readString("\n\nInforme o tipo do dispositvo de armazenamento a ser procurado: "));
                armazenamento = ArmazenamentoPersistencia.buscar(armazenamento);
                if(armazenamento != null) {
                    valor = Console.readDouble("Informe a quantidade de informação a ser gravada: ");
                    unidade = Console.readString("Informe a unidade de medida a ser gravada: ");
                    armazenamento = ArmazenamentoNegocio.salvarDados(armazenamento, unidade, valor);
                    if(armazenamento != null) {
                        ArmazenamentoPersistencia.atualizar(armazenamento);
                        System.out.println("Gravação realizada com sucesso!");
                    }
                    else {
                        System.out.println("Sem espaço disponível para gravar o arquivo");
                    } 
                } 
                else {
                    System.out.println("O dispositivo informado não foi cadastrado");
                }

                break;

                case 3: /*APAGAR  */
                    armazenamento = new Armazenamento();
                    armazenamento.setTipoDispo(Console.readString("\n\nInforme o tipo do dispositvo de armazenamento a ser procurado: "));
                    armazenamento = ArmazenamentoPersistencia.buscar(armazenamento);

                    if(armazenamento != null) {
                        valor = Console.readDouble("Informe o valor a ser removido do dispositivo: ");
                        unidade = Console.readString("Informe a unidade de medida a ser utilizada na remoção: ");
                        armazenamento = ArmazenamentoNegocio.apagarDados(armazenamento, unidade, valor);

                        if(armazenamento != null) {
                            ArmazenamentoPersistencia.atualizar(armazenamento);
                            System.out.println("\n\nRemoção realizada!");
                        }
                        else {
                            System.out.println("O valor informado é maior que o espaço ocupado");
                        }
                    } 
                    else {
                        System.out.println("O dispositivo informado não foi cadastrado");
                    }
                break;

               case 4: /*VERIFICAR */
               armazenamento = new Armazenamento();
               armazenamento.setTipoDispo(Console.readString("\n\nInforme o tipo do dispositvo de armazenamento a ser procurado: "));
               armazenamento = ArmazenamentoPersistencia.buscar(armazenamento);

               if(armazenamento != null) {
                System.out.println("Espaço total: " + armazenamento.getEspaco());
                System.out.println("Espaço ocupado: " + armazenamento.getOcupado());
                System.out.println("Espaço disponível: " + ArmazenamentoNegocio.calcularEspacoDisponivel(armazenamento));
               }
               else {
                    System.out.println("O dispositivo informado não foi cadastrado");
               }
                break;  
            }
        } while (opcao != 5);
    }
    
}