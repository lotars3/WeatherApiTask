package pl.szymonsmenda.WeatherApiTask.weather.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.WeatherApiTask.weather.entites.UserEntity;
import pl.szymonsmenda.WeatherApiTask.weather.entites.RegisterForm;
import pl.szymonsmenda.WeatherApiTask.weather.repositories.UserRepository;


import java.util.Optional;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private SessionService sessionService;



    public boolean isLogged(String email, String password){
        Optional<UserEntity> userEntity
                = userRepository.findByEmailAndPassword(email, password);
        if(userEntity.isPresent()){
            sessionService.setLogin(true);
            sessionService.setUserEntity(userEntity.get());
        }
        return userEntity.isPresent();
    }

    public boolean isRegistered(RegisterForm registerForm){
        if(userRepository.existsByEmail(registerForm.getEmail())){
            return false;
        }

        UserEntity userEntity = createEntityFromForm(registerForm);
        userRepository.save(userEntity);
        return true;
    }

    private UserEntity createEntityFromForm(RegisterForm registerForm) {
        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(registerForm.getEmail());
        userEntity.setPassword(registerForm.getPassword());
        userEntity.setUsername(registerForm.getUsername());
        return userEntity;
    }

    public Iterable<UserEntity> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<UserEntity> findByEmail(String email){
        return userRepository.findByEmail(email);
    }

    public Optional<UserEntity> findByEmailAndPassword(String email, String password){
        return userRepository.findByEmailAndPassword(email,password);
    }





}
