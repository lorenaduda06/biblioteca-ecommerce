public class CupomPercentual extends Cupom {
    private double porcentagem;
    
    public CupomPercentual(String codigo, int ano_validade, int mes_validade, int dia_validade, double porcentagem) {
        super(codigo, ano_validade, mes_validade, dia_validade);
        this.porcentagem = porcentagem;
    }
    
    public double getPorcentagem() {
        return porcentagem;
    }
    
    public void setPorcentagem(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Override
    public double calculoDesconto(double valor_total_compra) {
        double valor_desconto = valor_total_compra * (porcentagem/100.0);
        return valor_desconto;
    }
}
