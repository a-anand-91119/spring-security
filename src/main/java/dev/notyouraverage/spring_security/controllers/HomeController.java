package dev.notyouraverage.spring_security.controllers;

import dev.notyouraverage.spring_security.services.HomeViewCountService;
import jakarta.servlet.http.HttpSession;
import java.security.Principal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HomeController {
    private final HomeViewCountService homeViewCountService;

    public HomeController(HomeViewCountService homeViewCountService) {
        this.homeViewCountService = homeViewCountService;
    }

    @GetMapping
    public String home(Principal principal, HttpSession session) {
        log.info(principal.toString());
        homeViewCountService.incrementViewCount(session);
        return "OK";
    }

    @GetMapping("/count")
    public String getCount(HttpSession session) {
        Integer currentViewCount = homeViewCountService.getCurrentViewCount(session);
        return "Current Home View Count %d".formatted(currentViewCount);
    }

}
