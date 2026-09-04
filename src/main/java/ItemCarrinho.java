public class ItemCarrinho {
    private int qtd_item;
    private Produto p;
    
    public ItemCarrinho(Produto p, int qtd_item) {
        this.qtd_item = qtd_item;
        this.p = p;
    }
    
    public int getQtdItem() {
        return qtd_item;
    }
    
    public Produto getP() {
        return p;
    }
    
    public void setQtdItem(int qtd_item) {
        this.qtd_item = qtd_item;
    }
    
    public double calcSubTotal() {
        double total = p.getValor() * qtd_item;
        return total;
    }
    
    public double calcPesoTotal() {
        double peso_total = p.getPesoFisico() * qtd_item;
        return peso_total;
    }
    
    public double calcVolumeTotal() {
        double vol_total = p.getVolume() * qtd_item;
        return vol_total;
    }
}