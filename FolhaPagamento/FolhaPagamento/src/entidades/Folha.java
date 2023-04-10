package entidades;

public class Folha {
	private String nomeFuncionario;
	private int mesPagamento;
	private int anoPagamento;
	private int numeroHoras;
	private float valorHora;
	
	public String getNomeFuncionario() {
		return nomeFuncionario;
	}

	public void setNomeFuncionario(String nomeFuncionario) {
		this.nomeFuncionario = nomeFuncionario;
	}

	public int getMesPagamento() {
		return mesPagamento;
	}

	public void setMesPagamento(int mesPagamento) {
		this.mesPagamento = mesPagamento;
	}

	public int getAnoPagamento() {
		return anoPagamento;
	}

	public void setAnoPagamento(int anoPagamento) {
		this.anoPagamento = anoPagamento;
	}

	public int getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(int numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	public float getValorHora() {
		return valorHora;
	}

	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}
}