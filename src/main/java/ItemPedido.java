public class ItemPedido {
    private int id_produto;
    private String nome_produto;
    private double valor_unidade;
    private int qtd;
    
    public ItemPedido(int id_produto, String nome_produto, double valor_unidade, int qtd) {
        this.id_produto = id_produto;
        this.nome_produto = nome_produto;
        this.valor_unidade = valor_unidade;
        this.qtd = qtd;
    }
    
    public int getIdProduto() {
        return id_produto;
    }
    
    public String getNomeProduto() {
        return nome_produto;
    }
    
    public double getValorUnidade() {
        return valor_unidade;
    }
    
    public int getQtd() {
        return qtd;
    }
    
    public double calcSubTotal() {
        return valor_unidade * qtd;
    }
}
