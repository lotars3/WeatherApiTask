package pl.szymonsmenda.WeatherApiTask.weather.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szymonsmenda.WeatherApiTask.weather.entites.CityEntity;

import java.util.List;
import java.util.Set;

@Repository
public interface CityRepository extends CrudRepository<CityEntity, Integer> {

    CityEntity findByCityName(String cityName);



}
