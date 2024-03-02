package dice.com.Service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface Service {

    public ResponseEntity<String> fetchForecastByLocation(String location);

    public ResponseEntity<Map<String, String>> fetchHourlyForecastByLocation(String location);
}
