package application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "meio_de_leitura")
public class Meio_de_Leitura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String Meio_de_Leitura;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getMeio_de_Leitura() {
        return Meio_de_Leitura;
    }
    public void setMeio_de_Leitura(String meio_de_Leitura) {
        Meio_de_Leitura = meio_de_Leitura;
    }
    

}
