public class TransportadoraB implements Transportadora {
    @Override
    public boolean verificarAtendimentoRegiao(Endereco end) {
        if (end.getCidade().equals("Ibaiti") || end.getCidade().equals("Maringá")) {
            System.out.println("A transportadora não realiza fretes para a cidade socitada.");
            return false;
        }
        return true;
    }
    
    @Override
    public double valorFreteEntrega(double peso_total, double volume_total, Endereco end) {
        double valor_frete;
        if (peso_total > 20) {
            valor_frete = 95;
        }
        else {
            valor_frete = 50;
        }
        return valor_frete;
    }
    
    @Override
    public int prazoEntrega(Endereco end) {
        int prazo_entrega;
        if (end.getCidade().equals("Rolândia")) {
            prazo_entrega = 8;
        }
        else {
           prazo_entrega = 4;
        }
        return prazo_entrega;
    }
}
