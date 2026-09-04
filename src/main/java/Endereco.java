public class Endereco {
    private String rua;
    private int num;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;

    public Endereco(String rua, int num, String bairro, String cidade, String estado, String cep) {
        this.rua = rua;
        this.num = num;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
    }
    
    public String getRua() {
        return rua;
    }
    
    public int getNum() {
        return num;
    }
    
    public String getBairro() {
        return bairro;
    }
    
    public String getCidade() {
        return cidade;
    }
    
    public String getEstado() {
        return estado;
    }
    
    public String getCep() {
        return cep;
    }
}