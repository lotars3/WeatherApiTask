package pl.szymonsmenda.WeatherApiTask.weather.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.WeatherApiTask.weather.entites.CityEntity;
import pl.szymonsmenda.WeatherApiTask.weather.repositories.CityRepository;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public  Iterable<CityEntity> getAllCity(){
        return cityRepository.findAll();
    }
}
