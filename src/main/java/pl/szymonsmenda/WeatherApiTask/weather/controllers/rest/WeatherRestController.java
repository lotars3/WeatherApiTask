package pl.szymonsmenda.WeatherApiTask.weather.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szymonsmenda.WeatherApiTask.weather.services.CityService;
import pl.szymonsmenda.WeatherApiTask.weather.services.WeatherLogService;

@RestController
@RequestMapping("rest")
public class WeatherRestController implements pl.szymonsmenda.WeatherApiTask.weather.controllers.rest.RestController {
    @Autowired
    private WeatherLogService weatherLogService;
    @Autowired
    private CityService cityService;



    @GetMapping(value = "/avaliablecity", produces = "application/json")
    public ResponseEntity AvaliableCity() {

        return ResponseEntity.ok(cityService.getAllCity());
    }



}
