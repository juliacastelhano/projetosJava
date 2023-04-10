package persistencia;
import java.util.ArrayList;
import java.util.List;
import entidades.Armazenamento;

public class ArmazenamentoPersistencia {  
      
    private static List<Armazenamento> armazenar = new ArrayList<Armazenamento>();

    public static void incluir(Armazenamento armazenamento) {
        armazenar.add(armazenamento);
    }

    public static Armazenamento buscar(Armazenamento armazenamento) {
        for(Armazenamento item: armazenar) {
            if(item.getTipoDispo().equals(armazenamento.getTipoDispo())) {
                return item;
            }
        }
        return null;
    }
    
    public static void atualizar(Armazenamento armazenamento) {
        int i = 0;
        for(Armazenamento item: armazenar) {
            if(item.getTipoDispo().equals(armazenamento.getTipoDispo())) {
                armazenar.set(i, armazenamento);
            }
            i++;
        }
    }

} 