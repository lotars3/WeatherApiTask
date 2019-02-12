package pl.szymonsmenda.WeatherApiTask.weather.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.szymonsmenda.WeatherApiTask.weather.dtos.ForecastWeatherDto;
import pl.szymonsmenda.WeatherApiTask.weather.dtos.WeatherDto;
import pl.szymonsmenda.WeatherApiTask.weather.entites.WeatherLogEntity;
import pl.szymonsmenda.WeatherApiTask.weather.mappers.WeatherDtoToWeatherEntityMapper;
import pl.szymonsmenda.WeatherApiTask.weather.repositories.WeatherLogRepository;


@Service
public class WeatherLogService {


    @Value("${api.openweathermap.key}")
    String apiKey;


    final WeatherLogRepository weatherLogRepository;

    @Autowired
    public WeatherLogService(WeatherLogRepository weatherLogRepository) {
        this.weatherLogRepository = weatherLogRepository;
    }

    public boolean saveWeatherLog(WeatherDto weatherDto) {
        WeatherLogEntity weatherLogEntity = WeatherDtoToWeatherEntityMapper.convert(weatherDto);
        return weatherLogRepository.save(weatherLogEntity) != null;
    }

//    public WeatherDto getCurrentWeather(String cityName) {
//        RestTemplate restTemplate = getRestTemplate();
//        WeatherDto weatherDto = restTemplate.getForObject("http://api.openweathermap.org/data/2.5/weather?q=" + cityName + "&units=metric&appid=" + apiKey, WeatherDto.class);
//
//        saveWeatherLog(weatherDto);
//        return weatherDto;
//    }
//
//    public ForecastWeatherDto getForecastWeather(String cityName) {
//        RestTemplate restTemplate = getRestTemplate();
//        return restTemplate.getForObject("http://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&units=metric&appid=" + apiKey, ForecastWeatherDto.class);
//    }

    public WeatherLogEntity getWeatherData(String cityName) {

        return weatherLogRepository.findByCityName(cityName);
//        return weatherLogRepository.findById(id).get();
    }

//    public WeatherLogEntity getAllCity() {
//
//        return weatherLogRepository.findAllByCityName();
//    }
//
//
//    @Bean
//    public RestTemplate getRestTemplate() {
//        return new RestTemplate();
//    }
}
