import java.util.List;
import java.util.ArrayList;

public class Logistica {
    private List<Transportadora> lista_transportadoras = new ArrayList<>();
    
    public void addTransportadora(Transportadora t) {
        lista_transportadoras.add(t);
    }
    
    public List<OpcaoFrete> calcularFrete(Carrinho c, Endereco end) {
        List<OpcaoFrete> op = new ArrayList<>();
        double peso_total = c.pesoTotal();
        double volume_total = c.volumeTotal();
        
        for (int i = 0; i < lista_transportadoras.size(); i++) {
            Transportadora t = lista_transportadoras.get(i);
            
            if (t.verificarAtendimentoRegiao(end)) {
                double valor = t.valorFreteEntrega(peso_total, volume_total, end);
                int prazo = t.prazoEntrega(end);
                op.add(new OpcaoFrete(t, valor, prazo));
            }
        }
        return op;
    }
    
    public OpcaoFrete opFreteMaisRapido(Carrinho c, Endereco end) {
        List<OpcaoFrete> op = calcularFrete(c, end);
        if (op.isEmpty()) {
            return null;
        }
        
        OpcaoFrete op_escolhida = op.get(0);
        for (int i = 0; i < op.size(); i++) {
            if (op.get(i).getPrazoEntrega() < op_escolhida.getPrazoEntrega()) {
                op_escolhida = op.get(i);
            }
        }
        return op_escolhida;
    }
    
    public OpcaoFrete opFreteMelhorVal(Carrinho c, Endereco end) {
        List<OpcaoFrete> op = calcularFrete(c, end);
        if (op.isEmpty()) {
            return null;
        }
        
        OpcaoFrete op_escolhida = op.get(0);
        for (int i = 0; i < op.size(); i++) {
            if (op.get(i).getValorFrete()< op_escolhida.getValorFrete()) {
                op_escolhida = op.get(i);
            }
        }
        return op_escolhida;
    }
    
    public List<OpcaoFrete> opFreteComLimiteDias(Carrinho c, Endereco end, int limite_dias) {
        List<OpcaoFrete> op = calcularFrete(c, end);
        List<OpcaoFrete> destinos_validos = new ArrayList<>();
        
        for (int i = 0; i < op.size(); i++) {
            if (op.get(i).getPrazoEntrega() <= limite_dias) {
                destinos_validos.add(op.get(i));
            }
        }
        return destinos_validos;
    }
}
