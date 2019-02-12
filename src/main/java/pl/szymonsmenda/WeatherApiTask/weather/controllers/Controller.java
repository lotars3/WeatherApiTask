package pl.szymonsmenda.WeatherApiTask.weather.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import pl.szymonsmenda.WeatherApiTask.weather.Models.HttpErrorHandler;
import pl.szymonsmenda.WeatherApiTask.weather.Models.WeatherModel;
import pl.szymonsmenda.WeatherApiTask.weather.dtos.WeatherDto;
import pl.szymonsmenda.WeatherApiTask.weather.services.WeatherService;

import java.util.stream.Collectors;

@org.springframework.stereotype.Controller

public class Controller {

    private WeatherService weatherService;
    @Autowired
    public Controller(WeatherService weatherService) {
        this.weatherService = weatherService;
    }



    @Value("${api.openweathermap.key}")
    String apiKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);


    @GetMapping("/api/typedCity/{typedCity}")
    public ResponseEntity getCity(@PathVariable("typedCity") String typedCity) {
        return ResponseEntity
                .ok()
                .body(weatherService.getCity()
                        .stream()
                        .filter(s -> s.contains(typedCity.toUpperCase()))
                        .collect(Collectors.toList()));
    }


    @GetMapping("/{cityName}")
    @ResponseBody
    public String weatherCity(Model model, @PathVariable("cityName") String cityName) {

        ResponseEntity<WeatherDto> weatherModel;
        try {
            weatherModel = getRestTemplate().getForEntity("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&mode=json&units=metric&appid=" + apiKey, WeatherDto.class);
        } catch (IllegalStateException e) {
            LOGGER.error("Can not get cityName: " + cityName);
            return "redirect:/";
        }

        model.addAttribute("labels", weatherModel.getBody().getMain().stream().map(s -> s.getTemp()).collect(Collectors.toList()));


        model.addAttribute("currencyNameOne", weatherModel.getBody().getCityName());
        model.addAttribute("dataOne", weatherModel.getBody().getMain().stream().map(s -> s.getHumidity()).collect(Collectors.toList()));


        return "weatherChart";


    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplateBuilder().errorHandler(new HttpErrorHandler()).build();
    }



}
