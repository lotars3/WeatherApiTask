package pl.szymonsmenda.WeatherApiTask.weather.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.szymonsmenda.WeatherApiTask.weather.services.AuthService;


@RequestMapping("data")
public class UserRestController implements RestController {
    @Autowired
    private AuthService authService;


    @GetMapping(value = "/user/{email}/{password}", consumes = "application/json")
    public ResponseEntity loginByEmailAndPassword(@PathVariable("email") String email,
                                                  @PathVariable("password") String password,
                                                  @RequestHeader("Api-Key") String key) {
        if (!key.equals("tajnehaslo")) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Key do not exist");
        }
        return authService.findByEmailAndPassword(email, password)
                .map(s -> ResponseEntity.ok(s))
                .orElseGet(() ->
                        ResponseEntity.status(HttpStatus.NOT_FOUND).build());

    }

}

