package WorkDB.API.Clima.Controller;
import WorkDB.API.Clima.Model.HistoricoPesquisaModel;
import WorkDB.API.Clima.Repository.HistoricoPesquisaRepository;
import WorkDB.API.Clima.Service.WeatherService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@CrossOrigin(origins = "*")
@RestController
public class ClimaController {
    @Autowired
    private WeatherService WeatherService;

    @Autowired
    private HistoricoPesquisaRepository historicoPesquisaRepository;

    @GetMapping("/clima/{cidade}")
    public String getClima(@PathVariable String cidade) {
        String clima = WeatherService.getWeather(cidade);
        HistoricoPesquisaModel historicoPesquisaModel = new HistoricoPesquisaModel();

        if (clima != null) {
            historicoPesquisaModel.setCidade(cidade);
            historicoPesquisaModel.setData_pesquisa(LocalDateTime.now());
            historicoPesquisaRepository.save(historicoPesquisaModel);
        }
        return clima;
    }

}
