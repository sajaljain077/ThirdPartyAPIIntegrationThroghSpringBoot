package dice.com.Service;

import org.springframework.stereotype.Component;

@Component
public class LoginDetails {
     String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
