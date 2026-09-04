public class Pagamento {
    private String forma_pg;
    private double val;
    
    public Pagamento(String forma_pg, double val) {
        this.forma_pg = forma_pg;
        this.val = val;
    }
    
    public String getFormaPg() {
        return forma_pg;
    }
    
    public double getVal() {
        return val;
    }
}
