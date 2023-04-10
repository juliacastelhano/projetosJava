import java.util.ArrayList;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
		List<Integer> lista = new ArrayList<Integer>();
		int i;
		
		for(i = 1; i <= 20; i++) {
			lista.add(i);
		}
		System.out.println(lista);
		System.out.println("-----------------------");
		/*Percorrer cada um dos elementos do ArrayList
		e acessar os elementos a partir do seu Ã­ndice*/
		for(i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
		System.out.println("-----------------------");
		/*
		 * Percorrer cada um dos elementos do ArrayLista com foreach
		 * e acessar estes elementos
		 */
		for(Integer item: lista) {
			System.out.println(item);
		}
	}
}
