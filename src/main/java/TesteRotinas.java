import java.util.ArrayList;
import java.util.List;

public class TesteRotinas {

    public static void main(String[] args) {
        System.out.println("* ROTINA 1 *");
        
        List<Foto> lista_fotos1 = new ArrayList<>();
        lista_fotos1.add(new Foto("foto1.png", "Descrição foto 1"));
        Produto p1 = new Produto(1, "Produto 1", 100.0, lista_fotos1, 0.5, 1.0);
        
        List<Foto> lista_fotos2 = new ArrayList<>();
        lista_fotos2.add(new Foto("foto2.png", "Descrição foto 2"));
        Produto p2 = new Produto(2, "Produto 2", 200.0, lista_fotos2, 1.0, 2.0);
        
        Transportadora tA = new TransportadoraA();
        Transportadora tB = new TransportadoraB();
        
        Logistica lg = new Logistica();
        lg.addTransportadora((tA));
        lg.addTransportadora((tB));
        
        Cupom cp = new CupomPercentual("TESTE1", 2026, 12, 31, 10);
        RepositorioCupons rep_cp = new RepositorioCupons();
        rep_cp.cadastrarCupom(cp);
        
        Carrinho c = new Carrinho();
        c.adicionarItemCarrinho(p1, 1);
        c.adicionarItemCarrinho(p2, 2);
        
        Endereco end_destino = new Endereco("Rua exemplo", 123, "Bairro Exemplo", "Londrina", "PR", "12345-678");
        
        OpcaoFrete freteMaisRapido = lg.opFreteMaisRapido(c, end_destino);
        System.out.println("Frete escolhido (mais rápido): " + freteMaisRapido.getPrazoEntrega() + " dias, R$" + freteMaisRapido.getValorFrete());
        
        if (rep_cp.validar("TESTE1")) {
            c.aplicarCupom(rep_cp.buscarPorCodigo("TESTE1"));
            System.out.println("Cupom TESTE1 aplicado com sucesso.");
        }
        
        Pedido p = new Pedido(c, freteMaisRapido);
        System.out.println("Pedido gerado. Valor total: R$" + p.calculoValTotal());
        System.out.println("Status inicial: " + p.getStatusPedido());
        
        // ROTINA 2
        System.out.println("* ROTINA 2 *");
        double val_total = p.calculoValTotal();
        double valor_60 = val_total * 0.6;
        double valor_40 = val_total - valor_60;
        
        p.registroPagamento(FormaPagamento.CARTAO_CREDITO, valor_60);
        System.out.println("Pago 60% (R$" + valor_60 + ") via Cartão de Crédito.");
        System.out.println("Status após 60%: " + p.getStatusPedido()); // esperado: AGUARDANDO_PAGAMENTO
        
        p.registroPagamento(FormaPagamento.PIX, valor_40);
        System.out.println("Pago 40% (R$" + valor_40 + ") via Pix.");
        System.out.println("Status após 100%: " + p.getStatusPedido()); // esperado: PAGO
        
        // ROTINA 3
        System.out.println("* ROTINA 3 *");
        p.solicitarDevolucao();
        p.aprovarDevolucao();
        System.out.println("Status final: " + p.getStatusPedido()); // esperado: DEVOLVIDA
    }
}
