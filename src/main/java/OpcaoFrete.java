public class OpcaoFrete {
    private Transportadora t;
    private double valor_frete;
    private int prazo_entrega;
    
    public OpcaoFrete(Transportadora t, double valor_frete, int prazo_entrega) {
        this.t = t;
        this.valor_frete = valor_frete;
        this.prazo_entrega = prazo_entrega;
    }
    
    public Transportadora getT() {
        return t;
    }
    
    public double getValorFrete() {
        return valor_frete;
    }
    
    public int getPrazoEntrega() {
        return prazo_entrega;
    }
}
