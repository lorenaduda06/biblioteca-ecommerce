import java.util.List;
import java.util.ArrayList;

public class Carrinho {
    // Um carrinho pode ter vários itens
    private List<ItemCarrinho> lista_itens_carrinho = new ArrayList<>();
    private Cupom cp_aplicado;
    
    public void aplicarCupom(Cupom cp_aplicado) {
        this.cp_aplicado = cp_aplicado;
    }
    
    public Cupom getCpAplicado() {
        return cp_aplicado;
    }
    
    public void adicionarItemCarrinho(Produto p, int qtd) {
        if (qtd <= 0) {
            System.out.println("A quantidade deve ser maior que zero.");
            return;
        }
        for (int i = 0; i < lista_itens_carrinho.size(); i++) {
            ItemCarrinho item = lista_itens_carrinho.get(i);
            if (item.getP().getId() == p.getId()) {
                item.setQtdItem(item.getQtdItem() + qtd);
                return;
            }
        }
        ItemCarrinho novo_item = new ItemCarrinho(p, qtd);
        lista_itens_carrinho.add(novo_item);
    }
    
    public void removerItemCarrinho(int id_produto) {
        for (int i = 0; i < lista_itens_carrinho.size(); i++) {
            if (lista_itens_carrinho.get(i).getP().getId() == id_produto) {
                lista_itens_carrinho.remove(i);
                return;
            }
        }
    }
    
    public void alterarItemCarrinho(int id_produto, int nova_qtd) {
        if (nova_qtd <= 0) {
            System.out.println("A quantidade deve ser maior que zero.");
            return;
        }
        for (int i = 0; i < lista_itens_carrinho.size(); i++) {
            if (lista_itens_carrinho.get(i).getP().getId() == id_produto) {
                lista_itens_carrinho.get(i).setQtdItem(nova_qtd);
                return;
            }
        }
    }
    
    public List<ItemCarrinho> getItens() {
        return new ArrayList<>(lista_itens_carrinho);
    }
    
    // Função para calcular o valor_total
    public double valorTotal() {
        double val_total = 0;
        for (int i = 0; i < lista_itens_carrinho.size(); i++) {
            val_total += lista_itens_carrinho.get(i).calcSubTotal();
        }
        return val_total;
    }
    
    public double pesoTotal() {
        double peso_total = 0;
        for (int i = 0; i < lista_itens_carrinho.size(); i++) {
            peso_total += lista_itens_carrinho.get(i).calcPesoTotal();
        }
        return peso_total;
    }
    
    public double volumeTotal() {
        double vol_total = 0;
        for (int i = 0; i < lista_itens_carrinho.size(); i++) {
            vol_total += lista_itens_carrinho.get(i).calcVolumeTotal();
        }
        return vol_total;
    }
}