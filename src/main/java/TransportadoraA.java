public class TransportadoraA implements Transportadora {
    @Override
    public boolean verificarAtendimentoRegiao(Endereco end) {
        if (end.getCidade().equals("Arapongas") || end.getCidade().equals("Jataizinho")) {
            System.out.println("A transportadora não realiza fretes para a cidade socitada.");
            return false;
        }
        return true;
    }
    
    @Override
    public double valorFreteEntrega(double peso_total, double volume_total, Endereco end) {
        double valor_frete;
        if (peso_total > 30) {
            valor_frete = 80;
        }
        else {
            valor_frete = 40;
        }
        return valor_frete;
    }

    @Override
    public int prazoEntrega(Endereco end) {
        int prazo_entrega;
        if (end.getCidade().equals("Londrina")) {
            prazo_entrega = 3;
        }
        else {
           prazo_entrega = 5;
        }
        return prazo_entrega;
    }
}