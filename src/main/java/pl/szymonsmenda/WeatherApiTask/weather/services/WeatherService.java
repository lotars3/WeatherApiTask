package pl.szymonsmenda.WeatherApiTask.weather.services;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class WeatherService {

    @Bean
    public List<String> getCity(){
        return  Arrays.asList("London");
    }
}
