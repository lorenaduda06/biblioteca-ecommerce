public class CupomFixo extends Cupom {
    private double valor_desconto;
    
    public CupomFixo(String codigo, int ano_validade, int mes_validade, int dia_validade, double valor_desconto) {
        super(codigo, ano_validade, mes_validade, dia_validade);
        this.valor_desconto = valor_desconto;
    }
    
    public double getValorDesconto() {
        return valor_desconto;
    }
    
    public void setValorDesconto(double valor_desconto) {
        this.valor_desconto = valor_desconto;
    }
    
    @Override
    public double calculoDesconto(double valor_total_compra) {
        if (valor_desconto > valor_total_compra) {
            return valor_total_compra;
        }
        return valor_desconto;
    }
}
