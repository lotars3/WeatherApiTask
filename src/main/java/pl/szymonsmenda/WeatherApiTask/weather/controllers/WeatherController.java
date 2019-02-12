package pl.szymonsmenda.WeatherApiTask.weather.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.szymonsmenda.WeatherApiTask.weather.services.SessionService;
import pl.szymonsmenda.WeatherApiTask.weather.services.WeatherLogService;

@Controller
public class WeatherController {

    final private WeatherLogService weatherLogService;
    final SessionService sessionService;

    @Autowired
    public WeatherController(WeatherLogService weatherLogService, SessionService sessionService) {
        this.weatherLogService = weatherLogService;
        this.sessionService = sessionService;
    }

    @GetMapping("/weather")
    public String index(Model model) {
        model.addAttribute("userObject", sessionService);
        if (!sessionService.isLogin()) {
            return "redirect:/login";
        }

        return "weather";
    }


    @PostMapping("/weather")
    public String index(@RequestParam("cityName") String cityName,
                        Model model) {
        model.addAttribute("userObject", sessionService);

        model.addAttribute("weather", weatherLogService.getCurrentWeather(cityName));
        model.addAttribute("forecast", weatherLogService.getForecastWeather(cityName));
        return "weather";
    }
}
