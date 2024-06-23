package application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "preco")
public class Preco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String Local_de_Compra;
    private float Preco;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getLocal_de_Compra() {
        return Local_de_Compra;
    }
    public void setLocal_de_Compra(String local_de_Compra) {
        Local_de_Compra = local_de_Compra;
    }
    public float getPreco() {
        return Preco;
    }
    public void setPreco(float preco) {
        Preco = preco;
    }     

}
