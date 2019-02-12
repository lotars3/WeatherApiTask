package pl.szymonsmenda.WeatherApiTask.weather.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szymonsmenda.WeatherApiTask.weather.entites.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    boolean existsByEmail(String email);

    boolean existsByEmailAndPassword(String email, String password);

    Optional<UserEntity> findByEmailAndPassword(String email, String password);

    Optional<UserEntity> findByEmail(String email);
}
