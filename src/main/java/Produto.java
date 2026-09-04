import java.util.ArrayList;
import java.util.List;

public class Produto {
    private int id;
    private String nome;
    private double valor;
    private List<Foto> fotos;
    private double volume;
    private double peso_fisico;
    
    public Produto(int id, String nome, double valor, List<Foto> fotos, double volume, double peso_fisico) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.fotos = fotos;
        this.volume = volume;
        this.peso_fisico = peso_fisico;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNome() {
        return nome;
    }
    
    public double getValor() {
        return valor;
    }
    
    public List<Foto> getFotos() {
        return new ArrayList<>(fotos);
    }
    
    public double getVolume() {
        return volume;
    }
    
    public double getPesoFisico() {
        return peso_fisico;
    }
}