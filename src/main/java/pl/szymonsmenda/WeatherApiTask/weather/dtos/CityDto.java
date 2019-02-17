package pl.szymonsmenda.WeatherApiTask.weather.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CityDto {


    @JsonProperty("name")
    private String cityName;
}
