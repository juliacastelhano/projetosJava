package persistencia;
import entidades.Conta;
import java.util.ArrayList;
import java.util.List;

public class ContaPersistencia {

	private static List<Conta> contas = new ArrayList<Conta>();
	
	public static void incluirConta(Conta objConta) {
		contas.add(objConta);
	}
	
	public static Conta buscarConta(Conta conta) {
		for(Conta objConta: contas) {
			if(objConta.getNumeroAgencia() == conta.getNumeroAgencia() && objConta.getNumeroConta() == conta.getNumeroConta()) {
				return objConta;
			}
		}
		return null;
	}
	
	public static void atualizarConta(Conta conta) {
		int i = 0;
		for(Conta objConta: contas) {
			if(objConta.getNumeroAgencia() == conta.getNumeroAgencia() && objConta.getNumeroConta() == conta.getNumeroConta()) {
				contas.set(i, conta);
				return;
			}
			i++;
		}
	}
}
