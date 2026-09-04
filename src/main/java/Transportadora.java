public interface Transportadora {
    public boolean verificarAtendimentoRegiao(Endereco end);
    
    public double valorFreteEntrega(double peso_total, double volume_total, Endereco end);
    
    public int prazoEntrega(Endereco end);
}