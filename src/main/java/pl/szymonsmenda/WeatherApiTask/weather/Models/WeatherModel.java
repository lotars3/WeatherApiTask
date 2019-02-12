package pl.szymonsmenda.WeatherApiTask.weather.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherModel {


    @JsonProperty("name")
    private String cityName;

//
//    @JsonProperty("dt_txt")
//    private String date;

    private List<Temperature> temperatures;

    @Data
    public static class Temperature {
        private double temp;
        @JsonProperty("dt_txt")
        private String date;
    }


}
