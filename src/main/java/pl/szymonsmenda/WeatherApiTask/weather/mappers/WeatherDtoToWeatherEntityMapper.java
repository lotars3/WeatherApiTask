package pl.szymonsmenda.WeatherApiTask.weather.mappers;

import pl.szymonsmenda.WeatherApiTask.weather.dtos.WeatherDto;
import pl.szymonsmenda.WeatherApiTask.weather.entites.CityEntity;
import pl.szymonsmenda.WeatherApiTask.weather.entites.WeatherLogEntity;


import java.time.LocalDateTime;

public class WeatherDtoToWeatherEntityMapper {
    public static WeatherLogEntity convert(WeatherDto weatherDto){
        WeatherLogEntity weatherLogEntity = new WeatherLogEntity();
//        weatherLogEntity.setCityName(weatherDto.getCityName());
        weatherLogEntity.setQueryTime(LocalDateTime.now()); // czas aktualny
        weatherLogEntity.setCityTemp(weatherDto.getMain().getTemp());
        weatherLogEntity.setCityPressure(weatherDto.getMain().getPressure());
        weatherLogEntity.setCityWindSpeed(weatherDto.getWind().getSpeed());
        weatherLogEntity.setCityHumidity(weatherDto.getMain().getHumidity());


        return weatherLogEntity;
    }

//    public static CityEntity convert(CityDto cityDto){
//        CityEntity cityLogEntity = new CityEntity();
//        cityLogEntity.setCityName(cityDto.getCityName());
//
//        return cityLogEntity;
//    }
}
