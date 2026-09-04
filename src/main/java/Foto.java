public class Foto {
    private String arquivo;
    private String descricao;
    
    public Foto(String arquivo, String descricao) {
        this.arquivo = arquivo;
        this.descricao = descricao;
    }
    
    public String getArquivo() {
        return arquivo;
    }
    
    public String getDescricao() {
        return descricao;
    }
}