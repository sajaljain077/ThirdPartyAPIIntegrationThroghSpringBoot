package dice.com.controller;

import dice.com.Service.LoginDetails;
import dice.com.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/weatherSummary")
public class Controller {

    @Autowired
    Service service;
    @GetMapping(path = "/ofLocation", produces = "application/json")
    public ResponseEntity<String> fetchForecastByLocation(@RequestParam("location") String location){
        return service.fetchForecastByLocation(location);
    }


    @GetMapping(path = "/ofLocationByHourly", produces = "application/json")
    public ResponseEntity<String> fetchHourlyForecastByLocation(@RequestParam("location") String location){
        return service.fetchHourlyForecastByLocation(location);
    }

    @PostMapping(path = "/login", produces = "application/json")
    public ResponseEntity<String> login(@RequestBody LoginDetails loginDetails){
        return service.loginAccount(loginDetails);
    }
}
