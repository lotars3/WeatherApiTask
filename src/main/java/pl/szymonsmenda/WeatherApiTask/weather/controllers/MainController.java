package pl.szymonsmenda.WeatherApiTask.weather.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.szymonsmenda.WeatherApiTask.weather.services.SessionService;

@Controller
public class MainController {
    @Autowired
    private SessionService sessionService;


    @GetMapping("/")
    public String welcome(Model model) {
        model.addAttribute("userObject", sessionService);
        return "index";
    }
}
