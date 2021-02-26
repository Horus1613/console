package ru.horus.console.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import ru.horus.console.model.Request;
import ru.horus.console.service.RequestService;

@RequiredArgsConstructor
@Controller
public class RequestController {
    private final RequestService requestService;

    @PostMapping("/send")
    public void sendRequest(Request request) {
        requestService.sendRequestToOrchestrator(request);
    }
}
