package dice.com.controller;

import dice.com.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
