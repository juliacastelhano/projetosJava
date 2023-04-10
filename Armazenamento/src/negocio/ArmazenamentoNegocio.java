package negocio;
import entidades.Armazenamento;

public class ArmazenamentoNegocio {

    public static Armazenamento salvarDados(Armazenamento armazenamento, String unidade, double valor) {
        double valorConvertido = converter(unidade, valor);
        if(calcularEspacoDisponivel(armazenamento) < valorConvertido) {
            return null;
        }
        else {
            armazenamento.setOcupado(armazenamento.getOcupado() + valorConvertido);
            return armazenamento;
        }
    }

    public static Armazenamento apagarDados(Armazenamento armazenamento, String unidade, double valor) {
        double valorConvertido = converter(unidade, valor);
        if(armazenamento.getOcupado() < valorConvertido) {
            return null;
        }
        else {
            armazenamento.setOcupado(armazenamento.getOcupado() - valorConvertido);
            return armazenamento;
        }
    }

    public static boolean verificarEspaco(Armazenamento armazenamento, double valor) {
        if(armazenamento.getEspaco() >= valor) {
            return true;
        } 
        else {
            return false;
        }
    }

    public static double converter(String unidade, double valor) {
        double resultado;
		
		if(unidade.equals("BYTES".toLowerCase())) {
			resultado = valor / 1073741824;
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

    public static double calcularEspacoDisponivel(Armazenamento armazenamento) {
        return armazenamento.getEspaco() - armazenamento.getOcupado();
    }
   
    
}
