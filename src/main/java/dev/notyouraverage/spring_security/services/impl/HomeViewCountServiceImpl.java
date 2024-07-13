package dev.notyouraverage.spring_security.services.impl;

import dev.notyouraverage.spring_security.constants.Constants;
import dev.notyouraverage.spring_security.services.HomeViewCountService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class HomeViewCountServiceImpl implements HomeViewCountService {

    @Override
    public void incrementViewCount(HttpSession httpSession) {
        Object attribute = httpSession.getAttribute(Constants.HOME_VIEW_COUNT);
        int currentViewCount = attribute == null ? 0 : (Integer) attribute;
        httpSession.setAttribute(Constants.HOME_VIEW_COUNT, currentViewCount + 1);
    }

    @Override
    public Integer getCurrentViewCount(HttpSession session) {
        return (Integer) session.getAttribute(Constants.HOME_VIEW_COUNT);
    }
}
