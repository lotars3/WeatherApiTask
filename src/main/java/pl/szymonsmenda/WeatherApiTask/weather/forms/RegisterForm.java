package pl.szymonsmenda.WeatherApiTask.weather.forms;

import lombok.Data;

@Data
public class RegisterForm {
    private String username;
    private String email;
    private String password;
}
