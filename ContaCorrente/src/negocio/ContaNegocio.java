package negocio;
import entidades.Conta;

public class ContaNegocio {

	public static Conta depositar(Conta conta, float valor) {
		conta.setSaldo(conta.getSaldo() + valor);
		return conta;
	}
	
	public static Conta sacar(Conta conta, float valor) {
		conta.setSaldo(conta.getSaldo() - valor);
		return conta;
	}
	
	public static boolean verificarSaldo(Conta conta, float valor) {
		if(conta.getSaldo() + conta.getLimite() <= valor) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static float calcularSaldoDisponivel(Conta conta) {
		return conta.getSaldo() + conta.getLimite();
	}
}
