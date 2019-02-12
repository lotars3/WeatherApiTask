package pl.szymonsmenda.WeatherApiTask.weather.services;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.WeatherApiTask.weather.entites.UserEntity;


@Service
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class SessionService {
    private boolean isLogin;
    private UserEntity userEntity;
}
