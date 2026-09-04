import java.time.LocalDate;

public abstract class Cupom {
    private String codigo;
    private int ano_validade;
    private int mes_validade;
    private int dia_validade;
    
    public Cupom(String codigo, int ano_validade, int mes_validade, int dia_validade) {
        this.codigo = codigo;
        this.ano_validade = ano_validade;
        this.mes_validade = mes_validade;
        this.dia_validade = dia_validade;
    }
    
    public String getCodigo() {
        return codigo;
    }
    
    public boolean checarValidade() {
        LocalDate data_atual = LocalDate.now();
        int ano_atual = data_atual.getYear();
        int mes_atual = data_atual.getMonthValue();
        int dia_atual = data_atual.getDayOfMonth();
        
        if (ano_atual < ano_validade) {
            return true;
        }
        if (ano_atual > ano_validade) {
            return false;
        }
        
        if (mes_atual < mes_validade) {
            return true;
        }
        if (mes_atual > mes_validade) {
            return false;
        }
        
        return dia_atual <= dia_validade;
    }
    
    // Cada tipo de cupom calcula seu próprio desconto
    public abstract double calculoDesconto(double valor_total_compra);
}
