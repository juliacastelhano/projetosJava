package entidades;

public class Conta {
	
	private String nomeCliente;
	private int numeroAgencia;
	private int numeroConta;
	private float limite;
	private float saldo;
	
	public Conta() {
		
	}
	
	public Conta(int numeroAgencia, int numeroConta) {
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
	}
	
	public Conta(String nomeCliente, int numeroAgencia, int numeroConta, float limite, float saldo) {
		this.nomeCliente = nomeCliente;
		this.numeroAgencia = numeroAgencia;
		this.numeroConta = numeroConta;
		this.limite = limite;
		this.saldo = saldo;
	}
	
	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public int getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(int numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(int numeroConta) {
		this.numeroConta = numeroConta;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
}