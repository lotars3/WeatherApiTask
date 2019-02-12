package pl.szymonsmenda.WeatherApiTask.weather.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.szymonsmenda.WeatherApiTask.weather.services.WeatherLogService;

@RestController
@RequestMapping("rest")
public class WeatherRestController {
    final WeatherLogService weatherLogService;


    @Autowired
    public WeatherRestController(WeatherLogService weatherLogService) {
        this.weatherLogService = weatherLogService;
    }


    @GetMapping(value = "/weather/{cityName}", produces = "application/json")
    public ResponseEntity CurrentWeatherByCityName(@PathVariable("cityName") String cityName) {

        return ResponseEntity.ok(weatherLogService.getWeatherData(cityName));
    }

//    @GetMapping(value = "/weather/", produces = "application/json")
//    public ResponseEntity allCity() {
//
//        return ResponseEntity.ok(weatherLogService.getAllCity());
//    }


}
