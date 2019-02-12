package pl.szymonsmenda.WeatherApiTask.weather.entites;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "weather_log")
public class WeatherLogEntity {
    private @Id @GeneratedValue int id;
    private @Column(name = "city_name") String cityName;
    private @Column(name = "city_temp") double cityTemp;
    private @Column(name = "city_pressure") double cityPressure;
    private @Column(name = "city_wind") double cityWindSpeed;
    private @Column(name = "city_humidity") double cityHumidity;
    private @Column(name = "query_time") LocalDateTime queryTime;


}
