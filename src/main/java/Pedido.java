import java.util.List;
import java.util.ArrayList;

public class Pedido {
    private List<ItemPedido> lista_itens = new ArrayList<>();
    private double val_frete;
    private double val_desconto;
    private String status_pedido;
    private List<Pagamento> lista_pagamentos = new ArrayList<>();
    
    public Pedido(Carrinho c, OpcaoFrete op_frete) {
        this.val_frete = op_frete.getValorFrete();
        this.status_pedido = StatusPedido.AGUARDANDO_PAGAMENTO;
        
        List<ItemCarrinho> itens = c.getItens();
        for (int i = 0; i < itens.size(); i++) {
            ItemCarrinho ic = itens.get(i);
            ItemPedido ip = new ItemPedido(ic.getP().getId(), ic.getP().getNome(), ic.getP().getValor(), ic.getQtdItem());
            this.lista_itens.add(ip);
        }
        
        Cupom cp = c.getCpAplicado();
        if (cp != null && cp.checarValidade()) {
            this.val_desconto = cp.calculoDesconto(calculoValProdutos());
        }
        else {
            this.val_desconto = 0;
        }
    }
    
    public double calculoValProdutos() {
        double total = 0;
        for (int i = 0; i < lista_itens.size(); i++) {
            total += lista_itens.get(i).calcSubTotal();
        }
        return total;
    }
    
    public double calculoValTotal() {
        double val_total = calculoValProdutos() - val_desconto + val_frete;
        return val_total;
    }
    
    public double calculoTotalPago() {
        double total = 0;
        for (int i = 0; i < lista_pagamentos.size(); i++) {
            total += lista_pagamentos.get(i).getVal();
        }
        return total;
    }
    
    public void registroPagamento(String forma_pg, double val) {
        Pagamento pg = new Pagamento(forma_pg, val);
        lista_pagamentos.add(pg);
        
        if (calculoTotalPago() >= calculoValTotal()) {
            status_pedido = StatusPedido.PAGO;
        }
    }
    
    public void solicitarDevolucao() {
        if (!status_pedido.equals(StatusPedido.PAGO)) {
            System.out.println("Não é possível realizar devolução. O pedido não está com status pago.");
            return;
        }
        System.out.println("Devolução solicitada, aguardando aprovação.");
    }
    
    public void aprovarDevolucao() {
        double total_estornado = 0;
        if (!status_pedido.equals(StatusPedido.PAGO)) {
            System.out.println("Não é possível realizar devolução. O pedido não está com status pago.");
            return;
        }
        System.out.println("* Estorno do pedido *");
        for (int i = 0; i < lista_pagamentos.size(); i++) {
            Pagamento p = lista_pagamentos.get(i);
            System.out.printf("%-18s R$ %.2f%n", p.getFormaPg() + ":", p.getVal());
            total_estornado += p.getVal();
        }
        System.out.printf("%-18s R$ %.2f%n", "Total estornado:", total_estornado);
        status_pedido = StatusPedido.DEVOLVIDA;
        System.out.println("Status: " + status_pedido);
    }
    
    public String getStatusPedido() {
        return status_pedido;
    }
    
    public List<Pagamento> getListaPagamentos() {
        return new ArrayList<>(lista_pagamentos);
    }
}
