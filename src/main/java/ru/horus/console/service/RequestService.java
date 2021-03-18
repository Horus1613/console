package ru.horus.console.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.horus.console.controller.MenuController;
import ru.horus.console.model.Control;
import ru.horus.console.model.Mode;
import ru.horus.console.model.Offset;
import ru.horus.console.model.Request;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class RequestService {
    private final MenuController menuController;
    private final RestTemplate restTemplate;

    private static final String orchestratorUrl = "http://5aaa5c7d9775.ngrok.io/request";

    public void sendRequestToOrchestrator(Request request) {
        validateRequest(request);
        log.info("To url {} was send {}", orchestratorUrl, request);
        restTemplate.postForLocation(orchestratorUrl, request);
    }

    private void validateRequest(Request request) {
        try {
            Integer.parseInt(request.getOffset().getX());
            Integer.parseInt(request.getOffset().getY());
        } catch (NumberFormatException ex) {
            menuController.getErrorPage("Bad offset value format");
        }

        if (request.getMode() == Mode.MANUAL) {
            request.setControl(Control.IDLE);
            if (!isValid(request.getOffset())) {
                menuController.getErrorPage("Bad offset value for manual mode");
            }
        }
    }

    public boolean isValid(Offset offset) {
        List<String> fields = List.of(offset.getX(), offset.getY());
        return List.of(-1, 0, 1).containsAll(fields) && fields.stream().filter(val -> Integer.parseInt(val) != 0).count() == 1;
    }
}
