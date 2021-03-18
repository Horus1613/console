package ru.horus.console.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import ru.horus.console.model.Request;
import ru.horus.console.model.RequestDTO;
import ru.horus.console.service.RequestService;

@RequiredArgsConstructor
@Controller
public class RequestController {
    private final RequestService requestService;

    @PostMapping("/send")
    public RedirectView sendRequest(@ModelAttribute(name = "request") RequestDTO requestDto) {
        requestService.sendRequestToOrchestrator(new Request(requestDto));
        return new RedirectView(String.format("redirect:/%s", requestDto.getMode().toString().toLowerCase()));
    }
}
