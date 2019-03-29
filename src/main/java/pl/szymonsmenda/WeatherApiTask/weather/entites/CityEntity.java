package pl.szymonsmenda.WeatherApiTask.weather.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

import java.util.Set;

@Entity
@Table(name = "city")
@Data
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id")
    private int id;

    @Column(name = "city_name")
    private String cityName;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "city_weathers",
            joinColumns = {@JoinColumn(name = "city_id")},
            inverseJoinColumns = {@JoinColumn(name = "weather_id")}
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<WeatherLogEntity> weathers;


}
