package pl.szymonsmenda.WeatherApiTask.weather.entites;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user")
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    @JsonIgnore
    private String email;
    @JsonIgnore
    private String password;


    @Column(name = "registered_date")
    private LocalDateTime registerDate;

}




