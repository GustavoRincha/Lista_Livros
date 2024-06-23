package application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Titulo;
    private String Genero;
    private String Editora;
    private String Data_de_Lancamento;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitulo() {
        return Titulo;
    }
    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
    public String getGenero() {
        return Genero;
    }
    public void setGenero(String genero) {
        Genero = genero;
    }
    public String getEditora() {
        return Editora;
    }
    public void setEditora(String editora) {
        Editora = editora;
    }
    public String getData_de_Lancamento() {
        return Data_de_Lancamento;
    }
    public void setData_de_Lancamento(String data_de_Lancamento) {
        Data_de_Lancamento = data_de_Lancamento;
    }
    
    
}
