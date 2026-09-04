import java.util.List;
import java.util.ArrayList;

public class RepositorioCupons {
    private List<Cupom> lista_cupons = new ArrayList<>();
    
    public void cadastrarCupom(Cupom c) {
        lista_cupons.add(c);
    }
    
    public Cupom buscarPorCodigo(String codigo) {
        for (int i = 0; i < lista_cupons.size(); i++) {
            if (lista_cupons.get(i).getCodigo().equals(codigo)) {
                return lista_cupons.get(i);
            }
        }
        return null;
    }
    
    public boolean validar(String codigo) {
        Cupom c = buscarPorCodigo(codigo);
        if (c == null) {
            return false;
        }
        return c.checarValidade();
    }
}
