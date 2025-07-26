package dio.web.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
public class WelcomeController {
    @GetMapping
    public String welcome() {
        return "Welcome to My Spring Boot Web API";
    }

    @GetMapping("/admins")
    @PreAuthorize("hasAnyRole('MANAGERS')")
    public String users() {
        return "Authorized admin";
    }

    @GetMapping("/operators")
    @PreAuthorize("hasAnyRole('USERS', 'MANAGERS')")
    public String managers() {
        return "Authorized operator";
    }
}
