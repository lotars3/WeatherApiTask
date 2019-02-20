package pl.szymonsmenda.WeatherApiTask.weather.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "weather")
public class WeatherLogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "weather_id")
    private int id;
    private @Column(name = "city_temp")
    double cityTemp;
    private @Column(name = "city_pressure")
    double cityPressure;
    private @Column(name = "city_wind")
    double cityWindSpeed;
    private @Column(name = "city_humidity")
    double cityHumidity;
    private @Column(name = "query_time")
    LocalDateTime queryTime;



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "city_weathers",
            joinColumns = {@JoinColumn(name = "city_id")},
            inverseJoinColumns = {@JoinColumn(name = "weather_id")}
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<CityEntity> citys;

}
