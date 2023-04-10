package negocio;
import entidades.Folha;

public class FolhaNegocio {
	public static float calcularSalarioBruto(Folha folha){
		return folha.getNumeroHoras() * folha.getValorHora();
	}
	
	public static float calcularIR(float bruto){
		if(bruto <= 1372.81){
			return 0;
		}
		else{
			if(bruto <= 2743.25){
				return (float) ((bruto * .15) - 205.92);
			}
			else{
				return (float) ((bruto * .275) - 548.82);
			}
		}
	}
	
	public static float calcularINSS(float bruto){
		if(bruto <= 868.29){
			return (float) (bruto * 0.08);
		}
		else
		{
			if(bruto <= 1447.14){
				return (float) (bruto * 0.09);
			}
			else{
				if(bruto <= 2894.28){
					return (float) (bruto * 0.11);
				}
				else
				{
					return (float) 318.37;
				}
			}
		}
	}
	
	public static float calcularFGTS(float bruto){
		return (float) (bruto * 0.08);
	}
	
	public static float calcularSalarioLiquido(float bruto, float inss, float ir){
		return bruto - inss - ir;
	}
}
