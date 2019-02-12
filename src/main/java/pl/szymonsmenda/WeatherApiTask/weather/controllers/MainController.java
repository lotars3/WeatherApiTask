package pl.szymonsmenda.WeatherApiTask.weather.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.szymonsmenda.WeatherApiTask.weather.services.SessionService;

@Controller
public class MainController {

    final SessionService sessionService;

    public MainController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("userObject", sessionService);
        return "index";
    }
}
