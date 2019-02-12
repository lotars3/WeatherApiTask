package pl.szymonsmenda.WeatherApiTask.weather.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class WeatherDto {
    private List<TemperatureDto> main;
    private CloudsDto clouds;
    private WindDto wind;


    @JsonProperty("name")
    private String cityName;

    @JsonProperty("dt_txt")
    private String date;


    @Data
    public static class TemperatureDto {
        private double temp;
        @JsonProperty(value = "temp_max")
        private double tempMax;
        @JsonProperty(value = "temp_min")
        private double tempMin;
        private double pressure;
        private double humidity;
    }

    @Data
    public static class WindDto {
        private double speed;
    }


    @Data
    public static class CloudsDto {
        @JsonProperty(value = "all")
        private int clouds;
    }



}
