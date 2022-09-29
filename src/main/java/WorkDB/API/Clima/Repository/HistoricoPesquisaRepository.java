package WorkDB.API.Clima.Repository;

import WorkDB.API.Clima.Model.HistoricoPesquisaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoricoPesquisaRepository extends JpaRepository<HistoricoPesquisaModel, Integer> {
    public List<HistoricoPesquisaModel> findByCidade(String cidade);

}

