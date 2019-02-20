package pl.szymonsmenda.WeatherApiTask.weather.entites;

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




    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,
            mappedBy = "citys")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<WeatherLogEntity> weathers ;



}
