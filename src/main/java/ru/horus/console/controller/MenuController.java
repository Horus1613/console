package ru.horus.console.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.Optional;

@Controller
public class MenuController {

    @GetMapping("/")
    public String getMainPage() {
        return "main";
    }

    @GetMapping("/auto")
    public String getAutoModePage() {
        return "auto";
    }

    @GetMapping("/manual")
    public String getManualModePage() {
        return "manual";
    }

    @GetMapping("/error")
    public ModelAndView getErrorPage(String errorCause) {
        return new ModelAndView("error", Map.of("errorCause", Optional.ofNullable(errorCause).orElse("UNKNOWN ERROR")));
    }
}
