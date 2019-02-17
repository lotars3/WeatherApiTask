package pl.szymonsmenda.WeatherApiTask.weather.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.szymonsmenda.WeatherApiTask.weather.entites.RegisterForm;
import pl.szymonsmenda.WeatherApiTask.weather.services.AuthService;
import pl.szymonsmenda.WeatherApiTask.weather.services.SessionService;


@Controller
public class AuthController {
    @Autowired
    private AuthService authService;
    @Autowired
    private SessionService sessionService;


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("password") String password,
                        Model model) {
        if (!authService.isLogged(email, password)) {
            model.addAttribute("infoAboutLogin", "Nieprawidłowy login lub hasło");
            return "login";
        }
        return "redirect:/weather";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        return "register";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute("registerForm") RegisterForm registerForm,
                           Model model) {
        if (!authService.isRegistered(registerForm)) {
            model.addAttribute("infoAboutRegister", "Email zajęty");
            return "register";
        }
        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout() {
        sessionService.setLogin(false);
        sessionService.setUserEntity(null);

        return "redirect:/";
    }
}




