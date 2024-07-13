package dev.notyouraverage.spring_security.services;

import jakarta.servlet.http.HttpSession;

public interface HomeViewCountService {

    void incrementViewCount(HttpSession httpSession);

    Integer getCurrentViewCount(HttpSession session);
}
