package persistencia;

import java.util.ArrayList;
import java.util.List;

import entidades.Armazenamento;

public class ArmazenamentoPersistencia {

	static List<Armazenamento> objetos = new ArrayList<Armazenamento>();
	
	public static void incluir(Armazenamento armazenamento) {
		objetos.add(armazenamento);
	}
	
	public static Armazenamento procurar(Armazenamento armazenamento) { 
		for(Armazenamento item: objetos) {
			if(item.getDescricao().equals(armazenamento.getDescricao())) {
				return item;
			}
		}
		return null;
	}
	
	public static void atualizar(Armazenamento armazenamento) {
			int i = 0;
		for(Armazenamento item: objetos) {
			if(item.getDescricao().equals(armazenamento.getDescricao())) {
				objetos.set(i, armazenamento);
			}
			i++;
		}
	}
	
}
