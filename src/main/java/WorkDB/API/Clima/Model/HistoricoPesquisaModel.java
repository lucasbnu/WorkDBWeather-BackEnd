package WorkDB.API.Clima.Model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "historico_pesquisa")
@Entity
public class HistoricoPesquisaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_historico")
    private int id_historico;

    @Column(name="cidade")
    private String cidade;

    @Column(name="data_pesquisa")
    private LocalDateTime data_pesquisa;

    public int getId_historico() {
        return id_historico;
    }

    public void setId_historico(int id_historico) {
        this.id_historico = id_historico;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }


    public LocalDateTime getData_pesquisa() {
        return data_pesquisa;
    }

    public void setData_pesquisa(LocalDateTime data_pesquisa) {
        this.data_pesquisa = data_pesquisa;
    }
}
