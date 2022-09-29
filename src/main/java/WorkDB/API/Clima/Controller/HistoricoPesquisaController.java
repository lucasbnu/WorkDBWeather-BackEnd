package WorkDB.API.Clima.Controller;
import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Optional;

import WorkDB.API.Clima.Model.HistoricoPesquisaModel;
import WorkDB.API.Clima.Repository.HistoricoPesquisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*")
@RestController
public class HistoricoPesquisaController {
    @Autowired
    private HistoricoPesquisaRepository historicoPesquisaRepository;

    @GetMapping("/historico")
    public List<HistoricoPesquisaModel> getHistorico() {
        return historicoPesquisaRepository.findAll();
    }

    @GetMapping("/historico/{cidade}")
    public List<HistoricoPesquisaModel> getHistoricoCidade(@PathVariable String cidade) {
        return historicoPesquisaRepository.findByCidade(cidade);
    }

    @PostMapping("/historico")
    public HistoricoPesquisaModel postHistorico(@RequestBody HistoricoPesquisaModel historico) {
        return historicoPesquisaRepository.save(historico);
    }

    @DeleteMapping("/historico/{id}")
    public void deleteHistorico(@PathVariable int id) {
        historicoPesquisaRepository.deleteById(id);
    }
    
    @RequestMapping(value = "/historico/{id}", method = RequestMethod.PUT)
    public void updateHistorico(@PathVariable int id, @RequestBody HistoricoPesquisaModel historico) {
        Optional<HistoricoPesquisaModel> historicoPesquisa = historicoPesquisaRepository.findById(id);
        if (historicoPesquisa.isPresent()) {
            historico.setId_historico(id);
            historicoPesquisaRepository.save(historico);
        }
    }
}
