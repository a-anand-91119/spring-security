package dev.notyouraverage.spring_security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth2")
public class SecuredController {

    @GetMapping("/secured")
    public String secured() {
        return "Secured Page";
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Public Page";
    }

}
