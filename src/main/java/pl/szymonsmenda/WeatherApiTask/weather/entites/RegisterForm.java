package pl.szymonsmenda.WeatherApiTask.weather.entites;

import lombok.Data;

@Data
public class RegisterForm {
    private String username;
    private String email;
    private String password;
}
