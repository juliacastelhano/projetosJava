package negocio;

import entidades.Armazenamento;

public class ArmazenamentoNegocio {
	

	public static Armazenamento salvarDados(Armazenamento armazenamento, String unidade, double valor) {
		double valorConvertido = converterUnidade(unidade, valor);
		if(calcularEspacoDisponivel(armazenamento) < valorConvertido) {
			return null;
		}
		else {
			armazenamento.setOcupado(armazenamento.getOcupado() + valorConvertido);
			return armazenamento;
		}
	}
	
	public static Armazenamento removerDados(Armazenamento armazenamento, String unidade, double valor) {
		double valorConvertido = converterUnidade(unidade, valor);
		if(armazenamento.getOcupado() < valorConvertido) {
		//if(calcularEspacoDisponivel(armazenamento) > valorConvertido) {
		//if(calcularEspacoDisponivel(armazenamento) > valor) {
			return null;
		}
		else {
			armazenamento.setOcupado(armazenamento.getOcupado() - valorConvertido);
			return armazenamento;
		}
	}
	
	private static double converterUnidade(String unidade, double valor) {
		double resultado;
		
		if(unidade.equals("BYTES".toLowerCase())) {
			resultado = valor/1073741824;
		}
		else {
			if(unidade.equals("KB".toLowerCase())) {
				resultado = valor / 1048576;
			}
			else {
				if(unidade.equals("MB".toLowerCase())) {
					resultado = valor / 1024;
				}
				else {
					resultado = valor;
				}
			}
		}
		
		return resultado;
	}
	
	/*private */ public static double calcularEspacoDisponivel(Armazenamento armazenamento) {
		return armazenamento.getEspaco() - armazenamento.getOcupado();
	}
	
}
