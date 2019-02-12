package pl.szymonsmenda.WeatherApiTask.weather.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szymonsmenda.WeatherApiTask.weather.entites.WeatherLogEntity;

@Repository
public interface WeatherLogRepository extends CrudRepository<WeatherLogEntity, Integer> {

    WeatherLogEntity findByCityName(String cityName);


//    WeatherLogEntity findAllByCityName();

}
