package persistencia;

import java.util.ArrayList;
import java.util.List;

import entidades.Folha;

public class FolhaPersistencia {
	static List<Folha> folhas = new ArrayList<Folha>();
	
	public static void incluirFolha(Folha folha) {
		folhas.add(folha);
	}
	
	public static Folha consultarFolha(Folha folha) {
		for(Folha itemFolha: folhas) {
			if(itemFolha.getNomeFuncionario().equals(folha.getNomeFuncionario()) && itemFolha.getMesPagamento() == folha.getMesPagamento() && itemFolha.getAnoPagamento() == folha.getAnoPagamento()) {
				return itemFolha;
			}
		}
		return null;
	}
	
	public static ArrayList<Folha> listarFolhasMesAno(Folha folha){
		List<Folha> folhasMesAno = new ArrayList<Folha>();
		for(Folha itemFolha: folhas) {
			if(itemFolha.getMesPagamento() == folha.getMesPagamento() && itemFolha.getAnoPagamento() == folha.getAnoPagamento()) {
				folhasMesAno.add(itemFolha);
			}
		}
		return (ArrayList<Folha>) folhasMesAno;
	}
}
