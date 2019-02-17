package pl.szymonsmenda.WeatherApiTask.weather.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szymonsmenda.WeatherApiTask.weather.entites.CityEntity;
import pl.szymonsmenda.WeatherApiTask.weather.entites.WeatherLogEntity;

import java.util.List;

@Repository
public interface WeatherLogRepository extends CrudRepository<WeatherLogEntity, Integer> {

//    WeatherLogEntity findByCityName(String cityName);

//    List<WeatherLogEntity> findByCity(CityEntity cityEntity);

}
