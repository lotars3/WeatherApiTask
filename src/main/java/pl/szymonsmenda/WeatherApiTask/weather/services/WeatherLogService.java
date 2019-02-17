package pl.szymonsmenda.WeatherApiTask.weather.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.szymonsmenda.WeatherApiTask.weather.dtos.ForecastWeatherDto;
import pl.szymonsmenda.WeatherApiTask.weather.dtos.WeatherDto;
import pl.szymonsmenda.WeatherApiTask.weather.entites.CityEntity;
import pl.szymonsmenda.WeatherApiTask.weather.entites.WeatherLogEntity;
import pl.szymonsmenda.WeatherApiTask.weather.mappers.WeatherDtoToWeatherEntityMapper;
import pl.szymonsmenda.WeatherApiTask.weather.repositories.CityRepository;
import pl.szymonsmenda.WeatherApiTask.weather.repositories.WeatherLogRepository;

import java.util.List;


@Service
public class WeatherLogService {

    @Autowired
    private WeatherLogRepository weatherLogRepository;
    @Autowired
    private CityRepository cityRepository;



    @Value("${api.openweathermap.key}")
    String apiKey;

    public static final String URL_TO_API = "http://api.openweathermap.org/data/2.5/weather?q=";




    public boolean isWeatherLogSaved(WeatherDto weatherDto) {
        WeatherLogEntity weatherLogEntity = WeatherDtoToWeatherEntityMapper.convert(weatherDto);
//        CityEntity cityLogEntity = WeatherDtoToWeatherEntityMapper.convert(cityDto);
        return weatherLogRepository.save(weatherLogEntity) != null; //&&(cityRepository.save(cityLogEntity) !=null) ;
    }

//    public List<WeatherLogEntity> findCityName(String cityName ){
//        CityEntity cityEntity = cityRepository.findByCityName(cityName);
//        return weatherLogRepository.findByCity(cityEntity);
//    }

    public WeatherDto getCurrentWeather(String cityName) {
//        findCityName(cityName);
        RestTemplate restTemplate = getRestTemplate();
        WeatherDto weatherDto = restTemplate.getForObject(URL_TO_API + cityName + "&units=metric&appid=" + apiKey, WeatherDto.class);
//        CityDto cityDto = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&units=metric&appid=" + apiKey, CityDto.class);

        isWeatherLogSaved(weatherDto);
        return weatherDto;
    }

    public ForecastWeatherDto getForecastWeather(String cityName) {
        RestTemplate restTemplate = getRestTemplate();
        return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&units=metric&appid=" + apiKey, ForecastWeatherDto.class);
    }

    public CityEntity findCityName(String cityName) {

        return cityRepository.findByCityName(cityName);
    }




    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
